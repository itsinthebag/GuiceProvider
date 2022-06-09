package Bytecode;

import java.io.Serializable;

public class ByteCode_interfaces implements Cloneable, Serializable
{
    int i=888;

    public ByteCode_interfaces(int i)
    {
        this.i = i;
    }

    public ByteCode_interfaces()
    {
    }

    public void helper(){};
}
