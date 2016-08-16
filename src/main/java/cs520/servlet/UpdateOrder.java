package cs520.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520.model.Order;

@WebServlet("/UpdateOrder")
public class UpdateOrder extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UpdateOrder()
    {
        super();
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // again, make sure there is an order because a customer can hit this
        // page before other pages.
        Order order = (Order) request.getSession().getAttribute( "order" );
        if( order == null )
        {
            order = new Order();
            request.getSession().setAttribute( "order", order );
        }

        // there are two ways to get all the parameter names:
        // . request.getParameterNames()
        // . request.getParameterMap().keySet()
        // I don't like using Enumeration so I use getParameterMap() here.
        for( String param : request.getParameterMap().keySet() )
            if( param.startsWith( "quantity-" ) )
            {
                int index = Integer.parseInt( param.substring( "quantity-".length() ) );
                int quantity = Integer.parseInt( request.getParameter( param ) );
                order.getPizzas().get( index ).setQuantity( quantity );
            }

        response.sendRedirect( "ShowOrder" );
    }

}
