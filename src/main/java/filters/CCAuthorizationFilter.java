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
 * Servlet Filter implementation class CCAuthorizationFilter
 */
@WebFilter("/CCAuthorizationFilter")
public class CCAuthorizationFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public CCAuthorizationFilter() {
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
    	
		String cc = request.getParameter("cc");
    	String month = request.getParameter("month");
    	String year = request.getParameter("year");
    	String ver = request.getParameter("verification");
    	
		if (cc.length() == 16 && !month.isEmpty() && !year.isEmpty() && ver.length() == 3) {
    		chain.doFilter(request, response);
        	
    	} else {

    		
    		requestDispatcher = request.getRequestDispatcher("/jsp/header.jsp");
    		requestDispatcher.include(request, response);
    		
    		requestDispatcher = request.getRequestDispatcher("/jsp/leftColumn.jsp");
    		requestDispatcher.include(request, response);
    		
    		out.println("<div class='center'><b style='color:red;'>Credit Card Authorization Failed</b>" +"</div>");
    		
    		if (cc.length() != 16) {
        		out.println("<div class='center'><b style='color:red;'>Credit Card Number must be 16 digits</b>" +"</div>");
        	}
    		if (ver.length() != 3) {
        		out.println("<div class='center'><b style='color:red;'>Verification Number must be 3 digits</b>" +"</div>");
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
