package DesignPattern;

public class Prototype
{
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
        Employee e1 = new Employee(0, 0, new Location(0, 0));
        Employee e2 = (Employee) e1.clone();

        System.out.println(e1.location==e2.location);
        e1.location.x = 1;
        System.out.println(e1);
        System.out.println(e2);
    }
}

class Employee implements Cloneable {
    int id;
    int age;
    Location location;

    public Employee(int id, int age, Location location)
    {
        this.id = id;
        this.age = age;
        this.location = location;
    }

    @Override
    public Object clone()
            throws CloneNotSupportedException
    {
        Employee tmp = (Employee) super.clone();
        tmp.location = (Location) this.location.clone();
        return tmp;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", location=" + location +
                '}';
    }
}

class Location implements Cloneable {
    int x;
    int y;

    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString()
    {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
