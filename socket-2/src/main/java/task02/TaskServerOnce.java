package task02;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskServerOnce {
    public static final int DEFAULT_PORT = 5053;

    public static void main(String[] args) throws Exception {
        int port = args.length >= 1 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        ServerSocket server = new ServerSocket(port);

        System.out.println("awaiting connection on port: " + port);
        Socket socket = server.accept();
        System.out.println("connection established");
        System.out.println(
            "local : " + socket.getLocalAddress() + ":" + socket.getLocalPort()
            + " --- " + socket.getInetAddress() + ":" + socket.getPort() + " : remote");

        TaskObject task;
        var ois = new ObjectInputStream(socket.getInputStream());
        task = (TaskObject) ois.readObject();

        task.exec();

        var oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(task);
        oos.flush();

        System.out.println("closing server");
        socket.close();
        server.close();
    }
}
