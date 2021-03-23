<%@ page import = "java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String email = request.getParameter("login_email");
String password = request.getParameter("psw");
String query= "select * from login";
int x=0;
int f=0;

try{
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
    Statement st=con.createStatement();
  ResultSet rs=st.executeQuery(query);
  while(rs.next()){
       if(email.equals(rs.getString(5)) && password.equals(rs.getString(3)))
       {
        f=1;
        break;
       }
  }
  if(f==1)
  {
    PreparedStatement ps=con.prepareStatement("insert into login values(?,?)");
      ps.setString(1,email);
      ps.setString(2,password);
      x = ps.executeUpdate();
  }
  if(x > 0){
        System.out.println("succesfully");
  
  %>
      <i>Logged in successfully!!!!</i>
      <a href="index.html" style="margin-right:0px; font-size:13px;font-family:Tahoma,Geneva,sans-serif;">To go to Home page</a>
        
      <% 
  }else{
        System.out.println("failed");
      %>
        <h1>user not signed up or invalid credentials!!!!</h1>\
        <a href="Login&Signup.html" style="margin-right:0px; font-size:13px;font-family:Tahoma,Geneva,sans-serif;">To go to signup page</a>
<% 
}
}catch(Exception e){
  System.out.println("error");
     out.print(e);
}
%>
</body>
</html>