package com.klef.ep.Servlets;

import java.io.IOException;
import java.io.OutputStream;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.klef.ep.services.*;

@WebServlet("/ImageServlet3")
public class ImageServlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB(lookup = "java:global/EPProject/CertificateServiceImpl!com.klef.ep.services.CertificateService")
    private CertificateService cservice;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer eventId = Integer.parseInt(request.getParameter("id"));
        byte[] image = cservice.viewcerbyid(eventId).getImage();

        if (image != null) {
            response.setContentType("image/jpeg");
            OutputStream os = response.getOutputStream();
            os.write(image);
            os.flush();
            os.close();
        }
    }
}