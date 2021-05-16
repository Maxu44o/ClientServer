import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {

        int port = 8080;

        try (Socket clientSocket = new Socket("localhost", port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            out.println("start");


            Scanner sc = new Scanner(System.in);

            System.out.println(in.readLine());
            System.out.println(in.readLine());
            out.println(sc.nextLine());

            System.out.println(in.readLine());
            out.println(sc.nextLine());

            System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

