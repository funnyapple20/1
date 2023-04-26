import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String args[]) {
        try {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket socket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            System.out.println("Enter two integers separated by a comma:");
            String input = inFromUser.readLine();
            sendData = input.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 1234);
            socket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String output = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Result: " + output);
            socket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String args[]) {
        try {
            DatagramSocket socket = new DatagramSocket(1234);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String input = new String(receivePacket.getData(), 0, receivePacket.getLength());
                String[] inputArray = input.split(",");
                int num1 = Integer.parseInt(inputArray[0]);
                int num2 = Integer.parseInt(inputArray[1]);
                int result = num1 + num2;
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                String output = Integer.toString(result);
                sendData = output.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
