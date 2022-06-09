package DesignPattern;

public class Bridge
{
    public static void main(String[] args)
    {
        GG gg = new GG();
        MM mm = new MM();
        Gift gift = new MindGift(new Book());

        gg.gift(mm, gift);
    }
}

class GG {
    public void gift(MM mm, Gift gift){
        //...
    }
}

class MM {}

abstract class Gift {
    GiftImpl gi;

    public Gift(GiftImpl gi){
        this.gi = gi;
    }
}

class MindGift extends Gift {
    public MindGift(GiftImpl gi)
    {
        super(gi);
    }
}
class MoneyGift extends Gift {
    public MoneyGift(GiftImpl gi)
    {
        super(gi);
    }
}

abstract class GiftImpl {}

class Book extends GiftImpl {}
class Car extends GiftImpl {}
