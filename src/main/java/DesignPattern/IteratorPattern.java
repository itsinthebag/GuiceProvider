package DesignPattern;

public class IteratorPattern
{
    public static void main(String[] args)
    {
        ArrayList_<String> al = new ArrayList_();
        for(int i=0; i<10; i++){
            al.add("" + i);
        }

        //System.out.println(al.size());
        Iterator_ itr = al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

interface Collection_<T> {
    int size();
    void add(T t);
}

interface Iterator_<T> {
    boolean hasNext();
    T next();
}

class ArrayList_<T> implements Collection_<T> {
    int i = 0;
    T[] objects = (T[]) new Object[10];

    @Override
    public int size()
    {
        return objects.length;
    }

    @Override
    public void add(T t)
    {
        objects[i] = t;
        i++;
    }

    public Iterator_<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_<T> {
        int cur = 0;

        @Override
        public boolean hasNext()
        {
            return cur < i;
        }

        @Override
        public T next()
        {
            return objects[cur++];
        }
    }
}
