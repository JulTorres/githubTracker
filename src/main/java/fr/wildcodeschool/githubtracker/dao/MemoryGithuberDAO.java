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

    //Map<String, Githuber> githubers = new HashMap<>();
    //List<String> initialPopulation;

    @Inject
    private GithubUtils githubUtils;

    @Override
    public List<Githuber> getGithubers() {
        List<Githuber> githubers = new ArrayList<>();

/*        for (Map.Entry<String, Githuber> entry: this.githubers.entrySet()) {
            githubers.add(entry.getValue());
        }*/

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
                Integer githubId = rs.getInt("github_id");
                String name = rs.getString("name");
                String login = rs.getString("login");
                String url = rs.getString("url");
                String email = rs.getString("email");
                String bio = rs.getString("bio");
                String location = rs.getString("location");
                String avatarUrl = rs.getString("avatar_url");
                /*
                id_githuber
                github_id
                name
                login
                url
                email
                bio
                location
                avatar_url
  */
                Githuber githuber = new Githuber(githubId, name, login, url, email, bio, location, avatarUrl);
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
/*            githubers.put(githuber.getLogin(), githuber);
        }
    }*/

            Connection conn = null;
            PreparedStatement stmt = null;

            try{
                Class<?> driverClass = Class.forName(JDBC_DRIVER);
                Driver driverInstance = (Driver) driverClass.newInstance();
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                String sql;
//                sql = "INSERT INTO githuber (`github_id`, `name`, `login`, `url`, `email`, `bio`, `location`, `avatar_url`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                sql = "INSERT INTO githuber (`name`, `login`, `url`, `email`, `bio`, `location`, `avatar_url`) VALUES (?, ?, ?, ?, ?, ?, ?);";
                stmt = conn.prepareStatement(sql);

                //stmt.setInt(1, githuber.getGithub_id());
                stmt.setString(1, githuber.getName());
                stmt.setString(2, githuber.getLogin());
                stmt.setString(3, githuber.getUrl());
                stmt.setString(4, githuber.getEmail());
                stmt.setString(5, githuber.getBio());
                stmt.setString(6, githuber.getLocation());
                stmt.setString(7, githuber.getAvatar_url());


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

/*    @PostConstruct
    private void init() {
        this.initialPopulation = Arrays.asList("kobanogit", "loloof64", "TomBtz", "devart64", "sebaurel");
        for (String login: initialPopulation) {
            saveGithuber(githubUtils.parseGithuber(login));
        }
    }*/

}
