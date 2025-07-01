package com.klef.ep.Servlets;

import java.io.IOException;
import java.io.OutputStream;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.klef.ep.services.FacultyService;


@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB(lookup = "java:global/EPProject/FacultyServiceImpl!com.klef.ep.services.FacultyService")
    private FacultyService facservice;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fid = request.getParameter("id");
        byte[] image = facservice.viewfacbyid(fid).getImage();

        if (image != null) {
            response.setContentType("image/jpeg");
            OutputStream os = response.getOutputStream();
            os.write(image);
            os.flush();
            os.close();
        }
    }
}