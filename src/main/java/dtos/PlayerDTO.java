package dtos;

import entities.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerDTO {


    private String first_name;
    private String last_name;


    public static List<PlayerDTO> getDtos(List<Player> p){
        List<PlayerDTO> playerDTOSdtos = new ArrayList();
        p.forEach(pm -> playerDTOSdtos.add(new PlayerDTO(pm)));
        return playerDTOSdtos;
    }

    public PlayerDTO(Player player) {
        this.first_name = player.getFirst_name();
        this.last_name = player.getLast_name();

    }


    public PlayerDTO(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;

    }

    public String getfirst_name() {
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

}
