import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {
    Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String login = null;
        String password = null;

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner in = new Scanner(socket.getInputStream())) {

            if (in.hasNext() && in.nextLine().equals("exit")) {
                out.println(String.format("Connection on port %d was closed", socket.getPort()));
            } else {
                out.println(String.format("New Connection on port %d", socket.getPort()));
                out.println("Write the LOGIN");
                if (in.hasNextLine()) {
                    login = in.nextLine();
                }
                out.println("Write the PASSWORD");
                if (in.hasNextLine()) {
                    password = in.nextLine();
                }

                if (login.equals("admin") && password.equals("admin")) {
                    out.println(String.format("Hello master"));
                } else {
                    out.println(String.format("Hello guest"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



