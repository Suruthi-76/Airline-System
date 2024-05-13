import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String phonenumber=request.getParameter("phonenumber");  
        String email=request.getParameter("email");  
        String afro=request.getParameter("afro");  
        String ato=request.getParameter("ato"); 
        String gender=request.getParameter("gender"); 
        String adate=request.getParameter("adate"); 
        String atime=request.getParameter("atime"); 
          
        Air e=new Air();  
        e.setName(name);  
        e.setPhonenumber(phonenumber);  
        e.setEmail(email);  
        e.setAfro(afro);
        e.setAto(ato);
        e.setGender(gender);
        e.setAdate(adate);
        e.setAtime(atime);
          
        int status=AirDao.save(e);  
        if(status>0){  
        	
        	out.print("<p style='color: white;'>Record saved successfully!</p>"); 
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
}
