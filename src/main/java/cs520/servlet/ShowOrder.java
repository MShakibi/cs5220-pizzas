package cs520.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520.model.Order;

@WebServlet("/ShowOrder")
public class ShowOrder extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ShowOrder()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // make sure there is an order because a customer can hit this page
        // before the CustomizePizza page.
        Order order = (Order) request.getSession().getAttribute( "order" );
        if( order == null )
            request.getSession().setAttribute( "order", new Order() );

        request.getRequestDispatcher( "/WEB-INF/ShowOrder.jsp" ).forward(
            request, response );
    }

}
