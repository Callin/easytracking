package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.domain.UserStoryEntity;
import xyz.vegaone.easytracking.utils.Status;

@Getter
@Setter
public class Task {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private UserStoryEntity userStoryEntity;

    @Override
    public String toString() {
        return "TaskEntity{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", status=" + status + ", userStoryEntity=" + userStoryEntity + '}';
    }
}
