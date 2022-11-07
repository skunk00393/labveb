package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConfirmationInfoServlet", value = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req,resp,req.getServletContext());
        webContext.setVariable("balloonSize",req.getSession().getAttribute("balloonSize"));
        webContext.setVariable("balloonColor",req.getSession().getAttribute("balloonColor"));
        webContext.setVariable("clientName",req.getSession().getAttribute("clientName"));
        webContext.setVariable("clientAddress",req.getSession().getAttribute("clientAddress"));
        webContext.setVariable("ipAddress", req.getRemoteAddr());
        webContext.setVariable("browser", req.getHeader("User-Agent"));
        this.springTemplateEngine.process("confirmationInfo.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("");
    }
}

