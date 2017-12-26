package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;

import java.util.List;

@Getter
@Setter
public class UserStory {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private Feature feature;
    private Sprint sprint;
    private List<Task> taskList;
    private List<Bug> bugList;

    @Override
    public String toString() {
        return "UserStory{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", feature=" + feature +
                ", sprint=" + sprint +
                ", taskList=" + taskList +
                ", bugList=" + bugList +
                '}';
    }
}
