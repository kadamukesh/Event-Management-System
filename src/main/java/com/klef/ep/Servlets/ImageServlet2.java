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

@WebServlet("/ImageServlet2")
public class ImageServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB(lookup = "java:global/EPProject/EventServiceImpl!com.klef.ep.services.EventService")
    private EventService eventservice;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long eventId = Long.parseLong(request.getParameter("id"));
        byte[] image = eventservice.findEventById(eventId).getImage();

        if (image != null) {
            response.setContentType("image/jpeg");
            OutputStream os = response.getOutputStream();
            os.write(image);
            os.flush();
            os.close();
        }
    }
}