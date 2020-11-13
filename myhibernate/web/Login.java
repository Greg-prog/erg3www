package myhibernate.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myhibernate.model.*;
import myhibernate.dao.*;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ItemDao loginDao;
	
	public void init() {
        loginDao = new	ItemDao();
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	response.setContentType("text/html");
    	 RequestDispatcher rs;
    	 String barcode = request.getParameter("Barcode");
         boolean res = loginDao.checkBase(barcode);
         PrintWriter out = response.getWriter();
         if (res){//loginDao.checkBase(barcode,response)) {
        	 String name = request.getParameter("Name");
        	 String color = request.getParameter("Color");
        	 String description = request.getParameter("Description");
         	//grafw items;
        	 myItem item = new myItem();
        	 item.setBarcode(barcode);
        	 item.setColor(color);
        	 item.setName(name);
        	 item.setDescription(description);
        	 loginDao.saveItem(item);
        	 
             rs = request.getRequestDispatcher("Welcome");
             rs.forward(request, response);
         } else {
             out.println("Barcode already exists try another one");
            
             rs = request.getRequestDispatcher("form.html");
             rs.include(request, response);
         }
    } 
}
 