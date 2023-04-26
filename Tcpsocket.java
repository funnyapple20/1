import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("Enter the first number: ");
        int num1 = Integer.parseInt(input.readLine());
        System.out.print("Enter the second number: ");
        int num2 = Integer.parseInt(input.readLine());

        output.println(num1);
        output.println(num2);

        int sum = Integer.parseInt(serverInput.readLine());
        System.out.println("The sum is: " + sum);

        socket.close();
    }
}
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            int num1 = Integer.parseInt(input.readLine());
            int num2 = Integer.parseInt(input.readLine());
            int sum = num1 + num2;

            output.println(sum);

            socket.close();
            System.out.println("Client disconnected.");
        }
    }
}
