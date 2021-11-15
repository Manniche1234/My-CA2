package entities;

import dtos.PlayerDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "player")
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team team;


    public Player(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.user = new ArrayList<>();
    }

    public Player(PlayerDTO playerDTO){
        this.first_name = playerDTO.getfirst_name();
        this.last_name = playerDTO.getLast_name();

    }
    public Player() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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