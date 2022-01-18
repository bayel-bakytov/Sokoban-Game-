import java.io.IOException;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;

public class MyClient extends Thread {
    private Socket socket;
    public MyClient(Socket socket) {
        this.socket = socket;
    }
    
    public void run() {
        System.out.println("socket = " + socket);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             OutputStream outputStream = socket.getOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(outputStream);
        ) {
            String level = in.readLine();
            System.out.println("Client is waiting level : " + level);
            ServerLevels serverLeves = new ServerLevels();
            if (level.equals("7")) {
                serverLeves.getNewLevel(7);
            } else if (level.equals("8")) {
                serverLeves.getNewLevel(8);
            } else if (level.equals("9")) {
                serverLeves.getNewLevel(9);
            }
            out.writeObject(serverLeves);
            socket.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
