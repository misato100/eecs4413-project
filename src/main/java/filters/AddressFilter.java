package filters;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class AddressFilter
 */
@WebFilter("/AddressFilter")
public class AddressFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AddressFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	RequestDispatcher requestDispatcher;
    	
		String addr = request.getParameter("address");
    	String city = request.getParameter("city");
    	String prov = request.getParameter("province");
    	String code = request.getParameter("code");

		
		if (!addr.isEmpty() && !city.isEmpty() && !prov.isEmpty() && !code.isEmpty()) {
    		chain.doFilter(request, response);
        	
    	} else {

    		
    		requestDispatcher = request.getRequestDispatcher("/jsp/header.jsp");
    		requestDispatcher.include(request, response);
    		
    		requestDispatcher = request.getRequestDispatcher("/jsp/leftColumn.jsp");
    		requestDispatcher.include(request, response);
    		
    		if (addr.isEmpty()) {
        		out.println("<div class='center'><b style='color:red;'>Address cannot be empty</b>" +"</div>");
        	}
    		if (city.isEmpty()) {
        		out.println("<div class='center'><b style='color:red;'>City cannot be empty</b>" +"</div>");
        	}
    		if (code.isEmpty()) {
        		out.println("<div class='center'><b style='color:red;'>Postal Code cannot be empty</b>" +"</div>");
        	}
    		
    		requestDispatcher = request.getRequestDispatcher("/jsp/checkout.jsp");
    		requestDispatcher.include(request, response);
    	}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
