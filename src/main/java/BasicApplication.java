import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicApplication
{
    private final CheckoutService service;

    @Inject
    public BasicApplication(CheckoutService service)
    {
        this.service = service;
    }

    private void start()
    {
        while(true){
            service.checkout(getCheckout());
        }
    }

    private ShoppingCart getCheckout()
    {
        ShoppingCart cart = new ShoppingCart();
        cart.setCartTotal(inputTotal());
        cart.setCheckoutTime(inputTime());
        return cart;
    }

    private int inputTime()
    {
        String time = null;
        System.out.println("Enter time: ");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            time = bufferedReader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return Integer.valueOf(time);
    }

    private double inputTotal()
    {
        String total = null;
        System.out.println("Enter total: ");
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            total = bufferedReader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return Double.valueOf(total);
    }


    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new DiscountGuiceModule());
        BasicApplication basicApplication = injector.getInstance(BasicApplication.class);
        basicApplication.start();
    }
}
