package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/githubers")
public class GithubersServlet extends HttpServlet {

    @Inject
    private GithubersService githubersService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("githubers", githubersService.getAllGithubers());
        this.getServletContext().getRequestDispatcher( "/githubers.jsp" ).forward( request, response );
    }

}
