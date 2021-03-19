import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup_servlets extends HttpServlet
{
  
//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter(); 
    String signup_email=request.getParameter("signup_email");
    String password=request.getParameter("password");
    String confirm_password=request.getParameter("confirm_password");
    
    System.out.println("signup_email");
    System.out.println("password");   
    System.out.println("confirm_password");
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        
        
          PreparedStatement pstmt=con.prepareStatement("insert into OnlineSurvey values(?,?,?)");
          
          pstmt.setString(1,signup_email);
          pstmt.setString(2,password);
          pstmt.setString(3,confirm_password);
          
          int n=pstmt.executeUpdate();
          if(n>0)
            out.println("Successfully stored in the Database");
          else
            out.println("Failed.....!!");
    }
    catch(Exception e)
    {    
      System.out.println(e);  
      System.out.println("hirdgreh....................");  
    }
    out.close();
  }
  protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
   doGet(request, response);
 }

}