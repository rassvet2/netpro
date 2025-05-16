package task02;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TaskClientOnce {
    public static final String DEFAULT_HOST = "localhost";

    public static void main(String[] args) throws Exception {
        String host = args.length >= 2 ? args[0] : DEFAULT_HOST;
        int port = args.length >= 2 ? Integer.parseInt(args[1]) : TaskServerOnce.DEFAULT_PORT;

        Socket socket = new Socket(host, port);
        System.out.println("connection established");
        System.out.println(
            "local : " + socket.getLocalAddress() + ":" + socket.getLocalPort()
            + " --- " + socket.getInetAddress() + ":" + socket.getPort() + " : remote");


        TaskObject task = new TaskObject();
        task.setExecNumber(100000);
        var oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(task);
        oos.flush();

        var ois = new ObjectInputStream(socket.getInputStream());
        task = (TaskObject) ois.readObject();

        System.out.println("result: " + task.getResult());

        socket.close();
    }
}
