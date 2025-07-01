<%@page import="com.klef.ep.models.Faculty"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
Faculty faculty = (Faculty) session.getAttribute("faculty");
if(faculty==null)
{
	response.sendRedirect("sessionexpiry1.html");
}
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Faculty Dashboard</title>
    <link rel="stylesheet" href="facstyle.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
        .swiper {
            width: 950px;
        }

        .container {
            border-radius: 20px;
        }

        .card .image {
            width: 140px;
            height: 140px;
            border-radius: 50%;
        }

        .card .image img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 50%;
            border: 3px solid #000;
        }

        .card {
            position: relative;
            background: #000;
            border: 3px solid #0ef;
            border-radius: 20px;
            transition: transform 0.3s, background-color 0.3s;
            overflow: hidden; /* Ensure proper clipping of overflow */
            color: #fff; /* Text color */
        }

        .card:hover {
            transform: scale(1.05);
            background-color: #98FF98;
        }

        .card::before {
            content: '';
            position: absolute;
            width: 100%;
            height: 100%;
            background: #0ef;
            clip-path: circle(55% at 0 0);
            border-top-left-radius: 10px;
            transition: clip-path 0.3s;
        }

        .card:hover::before {
            clip-path: circle(75% at 0 0);
        }

        .card .card-content {
            position: relative;
            display: flex;
            align-items: center;
            flex-direction: column;
            padding: 30px;
            animation: fadeIn 1s ease-in-out;
        }

        .card .social-media {
            position: absolute;
            top: 10px;
            right: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .card .social-media i {
            color: #fff;
            margin-top: 10px;
            cursor: pointer;
            transition: .3s;
        }

        .card .social-media i:hover {
            color: #000;
        }

        .card .name-profession {
            display: flex;
            align-items: center;
            flex-direction: column;
            margin-top: 10px;
            color: #fff;
        }

        .name-profession .name {
            font-size: 20px;
            font-weight: 600;
        }

        .name-profession .profession {
            font-size: 15px;
            font-weight: 500;
        }

        .card .rating {
            display: flex;
            align-items: center;
            margin-top: 18px;
        }

        .card .rating i {
            font-size: 18px;
            color: #0ef;
            margin: 0 2px;
        }

        .card .button {
            display: flex;
            justify-content: space-around;
            width: 110%;
            margin-top: 20px;
        }

        .card .button button {
            background: #0ef;
            border: none;
            outline: none;
            color: #000;
            font-weight: 600;
            padding: 8px 22px;
            border-radius: 20px;
            font-size: 14px;
            cursor: pointer;
            transition: .3s;
        }

        .card .button button:hover {
            background: #fff;
        }

        .swiper-pagination-bullet {
            height: 7px;
            width: 26px;
            background: #0ef;
            border-radius: 25px;
        }

        .swiper-button-next,
        .swiper-button-prev {
            color: #0ef;
        }

        @keyframes fadeIn {
            0% {
                opacity: 0;
                transform: translateY(20px);
            }

            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }
           .section-content p, .section-content h4 {
        color: #333; /* Dark grey color for better visibility */
    }

    .section-title, .subsection-title {
        color: #0ef; /* Color for section and subsection titles */
    }
    
    /* Ensure contrast for headings */
    .page-title {
        color: #0ef; /* Title color */
    }
    
     .profile-container:hover {
        border-color: black;
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
    }
    .profile-header:hover {
        color: black;
    }
    .profile-row:hover {
        background-color: #f0f0f0;
    }
    .profile-label:hover, .profile-value:hover {
        color: #0ef;
    }
    </style>
</head>

<body>
    <div class="page-container">
        <div class="page-sidebar-wrapper">
            <div class="sidebar">
                <div class="logo">
                    <div class="d-flex justify-content-center align-items-center">
                        <img src="./images/person-check.svg" alt="logo" class="logo-img mr-3">
                        <div class="logo-text">Faculty Module</div>
                    </div>
                </div>
                <div class="user-info d-flex">
                    <div>
                        <img src="./images/man.svg" alt="user-img" class="user-img">
                    </div>
                    <div class="d-flex flex-column">
                                   <% if (faculty != null) { %>
            Welcome <%= faculty.getFusername() %>
        <% } else { %>
            Admin not logged in
        <% } %>
                    </div>
                </div>
                <ul class="nav flex-column menu-link">
                  
                    <li class="nav-item" style="margin-top: 50px;">
                        <a href="fachome0.jsp" class="nav-link">
                            <img src="./images/calendar-event.svg" alt="orders">Event Resources
                        </a>
                    </li>
                    
                 
                    
               
                 
                    <li class="nav-item" style="margin-top: 50px;">
                        <a href="vieweventsregisteredstudents.jsf" class="nav-link">
                            <img src="./images/clipboard-data.svg" alt="settings">Event Participation List
                        </a>
                    </li>
                    
                          <li class="nav-item" style="margin-top: 50px;">
                        <a href="uploadcertificate.jsf" class="nav-link">
                            <img src="./images/cloud-upload.svg" alt="orders">Upload Certificate
                        </a>
                    </li>
                    
                       <li class="nav-item" style="margin-top: 50px;">
                        <a href="viewfeedback.jsf" class="nav-link">
                            <img src="./images/eye.svg" alt="orders">View Feedback
                        </a>
                    </li>
                    
                      <li class="nav-item" style="margin-top: 50px;">
                        <a href="facdash.jsp" class="nav-link">
                            <img src="./images/person-square.svg" alt="dashboard">View Profile
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="page-content-wrapper">
            <div class="page-content">
                <div class="top-bar d-flex justify-content-between align-items-center">
                    <div class="d-flex align-items-center">
                        <div>
                            <img src="./images/menu.svg" alt="menu" class="menu-toggle">
                        </div>
                    </div>
                    <div class="d-flex align-items-center">
                      
                <div class="log-btn d-flex align-items-center">
    <div style="color: #0ef;   background-color: #333;
  border-radius: 12px;
  padding: 12px;
  text-align: left;
  margin-left: 15px;
  height: 50px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
  transition: background-color 0.3s ease, box-shadow 0.3s ease, transform 0.3s ease;">
        <% if (faculty != null) { %>
            <%= faculty.getFusername() %>
        <% } else { %>
            Admin not logged in
        <% } %>
    </div>
</div>

                        
                   <a href="facultylogout.jsp">    <div class="icon-btn">
                            <img src="./images/logout.svg" alt="logout" />
                        </div></a> 
                    </div>
                </div>

                <div class="inner-section">
                      <h2 class="page-title" style="
  position: relative; /* Position relative for transform animations */
  display: inline-block; /* Ensures proper handling of transform */
  color: #0ef; /* Initial text color */
  transition: color 0.3s ease, transform 0.6s ease; /* Smooth transitions for color and movement */
  cursor: pointer; /* Change cursor to pointer for better UX */
" onmouseover="this.style.color='#003366'; this.style.transform='translateY(10px)';" onmouseout="this.style.color='#003366'; this.style.transform='translateY(0)';">
                        View Profile
                    </h2>

                    <hr style="border: 1px solid #0ef; margin: 20px 0;">

<div class="profile-container" style="margin: 20px; padding: 20px; border: 2px solid #0ef; border-radius: 10px; background: #333; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3); transition: all 0.3s ease;">
    <h2 class="profile-header" style="text-align: center; color: #0ef; font-size: 24px; font-weight: bold; margin-bottom: 20px; transition: color 0.3s ease;">View Your Profile</h2>
    <div class="profile-image" style="text-align: center; margin-bottom: 20px;">
        <!-- Image can be added here -->
    </div>
    <div class="profile-row" style="display: flex; justify-content: space-between; padding: 10px 0; transition: background-color 0.3s ease; border-bottom: 1px solid #0ef;">
        <div class="profile-label" style="font-weight: bold; color: #0ef; transition: color 0.3s ease;">ID:</div>
        <div class="profile-value" style="text-align: right; color: #fff; transition: color 0.3s ease;"><%= faculty.getFid() %></div>
    </div>
    <div class="profile-row" style="display: flex; justify-content: space-between; padding: 10px 0; transition: background-color 0.3s ease; border-bottom: 1px solid #0ef;">
        <div class="profile-label" style="font-weight: bold; color: #0ef; transition: color 0.3s ease;">Name:</div>
        <div class="profile-value" style="text-align: right; color: #fff; transition: color 0.3s ease;"><%= faculty.getFusername() %></div>
    </div>
    <div class="profile-row" style="display: flex; justify-content: space-between; padding: 10px 0; transition: background-color 0.3s ease; border-bottom: 1px solid #0ef;">
        <div class="profile-label" style="font-weight: bold; color: #0ef; transition: color 0.3s ease;">Gender:</div>
        <div class="profile-value" style="text-align: right; color: #fff; transition: color 0.3s ease;"><%= faculty.getFgender() %></div>
    </div>
    <div class="profile-row" style="display: flex; justify-content: space-between; padding: 10px 0; transition: background-color 0.3s ease; border-bottom: 1px solid #0ef;">
        <div class="profile-label" style="font-weight: bold; color: #0ef; transition: color 0.3s ease;">Department:</div>
        <div class="profile-value" style="text-align: right; color: #fff; transition: color 0.3s ease;"><%= faculty.getFdepartment() %></div>
    </div>
    <div class="profile-row" style="display: flex; justify-content: space-between; padding: 10px 0; transition: background-color 0.3s ease; border-bottom: 1px solid #0ef;">
        <div class="profile-label" style="font-weight: bold; color: #0ef; transition: color 0.3s ease;">Email:</div>
        <div class="profile-value" style="text-align: right; color: #fff; transition: color 0.3s ease;"><%= faculty.getFemail() %></div>
    </div>
    <div class="profile-row" style="display: flex; justify-content: space-between; padding: 10px 0; transition: background-color 0.3s ease; border-bottom: 1px solid #0ef;">
        <div class="profile-label" style="font-weight: bold; color: #0ef; transition: color 0.3s ease;">Contact:</div>
        <div class="profile-value" style="text-align: right; color: #fff; transition: color 0.3s ease;"><%= faculty.getFcontact() %></div>
    </div>
</div>

<script>
    // JavaScript to add hover effect
    document.querySelectorAll('.profile-row').forEach(row => {
        row.addEventListener('mouseover', () => {
            row.style.backgroundColor = '#0ef';
            row.querySelector('.profile-label').style.color = '#333';
            row.querySelector('.profile-value').style.color = '#333';
        });
        row.addEventListener('mouseout', () => {
            row.style.backgroundColor = 'transparent';
            row.querySelector('.profile-label').style.color = '#f0f0f0';
            row.querySelector('.profile-value').style.color = '#fff';
        });
    });
</script>



                </div>
            </div>
        </div>
                        </div>
               
</body>

</html>
