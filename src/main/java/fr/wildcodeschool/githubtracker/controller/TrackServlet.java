package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.helpers.GithubUtils;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "TrackServlet", urlPatterns = "/track")
public class TrackServlet extends HttpServlet {

    @Inject @InMemory
    GithuberDAO githuberDAO;

    @Inject
    GithubUtils githubUtils;

/*    @Inject
    GithubersService githubersService;*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("LOGIN");
        githuberDAO.saveGithuber(githubUtils.parseGithuber(login));
        //githubersService.track(login);
        response.sendRedirect("/GithubTracker/githubers");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/track.jsp" ).forward( request, response );
    }

}
