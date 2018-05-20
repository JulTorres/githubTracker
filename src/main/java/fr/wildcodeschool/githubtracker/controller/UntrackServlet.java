package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UntrackServlet", urlPatterns = "/untrack")
public class UntrackServlet extends HttpServlet {

    @Inject
    private GithubersService githubersService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idGithuber = Integer.parseInt(request.getParameter("untrack"));

        if (idGithuber != null) {
            githubersService.untrack(idGithuber);
        }
        response.sendRedirect("/GithubTracker/githubers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
