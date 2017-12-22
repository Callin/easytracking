package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Project {
    private String name;
    private String description;
    private List<Sprint> sprintList;

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sprintList=" + sprintList +
                '}';
    }
}
