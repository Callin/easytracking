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
    private List<Task> taskList;
    private List<Bug> bugList;

    @Override
    public String toString() {
        return "UserStoryEntity{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", status=" + status + ", featureEntity=" + feature + ", taskList=" + taskList + ", bugList=" + bugList + '}';
    }
}
