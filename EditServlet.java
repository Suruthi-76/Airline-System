

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();    
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        Air e=AirDao.getEmployeeById(id);  
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Edit Ticket</title>");
	        out.println("<style>");
	        out.println("body {background-image: linear-gradient(100deg, rgb(8, 61, 125) 20%, rgba(22, 83, 85, 0.5) 70%); }");
	        out.println(".container {");
	        out.println("  width: 50%;");
	        out.println("  margin: 0 auto;");
	        out.println("}");
	        out.println(".container input[type='text'], .container input[type='email'], .container select, .container input[type='date'], .container input[type='time'] {");
	        out.println("  width: 100%;");
	        out.println("  padding: 12px 20px;");
	        out.println("  margin: 8px 0;");
	        out.println("  display: inline-block;");
	        out.println("  border: 1px solid #ccc;");
	        out.println("  border-radius: 4px;");
	        out.println("  box-sizing: border-box;");
	        out.println("}");
	        out.println(".container input[type='submit'] {");
	        out.println("  width: 100%;");
	        out.println("  background-color: #4CAF50;");
	        out.println("  color: white;");
	        out.println("  padding: 14px 20px;");
	        out.println("  margin: 8px 0;");
	        out.println("  border: none;");
	        out.println("  border-radius: 4px;");
	        out.println("  cursor: pointer;");
	        out.println("}");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div class='container'>");
	        out.println("<h1>Update Ticket</h1>");  
	        out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<input type='hidden' name='id' value='"+e.getId()+"'/>");
	        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
	        out.print("<tr><td>Phone Number:</td><td><input type='text' name='phonenumber' value='"+e.getPhonenumber()+"'/></td></tr>");  
	        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
	        out.print("<tr><td>From:</td><td><select name='afro'>");  
	        out.print("<option value='India'"+(e.getAfro().equals("India")?" selected":"")+">India</option>");  
	        out.print("<option value='USA'"+(e.getAfro().equals("USA")?" selected":"")+">USA</option>");  
	        out.print("<option value='UK'"+(e.getAfro().equals("UK")?" selected":"")+">UK</option>");  
	        out.print("<option value='China'"+(e.getAfro().equals("China")?" selected":"")+">China</option>");  
	        out.print("<option value='Japan'"+(e.getAfro().equals("Japan")?" selected":"")+">Japan</option>");  
	        out.print("<option value='Nepal'"+(e.getAfro().equals("Nepal")?" selected":"")+">Nepal</option>");  
	        out.print("<option value='America'"+(e.getAfro().equals("America")?" selected":"")+">America</option>");  
	        out.print("<option value='Pakistan'"+(e.getAfro().equals("Pakistan")?" selected":"")+">Pakistan</option>");  
	        out.print("<option value='Australia'"+(e.getAfro().equals("Australia")?" selected":"")+">Australia</option>");  
	        out.print("<option value='Antarctica'"+(e.getAfro().equals("Antarctica")?" selected":"")+">Antarctica</option>");  
	        out.print("</select></td></tr>");  
	        out.print("<tr><td>To:</td><td><select name='ato'>");  
	        out.print("<option value='India'"+(e.getAto().equals("India")?" selected":"")+">India</option>");  
	        out.print("<option value='USA'"+(e.getAto().equals("USA")?" selected":"")+">USA</option>");  
	        out.print("<option value='UK'"+(e.getAto().equals("UK")?" selected":"")+">UK</option>");  
	        out.print("<option value='China'"+(e.getAto().equals("China")?" selected":"")+">China</option>");  
	        out.print("<option value='Japan'"+(e.getAto().equals("Japan")?" selected":"")+">Japan</option>");  
	        out.print("<option value='Nepal'"+(e.getAto().equals("Nepal")?" selected":"")+">Nepal</option>");  
	        out.print("<option value='America'"+(e.getAto().equals("America")?" selected":"")+">America</option>");  
	        out.print("<option value='Pakistan'"+(e.getAto().equals("Pakistan")?" selected":"")+">Pakistan</option>");  
	        out.print("<option value='Australia'"+(e.getAto().equals("Australia")?" selected":"")+">Australia</option>");  
	        out.print("<option value='Antarctica'"+(e.getAto().equals("Antarctica")?" selected":"")+">Antarctica</option>");  
	        out.print("</select></td></tr>");  
	        out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+e.getGender()+"'/></td></tr>");  
	        out.print("<tr><td>Date:</td><td><input type='date' name='adate' value='"+e.getAdate()+"'/></td></tr>");  
	        out.print("<tr><td>Time:</td><td><input type='time' name='atime' value='"+e.getAtime()+"'/></td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>"); 
	        out.println("</div>");
	        out.println("</body>");
	        out.println("</html>");
	        out.close();  
	    }  
	}




