package dtos;

import entities.Player;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class PlayerDTO {


    private String fName;
    private String lName;


    public static List<PlayerDTO> getDtos(List<Player> p){
        List<PlayerDTO> playerDTOSdtos = new ArrayList();
        p.forEach(pm -> playerDTOSdtos.add(new PlayerDTO(pm)));
        return playerDTOSdtos;
    }

    public PlayerDTO(Player player) {
        this.fName = player.getfName();
        this.lName = player.getlName();

    }


    public PlayerDTO(String fName, String lName, String tName) {
        this.fName = fName;
        this.lName = lName;

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

}
