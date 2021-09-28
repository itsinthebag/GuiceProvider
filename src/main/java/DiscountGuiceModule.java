import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.MapBinder;

public class DiscountGuiceModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        MapBinder<DiscountOption, Discountable> mapBinder = MapBinder.newMapBinder(binder(), DiscountOption.class, Discountable.class);
        mapBinder.addBinding(DiscountOption.Big).to(BigDiscount.class);
        mapBinder.addBinding(DiscountOption.Small).to(SmallDiscount.class);
        mapBinder.addBinding(DiscountOption.No).to(NoDiscount.class);

        bind(DiscountFactory.class).to(CartDiscountFactory.class).in(Scopes.SINGLETON);
    }

    public enum DiscountOption {
        Small, Big, No;
    }
}
