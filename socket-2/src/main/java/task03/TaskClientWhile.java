package task03;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import task02.ITask;
import task02.TaskObject;

public class TaskClientWhile {
    public static final String DEFAULT_HOST = "localhost";

    public static void main(String[] args) throws Exception {
        String host = args.length >= 2 ? args[0] : DEFAULT_HOST;
        int port = args.length >= 2 ? Integer.parseInt(args[1]) : TaskServerWhile.DEFAULT_PORT;

        Socket socket = new Socket(host, port);
        System.out.println("connection established");
        System.out.println(
            "local : " + socket.getLocalAddress() + ":" + socket.getLocalPort()
            + " --- " + socket.getInetAddress() + ":" + socket.getPort() + " : remote");

        var oos = new ObjectOutputStream(socket.getOutputStream());
        var ois = new ObjectInputStream(socket.getInputStream());
        while (true) {
            int n = 10000000;

            ITask task = new TaskObject();
            task.setExecNumber(n);
            oos.writeObject(task);
            oos.flush();

            if (n <= 1) break;

            task = (ITask) ois.readObject();

            System.out.println("result: " + task.getResult());
        }

        socket.close();
    }
}
