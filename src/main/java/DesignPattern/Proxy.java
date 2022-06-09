package DesignPattern;

public class Proxy
{
    public static void main(String[] args)
    {
        new TimeProxy(new LogProxy(new Tank())).move();
    }


}
class Tank implements Movable {


    @Override
    public void move()
    {
        System.out.println("tank started");
    }
}

interface Movable {
    void move();
}

class LogProxy implements Movable {
    Movable m;

    public LogProxy(Movable m)
    {
        this.m = m;
    }

    @Override
    public void move()
    {
        System.out.println("logging");
        m.move();
    }
}

class TimeProxy implements Movable {
    Movable m;

    public TimeProxy(Movable m)
    {
        this.m = m;
    }

    @Override
    public void move()
    {
        System.out.println(System.currentTimeMillis());
        m.move();
    }
}