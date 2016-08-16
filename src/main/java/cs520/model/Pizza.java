package cs520.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    Crust crust;

    boolean cheese;

    List<String> toppings;

    int quantity;

    public Pizza()
    {
        cheese = true;
        toppings = new ArrayList<String>();
        quantity = 1;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer( crust.toString() );

        sb.append( cheese ? ", Normal Cheese" : ", No Cheese" );

        if( toppings.size() > 0 )
        {
            sb.append( ", with " + toppings.get( 0 ) );
            for( int i = 1; i < toppings.size(); ++i )
                sb.append( ", " + toppings.get( i ) );
        }

        return sb.toString();
    }

    public int getPrice()
    {
        int price = crust.getPrice();

        if( !cheese ) --price;

        return (price + toppings.size()) * quantity;
    }

    public Crust getCrust()
    {
        return crust;
    }

    public void setCrust( Crust crust )
    {
        this.crust = crust;
    }

    public boolean isCheese()
    {
        return cheese;
    }

    public void setCheese( boolean cheese )
    {
        this.cheese = cheese;
    }

    public List<String> getToppings()
    {
        return toppings;
    }

    public void setToppings( List<String> toppings )
    {
        this.toppings = toppings;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity( int quantity )
    {
        this.quantity = quantity;
    }

}
