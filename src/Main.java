import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new Server(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
