package myhibernate.web;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Product has been logged in succesfully!<br>");


        String barcode = request.getParameter("Barcode");
        out.println("<br>Item with barcode:"+barcode);
        String name = request.getParameter("Name");
        out.println("<br>Item with name:"+name);
        String color = request.getParameter("Color");
        out.println("<br>Item with color:"+color);
        String description = request.getParameter("Description");
        out.println("<br>Item with description:"+description);
      }  
}