package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "team")
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "team")
    private List<Player> player;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "team")
    private List<User> user;


    public Team(String name) {
        this.name = name;
        this.player = new ArrayList<>();
        this.user = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addPlayer(Player p){
        if(p != null){
            p.setTeam(this);
            this.player.add(p);
        }
    }

    public void addUser(User u){
        if (u != null){
            u.setTeam(this);
            this.user.add(u);
        }
    }

}