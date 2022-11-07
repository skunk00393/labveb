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

@WebServlet(name = "BalloonListServlet", value = "")
public class BalloonListServlet  extends HttpServlet {

    private final BalloonService balloonService;

    private final SpringTemplateEngine springTemplateEngine;

    public BalloonListServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req,resp,req.getServletContext());
        webContext.setVariable("listBalloons", balloonService.listAll());
        this.springTemplateEngine.process("listBalloons.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String balloonColor = request.getParameter("color");
        request.getSession().setAttribute("balloonColor",balloonColor);
        response.sendRedirect("/selectBalloon");
    }
}
