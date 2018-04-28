package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import java.util.Arrays;
import java.util.List;

@Dependent
public class DumbGithuberDAO implements GithuberDAO{

    private List<Githuber> githubers;

    public List<Githuber> getGithubers() {
        Githuber bruno = new Githuber("bru", "kobanogit", "bruno.michel77@gmail.com", "bruno", "https://avatars3.githubusercontent.com/u/19733351?s=400&v=4");
        Githuber laurent = new Githuber("laur", "loloof64", "laurent.bernabe@gmail.com", "laurent", "https://avatars3.githubusercontent.com/u/1826495?s=400&v=4");
        Githuber thomas = new Githuber("thom", "TomBtz", "contact@petitjeanthomas.fr", "thomas", "https://avatars.githubusercontent.com/TomBtz?s=460");
        Githuber stephen = new Githuber("steph", "devart64", "stephendupre64@gmail.com", "stephen", "https://avatars2.githubusercontent.com/u/21971807?s=400&v=4");
        Githuber sebastien = new Githuber("sebas", "sebaurel", "sebaurel@free.fr", "sebastien", "https://avatars.githubusercontent.com/sebaurel?s=460");

        githubers = Arrays.asList(bruno, laurent, thomas, stephen, sebastien);

        return githubers;
    }

    public void saveGithuber(Githuber githuber) throws UnsupportedOperationException {
        githubers.add(githuber);
    }
}
