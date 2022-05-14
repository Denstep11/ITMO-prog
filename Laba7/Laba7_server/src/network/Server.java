package network;


import util.ConsoleControl;
import util.Treatment;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.concurrent.ForkJoinPool;

public class Server {
    public static int port = 9900;
    private static InetSocketAddress address;
    private static  DatagramChannel datagramChannel;
    private static Selector selector;
    private static  SelectionKey key;
    public String answer = "";//ответ сервера
    public ForkJoinPool forkJoinPool = new ForkJoinPool();
    public SerializationCommands serialcomand;

    public Server() throws IOException {
        datagramChannel = DatagramChannel.open();
        selector = Selector.open();
        address = new InetSocketAddress("localhost", port);
        datagramChannel.bind(address);
        datagramChannel.configureBlocking(false);
        key = datagramChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }


    public void run() throws IOException, ClassNotFoundException {
        while (true) {
            selector.select();
            if (key.isReadable()) {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                datagramChannel.receive(buffer);
                buffer.flip();
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                SerializationCommands serialcomand = (SerializationCommands) objectInputStream.readObject();
                System.out.println(serialcomand.toString());
                Treatment treatment = new Treatment(serialcomand);
                forkJoinPool.invoke(treatment);
                //consoleControl.choice(serialcomand.toString(), serialcomand);
                break;
            }
        }
    }
    public static void send(String answer, int port) throws IOException, ClassNotFoundException {
        while (true){
            if (key.isWritable()) {
                address = new InetSocketAddress("localhost", port);
                int t = 0;
                for (int i = 0; i < answer.length(); i = i + 100) {
                    t = i;
                    if (answer.length()-i < 100) {
                        ByteBuffer buffer = ByteBuffer.wrap(answer.substring(t, answer.length()).getBytes());
                        datagramChannel.send(buffer, address);
                        buffer.clear();
                    } else {
                        ByteBuffer buffer = ByteBuffer.wrap(answer.substring(t, t + 100).getBytes());
                        datagramChannel.send(buffer, address);
                        buffer.clear();
                    }
                }
                ByteBuffer buffer1 = ByteBuffer.wrap("end_answer".getBytes());
                datagramChannel.send(buffer1, address);
                buffer1.clear();
                break;
            }
        }
    }
}
