package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;

@ApplicationScoped
public class GithubUtils {

    @Inject
    private ObjectMapper objectMapper;

    public Githuber parseGithuber(String login) {
        String url = "https://api.github.com/users/" + login;
        Githuber githuber = null;
        try {
            githuber = objectMapper.readValue(new URL(url), Githuber.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return githuber;
    }

}
