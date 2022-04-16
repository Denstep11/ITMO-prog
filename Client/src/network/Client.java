package network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;

public class Client implements Serializable {
    private static final int port = 9999;
    public final InetSocketAddress address = new InetSocketAddress("localhost",port);
    private final static int TIMEOUT = 5000;

    public static String receive() throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] buf = new byte[2048];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        try {
            socket.setSoTimeout(TIMEOUT);
            socket.receive(packet);
        }
        catch (SocketTimeoutException ex){
            System.out.println("Сервер не отвечат");
        }
        String s = new String(packet.getData());
        socket.close();
        return s.trim();
    }

    public static void send(SerializationCommands command) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(command);
        objectOutputStream.flush();
        byte[] buf = byteArrayOutputStream.toByteArray();
        InetAddress inetaddress = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(buf, buf.length, inetaddress, port);
        socket.send(packet);
        objectOutputStream.close();
        socket.close();
    }
}
