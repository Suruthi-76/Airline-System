package com.project.airline;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String name = request.getParameter("name");  
        String phonenumber = request.getParameter("phonenumber");  
        String email = request.getParameter("email");  
        String afro = request.getParameter("afro");  
        String ato = request.getParameter("ato"); 
        String gender = request.getParameter("gender"); 
        String adate = request.getParameter("adate"); 
        String atime = request.getParameter("atime"); 
          
        Air e = new Air();  
        e.setName(name);  
        e.setPhonenumber(phonenumber);  
        e.setEmail(email);  
        e.setAfro(afro);
        e.setAto(ato);
        e.setGender(gender);
        e.setAdate(adate);
        e.setAtime(atime);
          
        int status = AirDao.save(e);  
        if (status > 0) {  
            // JavaScript to display a pop-up message
            out.println("<script type='text/javascript'>");
            out.println("alert('Record saved successfully!');");
            out.println("window.location = 'index.html';"); // Redirects to the index.html page
            out.println("</script>");
        } else {  
            out.println("<script type='text/javascript'>");
            out.println("alert('Sorry! Unable to save the record. Please try again.');");
            out.println("window.history.back();"); // Redirects back to the previous form
            out.println("</script>");
        }  
          
        out.close();  
    }  
}
