import javax.inject.Inject;

public class CheckoutService
{
    private final DiscountFactory discountFactory;

    @Inject
    public CheckoutService(DiscountFactory discountFactory)
    {
        this.discountFactory = discountFactory;
    }

    public double checkout(ShoppingCart cart)
    {
        double total = cart.getCartTotal();
        double discount = discountFactory.getDiscount(cart).getDiscount();

        System.out.println("final price: " + total*discount);
        return total;
    }
}
