package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.net.URL;
import java.io.IOException;
import java.util.*;


@ApplicationScoped
@Default
public class MemoryGithuberDAO implements GithuberDAO{
    private Map<String, Githuber> githuberMap = new HashMap<>();
    List<String> finalFive;

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
        githuberMap.put(githuber.getLogin(), githuber);
    }

    public Githuber parseGithuber(String login) {
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://api.github.com/users/" + login;
        Githuber githuber = null;
        try {
            githuber = objectMapper.readValue(new URL(url), Githuber.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return githuber == null ? null : githuber;
    }

    @PostConstruct
    private void processFinalFive() {

        finalFive = Arrays.asList("kobanogit", "loloof64", "TomBtz", "devart64", "sebaurel");
        for (String login: finalFive) {
            saveGithuber(parseGithuber(login));
        }

    }
}
