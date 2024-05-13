

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
      PrintWriter out=response.getWriter();  
      out.println("<a href='index.html'>Add New Employee</a>");  
      out.println("<h1>Tickets List</h1>");  
        
      List<Air> list=AirDao.getAllEmployees();  
        
      out.print("<table border='1' width='100%'");  
      out.print("<tr><th>Id</th><th>Name</th><th>Phonenumber</th><th>Email</th><th>From</th><th>To</th><th>Gender</th><th>Date</th><th>Time</th><th>Edit</th><th>Delete</th></tr>");  
      for(Air e:list){  
       out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPhonenumber()+"</td><td>"+e.getEmail()+"</td><td>"+e.getAfro()+"</td><td>"+e.getAto()+"</td><td>"+e.getGender()+"</td><td>"+e.getAdate()+"</td><td>"+e.getAtime()+"</td><td><a href='EditServlet?id="+e.getId()+"'>Update</a></td>  <td><a href='DeleteServlet?id="+e.getId()+"'>Cancel</a></td></tr>");  
      }  
      out.print("</table>");  
        
      out.close();  
  }  
}
