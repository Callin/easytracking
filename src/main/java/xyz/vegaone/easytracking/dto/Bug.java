package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.domain.UserStoryEnitty;
import xyz.vegaone.easytracking.utils.Status;

@Getter
@Setter
public class Bug {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private UserStoryEnitty userStoryEnitty;

    @Override
    public String toString() {
        return "BugEnitty{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", status=" + status + ", userStoryEnitty=" + userStoryEnitty + '}';
    }
}
