package dtos;

import entities.Player;
import entities.Team;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class TeamDTO {

    private String name;


    public static List<TeamDTO> getDtos(List<Team> t){
        List<TeamDTO> teamDTOSdtos = new ArrayList();
        t.forEach(tm -> teamDTOSdtos.add(new TeamDTO(tm)));
        return teamDTOSdtos;
    }

    public TeamDTO(Team t){
        this.name = t.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
