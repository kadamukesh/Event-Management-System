<%@page import="com.klef.ep.models.Admin"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
Admin admin = (Admin) session.getAttribute("admin");
if(admin==null)
{
	response.sendRedirect("sessionexpiry.html");
}
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
    <title>Modern Admin Dashboard</title>
    <link rel="stylesheet" href="adminhome0.css">
    <link rel="stylesheet"
        href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        
         
</head>

<body>
    <input type="checkbox" id="menu-toggle">
    <div class="sidebar">
        <div class="side-header">
            <h3>A<span>dmin</span></h3>
        </div>

        <div class="side-content">
            <div class="profile">
                <div class="profile-img bg-img" style="background-image: url(images/Admin-icon.png)"></div>
                <h4>Klu</h4>
                <small>Admin</small>
            </div>

            <div class="side-menu">
                <ul>
                    <li style="margin-top: 40px;">
                        <a href="admindash.jsp" class="active">
                            <span class="las la-home"></span>
                            <small>Dashboard</small>
                        </a>
                    </li>
                    <li style="margin-top: 40px;">
                        <a href="facultyreg.jsf">
                            <span class="las la-user-secret"></span>

                            <small>Faculty</small>
                        </a>
                    </li>
                    <li style="margin-top: 40px;">
                        <a href="studentreg.jsf">
                            <span class="las la-user-graduate"></span>

                            <small>Student</small>
                        </a>
                    </li>
                    <li style="margin-top: 40px;">
                        <a href="viewall.jsp">
                            <span class="las la-eye"></span>

                            <small>View</small>
                        </a>
                    </li>
                  
                   

                </ul>
            </div>
        </div>
    </div>

    <div class="main-content">

        <header>
            <div class="header-content">
                <label for="menu-toggle">
                    <span class="las la-bars"></span>
                </label>
                
     

                <div class="header-menu">

  

                    <div class="notify-icon">
                        <% if (admin != null) { %>
            Welcome <%= admin.getUsername() %>
        <% } else { %>
            Admin not logged in
        <% } %>
                    </div>
                    
    

                    <div class="notify-icon">
                        <span class="las la-bell"></span>
                        <span class="notify">3</span>
                    </div>

                    <div class="user">
                        <div class="bg-img" style="background-image: url(images/Admin-icon.png)"></div>

                        <span class="las la-power-off"></span>
                       <a href="adminlogout.jsp">
                        <span style="color: #22BAA0; font-size: 15px; font-weight: bold;">Logout</span></a>
                    </div>
                </div>
            </div>
        </header>


        <main>

         

            <div class="page-content">

                <div class="analytics1">







              
                
                    <center>Welcome To Admin Module</center> 
    
                </div>





        </main>

    </div>
</body>

</html>