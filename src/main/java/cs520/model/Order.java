package cs520.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    List<Pizza> pizzas;

    public Order()
    {
        pizzas = new ArrayList<Pizza>();
    }

    public List<Pizza> getPizzas()
    {
        return pizzas;
    }

    public void setPizzas( List<Pizza> pizzas )
    {
        this.pizzas = pizzas;
    }

    public int getTotal()
    {
        int total = 0;
        for( Pizza pizza : pizzas )
            total += pizza.getPrice();

        return total;
    }

}
