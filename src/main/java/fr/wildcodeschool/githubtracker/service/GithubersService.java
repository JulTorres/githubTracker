package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githuber;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GithubersService {
    private GithuberDAO githuberDAO;

    public GithubersService(GithuberDAO githuberDAO) {
        this.githuberDAO = githuberDAO;
    }

    public List<Githuber> getAllGithubers() {
        return githuberDAO.getGithubers();
    }

    public Githuber getGithuber(String login) {
        Githuber wantedGithuber = getAllGithubers()
                .stream()
                .filter(githuber -> login.equals(githuber.getLogin()))
                .collect(Collectors.toList())
                .get(0);

        return wantedGithuber == null ? null : wantedGithuber;
    }

    public void track(String login) {
        //TODO
    }



}
