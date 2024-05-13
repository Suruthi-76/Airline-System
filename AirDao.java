import java.util.*;  
import java.sql.*;  
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AirDao")
public class AirDao extends HttpServlet {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
        	Class.forName("com.mysql.jdbc.Driver");
		     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","root");
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Air e){  
        int status=0;  
        try{  
            Connection con=AirDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into user905(name,phonenumber,email,afro,ato,gender,adate, atime) values (?,?,?,?,?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPhonenumber());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getAfro());  
            ps.setString(5,e.getAto());
            ps.setString(6,e.getGender());
            ps.setString(7,e.getAdate());
            ps.setString(8,e.getAtime());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Air e) {
        int status = 0;
        try {
            Connection con = AirDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "update user905 set name=?, phonenumber=?, email=?, afro=?, ato=?, gender=?, adate=?, atime=? where id=?"
            );
            ps.setString(1, e.getName());
            ps.setString(2, e.getPhonenumber());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getAfro());
            ps.setString(5, e.getAto());
            ps.setString(6, e.getGender());
            ps.setString(7, e.getAdate());
            ps.setString(8, e.getAtime());
            ps.setInt(9, e.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=AirDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from user905 where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Air getEmployeeById(int id){  
        Air e=new Air();  
          
        try{  
            Connection con=AirDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user905 where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPhonenumber(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setAfro(rs.getString(5));  
                e.setAto(rs.getString(6)); 
                e.setGender(rs.getString(7)); 
                e.setAdate(rs.getString(8));
                e.setAtime(rs.getString(9));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Air> getAllEmployees(){  
        List<Air> list=new ArrayList<Air>();  
          
        try{  
            Connection con=AirDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user905");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Air e=new Air();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPhonenumber(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setAfro(rs.getString(5));  
                e.setAto(rs.getString(6)); 
                e.setGender(rs.getString(7)); 
                e.setAdate(rs.getString(8));
                e.setAtime(rs.getString(9)); 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }

}
