package task03;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import task02.ITask;

public class TaskServerWhile {
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

        var ois = new ObjectInputStream(socket.getInputStream());
        var oos = new ObjectOutputStream(socket.getOutputStream());
        while (true) {
            ITask task;
            task = (ITask) ois.readObject();

            if (task.getExecNumber() <= 1) break;

            task.exec();

            oos.writeObject(task);
            oos.flush();
        }

        System.out.println("closing server");
        socket.close();
        server.close();
    }
}
