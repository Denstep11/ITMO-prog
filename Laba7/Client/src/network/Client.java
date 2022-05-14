package network;

import com.company.ClientApp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;

public class Client implements Serializable {
    public static String login;
    public static String password;
    private static int port;
    private final static int TIMEOUT = 5000;

    public static String receive() throws IOException {
        DatagramSocket socket = new DatagramSocket(port);
        String s = "";
        while (true){
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.setSoTimeout(TIMEOUT);
                socket.receive(packet);
                String k= new String(packet.getData());
                if(k.trim().equals("end_answer")){
                    break;
                }
                s=s+k.trim();
            }
            catch (SocketTimeoutException ex){
                System.out.println("Сервер не отвечат");
            }
        }
        socket.close();
        return s.trim();
    }

    public static void send(SerializationCommands command) throws IOException {
        command.setLogin(login);
        command.setPassword(password);
        DatagramSocket socket = new DatagramSocket();
        command.setPort(socket.getLocalPort());
        port = socket.getLocalPort();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(command);
        objectOutputStream.flush();
        byte[] buf = byteArrayOutputStream.toByteArray();
        InetAddress inetaddress = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(buf, buf.length, inetaddress, 9900);
        socket.send(packet);
        objectOutputStream.close();
        socket.close();
    }
}
