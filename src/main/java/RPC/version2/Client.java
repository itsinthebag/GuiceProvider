package RPC.version2;

import java.io.IOException;

public class Client
{
    public static void main(String[] args)
            throws IOException
    {
        Stub stub = new Stub(); //proxy
        System.out.println(stub.findUserById(123));
    }
}
