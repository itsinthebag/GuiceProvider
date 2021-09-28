import javax.inject.Inject;
import javax.inject.Provider;

import java.util.Map;
import java.util.Random;

public class DiscountProvider implements Provider<Discountable>
{
    private final Map<Integer, Discountable> map;
    private final Random rand;

    @Inject
    public DiscountProvider(Map<Integer, Discountable> map, Random rand)
    {
        this.map = map;
        this.rand = rand;
    }

    @Override
    public Discountable get()
    {
        return map.get(rand.nextInt(map.size()));
    }
}
