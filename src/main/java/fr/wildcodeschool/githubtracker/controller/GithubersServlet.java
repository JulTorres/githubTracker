package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/githubers")
public class GithubersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Githuber bruno = new Githuber("bru", "@kobanogit", "bruno.michel77@gmail.com", "bruno", "https://avatars3.githubusercontent.com/u/19733351?s=400&v=4");
        Githuber laurent = new Githuber("laur", "@loloof64", "laurent.bernabe@gmail.com", "laurent", "https://avatars3.githubusercontent.com/u/1826495?s=400&v=4");
        Githuber thomas = new Githuber("thom", "@TomBtz", "contact@petitjeanthomas.fr", "thomas", "https://avatars.githubusercontent.com/TomBtz?s=460");
        Githuber stephen = new Githuber("steph", "@devart64", "stephendupre64@gmail.com", "stephen", "https://avatars2.githubusercontent.com/u/21971807?s=400&v=4");
        Githuber sebastien = new Githuber("sebas", "@sebaurel", "sebaurel@free.fr", "sebastien", "https://avatars.githubusercontent.com/sebaurel?s=460");

        List<Githuber> githubers = new ArrayList<>();
        githubers.add(bruno);
        githubers.add(laurent);
        githubers.add(thomas);
        githubers.add(stephen);
        githubers.add(sebastien);

        request.setAttribute("githubers", githubers);
        this.getServletContext().getRequestDispatcher( "/githubers.jsp" ).forward( request, response );

    }

}
