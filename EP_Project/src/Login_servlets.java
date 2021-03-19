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

public class Login_servlets extends HttpServlet {
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String name = request.getParameter("login_email");
    String password = request.getParameter("psw");
    
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","admin");
        PreparedStatement pstmt=con.prepareStatement("select * from OnlineSurvey where login_email=? and psw=?");
        String login_email = null;
		pstmt.setString(1,login_email);
        String psw = null;
		pstmt.setString(2,psw);
          
        int n=pstmt.executeUpdate();
        if(n>0){
//          response.sendRedirect('index.html');
          out.println("Successfully logged in....!!");
          out.println("Hello This is online Survey System !! Welcome to our website");
      }
      else {
        out.println("Login Failed");
//        response.sendRedirect('Login&Signup.html');
      }        
    }
    catch(Exception e)
    {    
      System.out.println(e);  
    }
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    doGet(request, response);
  }

}