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
    <title>Modern Admin View</title>
    <link rel="stylesheet" href="adminhome0.css">
    <link rel="stylesheet"
        href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        
         <style>
        .text1 {
            position: absolute;
            top: 10px;
            right: 10px;
            text-align: right;
            color: black;
        }


.count {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: black; /* Changed to black for contrast */
    text-align: center;
}

.card {
    height: 300px;
    width: 320px;
    display: inline-block; 
    margin: 0 50px 10px 10px; 
    vertical-align: top; 
    position: relative;
    transform-style: preserve-3d;
    perspective: 1000px;
     background: #e0f7fa; /* New background color */
    border: 1px solid #00796b; /* New border color */
    border-radius: 10px;
    box-shadow: 0px 10px 15px rgba(0, 0, 0, 0.1);
    padding: 20px;
    color: black;
    transition: transform 0.7s cubic-bezier(0.4, 0.2, 0.2, 1), box-shadow 0.7s, border 0.7s;
    animation: slideInTop 1s ease-out; /* Top animation */
}

.card:hover {
    transform: translateY(-10px) scale(1.05);
 border: 5px solid #00796b; /* New hover border color */
    box-shadow: 0 0 20px #00796b, inset 0 0 20px #00796b; 
}

.card img {
    height: 150px;
    width: 150px;
    padding: 5px;
    border-radius: 50%;
    background: linear-gradient(375deg, #1cc7d0, #2ede98);
    margin-bottom: 20px;
}

.card .content {
    text-align: center;
}

.card .content .title {
    font-size: 30px;
    font-weight: 500;
}

/* Top animation keyframes */
@keyframes slideInTop {
    0% {
        opacity: 0;
        transform: translateY(-50px);
    }
    100% {
        opacity: 1;
        transform: translateY(0);
    }
}

    </style>
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

            <div class="page-header" id="analytics">
            
                <h1>Admin View</h1>
                <small>Home / View</small>
            </div>

            <div class="page-content">

                <div class="analytics">






  <div class="count">
        <a href="view.jsf"> <div class="card">
            <img src="images/faculty.jpg" alt="Faculty Image">
            <div class="content">
                <div class="title">Faculty View</div>
                <p>
                   <span class="las la-eye" style="font-size: 64px;"></span>
                  
                </p>
            </div>
        </div></a>
        
        <a href="view1.jsf"><div class="card">
            <img src="images/studen.png" alt="">
            <div class="content">
                <div class="title">Student View</div>
                <p>
                  <span class="las la-eye" style="font-size: 64px;"></span>

                </p>
            </div>
        </div></a>
    </div>

                </div>
        </main>

    </div>
</body>

</html>