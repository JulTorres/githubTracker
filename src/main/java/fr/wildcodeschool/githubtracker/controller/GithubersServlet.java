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

        Githuber bruno = new Githuber("bru", "bruno64", "bruno@mail.com", "bruno", "http://www.bruno.html/bruno.png");
        Githuber laurent = new Githuber("laur", "laurent64", "laurent@mail.com", "laurent", "http://www.laurent.html/laurent.png");
        Githuber thomas = new Githuber("thom", "thomas64", "thomas@mail.com", "thomas", "http://www.thomas.html/thomas.png");
        Githuber stephen = new Githuber("steph", "stephen64", "stephen@mail.com", "stephen", "http://www.stephen.html/stephen.png");
        Githuber sebastien = new Githuber("sebas", "sebastien64", "sebastien@mail.com", "sebastien", "http://www.sebastien.html/sebastien.png");

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
