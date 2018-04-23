package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.DumbGithuberDAO;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/githubers")
public class GithubersServlet extends HttpServlet {

    private ServletConfig cfg;
    private GithuberDAO gdao;

    public void init(ServletConfig config) throws ServletException {
        cfg = config;
        gdao = new DumbGithuberDAO();
    }

    public ServletConfig getServletConfig() {
        return cfg;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("githubers", gdao.getGithubers());
        this.getServletContext().getRequestDispatcher( "/githubers.jsp" ).forward( request, response );

    }

}
