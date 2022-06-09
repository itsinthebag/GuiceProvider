package RPC.version1;

import RPC.common.IUserService;
import RPC.common.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private static boolean running = true;

    public static void main(String[] args)
            throws IOException
    {
        ServerSocket ss = new ServerSocket(8888);
        while(running){
            Socket s = ss.accept();
            process(s);
            s.close();
        }
    }

    private static void process(Socket s)
            throws IOException
    {
        InputStream in = s.getInputStream();
        DataInputStream dis = new DataInputStream(in);

        int id = dis.readInt();
        IUserService service = new IUserServiceImpl();
        User user = service.findUserById(id);

        OutputStream out = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
    }
}
