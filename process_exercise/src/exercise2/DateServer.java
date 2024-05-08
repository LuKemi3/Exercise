package exercise2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DateServer {
    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6013);

            while (true) {
                Socket client = sock.accept();
                PrintWriter pout = new
                        PrintWriter(client.getOutputStream(), true);

                pout.println("55555\n7777777\n55555".toString());
                client.close();
            }
        }
catch (IOException ioe) {
            System.err.println(ioe);
        }
    }

}
