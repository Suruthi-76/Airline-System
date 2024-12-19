package com.project.airline;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Adding CSS styles directly to the page
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: sans-serif;");
        out.println("    background-image: linear-gradient(100deg, rgb(8, 61, 125) 20%, rgba(22, 83, 85, 0.5) 70%);");
        out.println("    color: black;");
        out.println("    padding: 20px;");
        out.println("}");
        out.println("form {");
        out.println("    background-color: rgba(255, 255, 255, 0.1);");
        out.println("    padding: 20px;");
        out.println("    margin: 20px auto;");
        out.println("    border: 1px solid white;");
        out.println("    border-radius: 8px;");
        out.println("    width: 30%;");
        out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);");
        out.println("}");
        out.println("label {");
        out.println("    font-weight: bold;");
        out.println("    display: block;");
        out.println("    margin: 10px 0 5px;");
        out.println("}");
        out.println("input {");
        out.println("    width: calc(100% - 20px);");
        out.println("    padding: 10px;");
        out.println("    margin-bottom: 10px;");
        out.println("    border-radius: 4px;");
        out.println("    border: 1px solid #ccc;");
        out.println("}");
        out.println("a {");
        out.println("    text-decoration: none;");
        out.println("    color: #00f;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<a href='index.html' style='color:white;'>Book Another Ticket</a>");
        out.println("<h1 style='text-align:center;'>List of Tickets</h1>");
        
        List<Air> list = AirDao.getAllEmployees();
        
        for (Air e : list) {
            out.println("<form>");
            out.println("<label>Id</label>");
            out.println("<input type='text' value='" + e.getId() + "' readonly>");
            
            out.println("<label>Name</label>");
            out.println("<input type='text' value='" + e.getName() + "' readonly>");
            
            out.println("<label>Phone Number</label>");
            out.println("<input type='text' value='" + e.getPhonenumber() + "' readonly>");
            
            out.println("<label>Email</label>");
            out.println("<input type='text' value='" + e.getEmail() + "' readonly>");
            
            out.println("<label>From</label>");
            out.println("<input type='text' value='" + e.getAfro() + "' readonly>");
            
            out.println("<label>Destination</label>");
            out.println("<input type='text' value='" + e.getAto() + "' readonly>");
            
            out.println("<label>Gender</label>");
            out.println("<input type='text' value='" + e.getGender() + "' readonly>");
            
            out.println("<label>Date</label>");
            out.println("<input type='text' value='" + e.getAdate() + "' readonly>");
            
            out.println("<label>Time</label>");
            out.println("<input type='text' value='" + e.getAtime() + "' readonly>");
            
            out.println("<a href='EditServlet?id=" + e.getId() + "'>Update</a> | ");
            out.println("<a href='DeleteServlet?id=" + e.getId() + "'>Cancel</a>");
            out.println("</form>");
        }
        
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
