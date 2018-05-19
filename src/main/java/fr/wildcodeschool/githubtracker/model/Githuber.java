package fr.wildcodeschool.githubtracker.model;


public class Githuber {

    Integer id;
    Integer github_id;
    String name;
    String login;
    String url;
    String email;
    String bio;
    String location;
    String avatar_url;


    /*
     *  CONSTRUCTORS
     */
    public Githuber() {}

    public Githuber(Integer id, Integer github_id, String name, String login, String url, String email, String bio, String location, String avatar_url) {
        this.id = id;
        this.github_id = github_id;
        this.name = name;
        this.login = login;
        this.url = url;
        this.email = email;
        this.bio = bio;
        this.location = location;
        this.avatar_url = avatar_url;
    }

    public Githuber(Integer github_id, String name, String login, String url, String email, String bio, String location, String avatar_url) {
        this.github_id = github_id;
        this.name = name;
        this.login = login;
        this.url = url;
        this.email = email;
        this.bio = bio;
        this.location = location;
        this.avatar_url = avatar_url;
    }

    /*
     *   GETTERS AND SETTERS
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGithub_id() {
        return github_id;
    }

    public void setGithub_id(Integer github_id) {
        this.github_id = github_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
