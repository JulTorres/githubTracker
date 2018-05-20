package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "TrackServlet", urlPatterns = "/track")
public class TrackServlet extends HttpServlet {

    @Inject
    private GithubersService githubersService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("LOGIN");
        boolean tracked = githubersService.track(login);
        if (tracked) {
            response.sendRedirect("/GithubTracker/githubers");
        } else {
            request.setAttribute("githuberNotFound", "Sorry but github doesn't seem to know this person...");
            this.getServletContext().getRequestDispatcher( "/track.jsp" ).forward( request, response );
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/track.jsp" ).forward( request, response );
    }

}
