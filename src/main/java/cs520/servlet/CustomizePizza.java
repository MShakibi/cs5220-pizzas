package cs520.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520.model.Crust;
import cs520.model.Order;
import cs520.model.Pizza;

@WebServlet(urlPatterns = "/CustomizePizza", loadOnStartup = 1)
public class CustomizePizza extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CustomizePizza()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        List<Crust> crusts = new ArrayList<Crust>();
        crusts.add( new Crust( "Large Orig", 11 ) );
        crusts.add( new Crust( "Medium Orig", 9 ) );
        crusts.add( new Crust( "Large Thin", 11 ) );

        List<String> toppings = new ArrayList<String>();
        toppings.add( "Pepperoni" );
        toppings.add( "Sausage" );
        toppings.add( "Bacon" );
        toppings.add( "Pineapple" );

        // store the data in application scope (i.e. servlet context).
        ServletContext context = getServletContext();
        context.setAttribute( "crusts", crusts );
        context.setAttribute( "toppings", toppings );
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // forward to a JSP (i.e. view)
        request.getRequestDispatcher( "/WEB-INF/CustomizePizza.jsp" ).forward(
            request, response );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        Pizza pizza = new Pizza();

        // crust
        int crustIndex = Integer.parseInt( request.getParameter( "crust" ) );
        List<Crust> crusts = (List<Crust>) getServletContext().getAttribute(
            "crusts" );
        pizza.setCrust( crusts.get( crustIndex ) );

        // cheese
        if( request.getParameter( "cheese" ).equals( "0" ) )
            pizza.setCheese( false );

        // toppings
        String toppings[] = request.getParameterValues( "topping" );
        if( toppings != null ) for( String topping : toppings )
            pizza.getToppings().add( topping );

        // add the pizza to an order
        Order order = (Order) request.getSession().getAttribute( "order" );
        if( order == null )
        {
            order = new Order();
            request.getSession().setAttribute( "order", order );
        }
        order.getPizzas().add( pizza );

        // redirect to the order page
        response.sendRedirect( "ShowOrder" );
    }

}
