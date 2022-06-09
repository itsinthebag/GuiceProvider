package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverSourceEvent
{
    public static void main(String[] args)
    {
        Baby baby = new Baby();
        baby.wakeup();
    }
}

class Baby {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
    }

    public void wakeup(){
        cry = true;

        Event event = new Event(1000, this);
        for(Observer observer: observers){
            observer.action(event);
        }
    }
}

class Event {
    long ts;
    Object source;

    public Event(long ts, Object source)
    {
        this.ts = ts;
        this.source = source;
    }
}

interface Observer {
    void action(Event event);
}

class Dad implements Observer {

    @Override
    public void action(Event event)
    {
        if(event.ts < 100)
            return;
        System.out.println("dad is here");
    }
}

class Mom implements Observer {

    @Override
    public void action(Event event)
    {
        if(!(event.source.getClass() == Baby.class))
            return;
        System.out.println("mom is here");
    }
}

