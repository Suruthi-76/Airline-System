package com.project.airline;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        out.println("    background-image: linear-gradient(70deg, rgb(8, 61, 125) 20%, rgba(22, 83, 85, 0.5) 70%);");
        out.println("}");
        out.println("form {");
        out.println("    position: absolute;");
        out.println("    left: 500px;");
        out.println("    padding: 20px;");
        out.println("}");
        out.println("input {");
        out.println("    width: 200px;");
        out.println("    height: 40px;");
        out.println("}");
        out.println("select {");
        out.println("    width: 200px;");
        out.println("    height: 40px;");
        out.println("}");
        out.println("table {");
        out.println("    width: 100%;");
        out.println("    border-collapse: collapse;");
        out.println("    margin-top: 20px;");
        out.println("}");
        out.println("th, td {");
        out.println("    border: 1px solid #ddd;");
        out.println("    padding: 8px;");
        out.println("    text-align: center;");
        out.println("}");
        out.println("th {");
        out.println("    background-color: rgb(8, 61, 125);");
        out.println("    color: white;");
        out.println("}");
        out.println("a {");
        out.println("    text-decoration: none;");
        out.println("    color: red;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<a href='index.html'>Book Another Ticket</a>");
        out.println("<h1 style='text-align:center; color:white;'>List of Tickets</h1>");
        
        List<Air> list = AirDao.getAllEmployees();
        
        out.print("<table>");
        out.print("<tr><th>Id</th><th>Name</th><th>Phone Number</th><th>Email</th><th>From</th><th>Destination</th><th>Gender</th><th>Date</th><th>Time</th><th>Change</th><th>Cancel</th></tr>");
        for (Air e : list) {
            out.print("<tr>");
            out.print("<td>" + e.getId() + "</td>");
            out.print("<td>" + e.getName() + "</td>");
            out.print("<td>" + e.getPhonenumber() + "</td>");
            out.print("<td>" + e.getEmail() + "</td>");
            out.print("<td>" + e.getAfro() + "</td>");
            out.print("<td>" + e.getAto() + "</td>");
            out.print("<td>" + e.getGender() + "</td>");
            out.print("<td>" + e.getAdate() + "</td>");
            out.print("<td>" + e.getAtime() + "</td>");
            out.print("<td><a href='EditServlet?id=" + e.getId() + "'>Update</a></td>");
            out.print("<td><a href='DeleteServlet?id=" + e.getId() + "'>Cancel</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
        
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
