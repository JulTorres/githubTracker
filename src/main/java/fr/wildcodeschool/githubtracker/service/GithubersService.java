package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.helpers.GithubUtils;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;


@Dependent
public class GithubersService {

    @Inject @InMemory
    private GithuberDAO githuberDAO;

    @Inject
    GithubUtils githubUtils;


    public List<Githuber> getAllGithubers() {
        return githuberDAO.getGithubers();
    }

/*    public Githuber getGithuber(String login) {
        Githuber wantedGithuber = getAllGithubers()
                .stream()
                .filter(githuber -> login.equals(githuber.getLogin()))
                .collect(Collectors.toList())
                .get(0);

        return wantedGithuber == null ? null : wantedGithuber;
    }*/

    public boolean track(String login) {
        Githuber githuber = new Githuber();
        githuber = githubUtils.parseGithuber(login);
        if(githuber == null) {
            return false;
        } else {
            githuberDAO.saveGithuber(githuber);
            return true;
        }
    }

    public void untrack(Integer idGithuber) {
        githuberDAO.deleteGithuber(idGithuber);
    }

}
