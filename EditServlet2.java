package com.project.airline;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
              throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String sid = request.getParameter("id");  
        int id = Integer.parseInt(sid);  
        String name = request.getParameter("name");  
        String phonenumber = request.getParameter("phonenumber");  
        String email = request.getParameter("email");  
        String afro = request.getParameter("afro");  
        String ato = request.getParameter("ato");
        String gender = request.getParameter("gender");
        String adate = request.getParameter("adate");
        String atime = request.getParameter("atime");
          
        Air e = new Air();  
        e.setId(id);  
        e.setName(name);  
        e.setPhonenumber(phonenumber);  
        e.setEmail(email);  
        e.setAfro(afro);  
        e.setAto(ato);
        e.setGender(gender);
        e.setAdate(adate);
        e.setAtime(atime); 
          
        int status = AirDao.update(e);  
        if (status > 0) {  
            // JavaScript to display a success pop-up message
            response.getWriter().println("<script type='text/javascript'>");
            response.getWriter().println("alert('Ticket updated successfully!');");
            response.getWriter().println("window.location = 'ViewServlet';");  // Redirect to the ViewServlet
            response.getWriter().println("</script>");
        } else {  
            // JavaScript to display a failure pop-up message
            response.getWriter().println("<script type='text/javascript'>");
            response.getWriter().println("alert('Sorry! Unable to update the record.');");
            response.getWriter().println("window.location = 'ViewServlet';");  // Redirect to the ViewServlet
            response.getWriter().println("</script>");
        }  
          
        out.close();  
    }  
}
