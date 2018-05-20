package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.helpers.GithubUtils;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.*;
import java.util.*;


@ApplicationScoped
@InMemory
public class MemoryGithuberDAO implements GithuberDAO{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/githubtracker";
    static final String USER = "root";
    static final String PASS = "root";

    @Inject
    private GithubUtils githubUtils;

    @Override
    public List<Githuber> getGithubers() {
        List<Githuber> githubers = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;

        try{
            Class<?> driverClass = Class.forName(JDBC_DRIVER);
            Driver driverInstance = (Driver) driverClass.newInstance();
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM githuber";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Integer idGithuber = rs.getInt("id_githuber");
                Integer githubId = rs.getInt("github_id");
                String name = rs.getString("name");
                String login = rs.getString("login");
                String url = rs.getString("url");
                String email = rs.getString("email");
                String bio = rs.getString("bio");
                String location = rs.getString("location");
                String avatarUrl = rs.getString("avatar_url");

                Githuber githuber = new Githuber(idGithuber, githubId, name, login, url, email, bio, location, avatarUrl);
                githubers.add(githuber);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try{
                if(conn!=null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return githubers;
    }

    @Override
    public void saveGithuber(Githuber githuber) {
        if (githuber != null) {
            Connection conn = null;
            PreparedStatement stmt = null;

            try{
                Class<?> driverClass = Class.forName(JDBC_DRIVER);
                Driver driverInstance = (Driver) driverClass.newInstance();
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                String sql;
//                sql = "INSERT INTO githuber (`github_id`, `name`, `login`, `url`, `email`, `bio`, `location`, `avatar_url`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//                sql = "INSERT INTO githuber (`name`, `login`, `url`, `email`, `bio`, `location`, `avatar_url`, `github_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
                sql = "INSERT INTO githuber (`name`, `login`, `url`, `email`, `bio`, `location`, `avatar_url`) VALUES (?, ?, ?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(sql);

                stmt.setString(1, githuber.getName());
                stmt.setString(2, githuber.getLogin());
                stmt.setString(3, githuber.getUrl());
                stmt.setString(4, githuber.getEmail());
                stmt.setString(5, githuber.getBio());
                stmt.setString(6, githuber.getLocation());
                stmt.setString(7, githuber.getAvatar_url());
                //stmt.setInt(8, githuber.getGithub_id());

                stmt.executeUpdate();
                stmt.close();
                conn.close();

            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(stmt!=null)
                        stmt.close();
                } catch (SQLException se2) {
                }
                try{
                    if(conn!=null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    public Githuber getGithuberById(Integer id) {
        return null;
    }

    @Override
    public void deleteGithuber(Integer idGithuber) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            Class<?> driverClass = Class.forName(JDBC_DRIVER);
            Driver driverInstance = (Driver) driverClass.newInstance();
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            String sql;
            sql = "DELETE FROM githuber WHERE id_githuber = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idGithuber);

            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try{
                if(conn!=null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}

