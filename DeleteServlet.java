package com.project.airline;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
        String sid = request.getParameter("id");  
        int id = Integer.parseInt(sid);  
        int status = AirDao.delete(id);  // Assuming AirDao.delete() returns the number of rows affected.
        
        response.setContentType("text/html");  
        if (status > 0) {  
            // JavaScript to display a success pop-up message
            response.getWriter().println("<script type='text/javascript'>");
            response.getWriter().println("alert('Ticket deleted successfully!');");
            response.getWriter().println("window.location = 'ViewServlet';");  // Redirect to the ViewServlet
            response.getWriter().println("</script>");
        } else {  
            // JavaScript to display a failure pop-up message
            response.getWriter().println("<script type='text/javascript'>");
            response.getWriter().println("alert('Sorry! Unable to delete the record.');");
            response.getWriter().println("window.location = 'ViewServlet';");  // Redirect to the ViewServlet
            response.getWriter().println("</script>");
        }
    }  
}
