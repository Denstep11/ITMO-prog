package network;


import util.ConsoleControl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class Server {
    public static int port = 9999;
    private InetSocketAddress address;
    private final DatagramChannel datagramChannel;
    private final Selector selector;
    private final SelectionKey key;
    public static String s;
    public static String answer = "";//ответ сервера
    public ConsoleControl consoleControl = new ConsoleControl();

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
                ByteBuffer buffer = ByteBuffer.allocate(2048);
                datagramChannel.receive(buffer);
                buffer.flip();
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                SerializationCommands serialcomand = (SerializationCommands) objectInputStream.readObject();
                System.out.println(serialcomand.toString());
                consoleControl.choice(serialcomand.toString(),serialcomand);

                s=serialcomand.toString();
                break;
            } else if (key.isWritable()) {
                address = new InetSocketAddress("localhost", 9998);
                ByteBuffer buffer = ByteBuffer.wrap(answer.getBytes());
                datagramChannel.send(buffer, address);
                buffer.clear();
                break;
            }
        }
    }
}

