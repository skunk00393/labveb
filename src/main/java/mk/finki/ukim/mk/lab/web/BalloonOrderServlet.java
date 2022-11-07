package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "BalloonOrderServlet", value = "/BalloonOrder")
public class BalloonOrderServlet  extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req,resp,req.getServletContext());
        webContext.setVariable("balloonSize",req.getSession().getAttribute("balloonSize"));
        webContext.setVariable("balloonColor",req.getSession().getAttribute("balloonColor"));
        this.springTemplateEngine.process("deliveryInfo.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientName = request.getParameter("clientName");
        String clientAddress = request.getParameter("clientAddress");
        request.getSession().setAttribute("clientName",clientName);
        request.getSession().setAttribute("clientAddress",clientAddress);
        response.sendRedirect("/ConfirmationInfo");
    }
}
