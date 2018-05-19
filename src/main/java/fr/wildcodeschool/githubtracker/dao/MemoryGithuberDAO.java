package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.*;
import java.sql.*;


@ApplicationScoped
@InMemory
public class MemoryGithuberDAO implements GithuberDAO{

    private Map<String, Githuber> githuberMap = new HashMap<>();
    List<String> initialPopulation;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/githubtracker";

    @Inject
    GithubUtils githubUtils;

    @Override
    public List<Githuber> getGithubers() {
        List<Githuber> githubers = new ArrayList<>();
        for (Map.Entry<String, Githuber> entry : githuberMap.entrySet()) {
            githubers.add(entry.getValue());
        }
        return githubers;
    }

    @Override
    public void saveGithuber(Githuber githuber) {
        if (githuber != null) {
            githuberMap.put(githuber.getLogin(), githuber);
        }
    }

    @PostConstruct
    private void init() {
        initialPopulation = Arrays.asList("kobanogit", "loloof64", "TomBtz", "devart64", "sebaurel");
        for (String login: initialPopulation) {
            saveGithuber(githubUtils.parseGithuber(login));
        }
    }

}
