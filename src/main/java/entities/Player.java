package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "player")
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fName;
    private String lName;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team team;


    public Player(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        this.user = new ArrayList<>();
    }

    public Player() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addUser(User user){
        this.user.add(user);
    }
}