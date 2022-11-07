package mk.finki.ukim.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SelectBalloonServlet ", value = "/selectBalloon")
public class SelectBalloonServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public SelectBalloonServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext webContext = new WebContext(request,response,request.getServletContext());
        webContext.setVariable("balloonColor", request.getSession().getAttribute("balloonColor"));
        this.springTemplateEngine.process("selectBalloonSize.html",webContext,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String balloonSize = request.getParameter("size");
        request.getSession().setAttribute("balloonSize",balloonSize);
        response.sendRedirect("/BalloonOrder");
    }
}
