package fr.wildcodeschool.githubtracker.model;

public class Githuber {

    String id;
    String login;
    String email;
    String name;
    String avatarUrl;


    /*
     *  OVERLOADED CONSTRUCTOR
     */

    public Githuber(String id, String login, String email, String name, String avatarUrl) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    /*
     *   GETTERS AND SETTERS
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
