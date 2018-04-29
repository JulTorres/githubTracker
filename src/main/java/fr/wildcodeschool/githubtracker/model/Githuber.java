package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Githuber {

    int id;
    String login;
    String email;
    String name;
    String avatar_url;
    String bio;


    /*
     *  CONSTRUCTORS
     */
    public Githuber() {}

    public Githuber(int id, String login, String email, String name, String avatar_url, String bio) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.name = name;
        this.avatar_url = avatar_url;
        this.bio = bio;
    }

    /*
     *   GETTERS AND SETTERS
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
