package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Project {
    private Long id;
    private String name;
    private String description;
    private List<Sprint> sprintList;
    private List<Epic> epicList;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sprintList=" + sprintList +
                ", epicList=" + epicList +
                '}';
    }
}
