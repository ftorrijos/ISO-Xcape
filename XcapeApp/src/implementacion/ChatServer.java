package implementacion;

import java.io.*;
import java.util.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Server class 
public class ChatServer {

    int port;
    ServerSocket server = null;
    Socket client = null;
    ExecutorService pool = null;
    int clientcount = 0;

    public static void main(String[] args) throws IOException {
        ChatServer ser = new ChatServer(5000);
        ser.startServer();
    }

    ChatServer(int port){
        this.port = port;
        pool = Executors.newFixedThreadPool(5);
        
    }

    public void startServer() throws IOException {

        server = new ServerSocket(5000);
        System.out.println("Server Booted");
        System.out.println("Any client can stop the server by sending -1");
        while (true) {
            client = server.accept();
            clientcount++;
            ServerThread runnable = new ServerThread(client, clientcount, null);
            pool.execute(runnable);
        }

    }

    private static class ServerThread implements Runnable {

        ChatServer server = null;
        Socket client = null;
        BufferedReader cin;
        PrintStream cout;
        Scanner sc = new Scanner(System.in);
        int id;
        String s;

        ServerThread(Socket client, int count, ChatServer server) throws IOException {

            this.client = client;
            this.server = server;
            this.id = count;
            System.out.println("Connection " + id + "established with client " + client);

            cin = new BufferedReader(new InputStreamReader(client.getInputStream()));
            cout = new PrintStream(client.getOutputStream());

        }

        @Override
        public void run() {
            int x = 1;
            try {
                while (true) {
                    s = cin.readLine();

                    System.out.print("Client(" + id + ") :" + s + "\n");
                    System.out.print("Server : ");
                    //s=stdin.readLine();
                    s = sc.nextLine();
                    if (s.equalsIgnoreCase("bye")) {
                        cout.println("BYE");
                        x = 0;
                        System.out.println("Connection ended by server");
                        break;
                    }
                    cout.println(s);
                }

                cin.close();
                client.close();
                cout.close();
                if (x == 0) {
                    System.out.println("Server cleaning up.");
                    System.exit(0);
                }
            } catch (IOException ex) {
                System.out.println("Error : " + ex);
            }

        }
    }
}
