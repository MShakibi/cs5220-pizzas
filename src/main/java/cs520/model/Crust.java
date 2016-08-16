package cs520.model;

public class Crust {

    String name;

    int price;

    public Crust( String name, int price )
    {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString()
    {
        return name + " Crust";
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice( int price )
    {
        this.price = price;
    }

}
