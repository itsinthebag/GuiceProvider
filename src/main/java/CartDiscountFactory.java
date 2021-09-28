import javax.inject.Inject;

import java.util.Map;

public class CartDiscountFactory implements DiscountFactory
{
    final Map<DiscountGuiceModule.DiscountOption, Discountable> map;

    @Inject
    public CartDiscountFactory(Map<DiscountGuiceModule.DiscountOption, Discountable> map)
    {
        this.map = map;
    }

    @Override
    public Discountable getDiscount(ShoppingCart cart)
    {
        int time = cart.getCheckoutTime();

        if(isSmall(time))
            return map.get(DiscountGuiceModule.DiscountOption.Small);
        else if(isBig(time))
            return map.get(DiscountGuiceModule.DiscountOption.Big);
        return map.get(DiscountGuiceModule.DiscountOption.No);
    }

    public boolean isSmall(int time)
    {
        return time >= 5 && time <= 9;
    }

    public boolean isBig(int time)
    {
        return time >= 0 && time <= 4;
    }
}
