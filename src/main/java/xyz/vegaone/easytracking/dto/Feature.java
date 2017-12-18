package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.domain.UserStory;
import xyz.vegaone.easytracking.utils.Status;

import java.util.List;

@Getter
@Setter
public class Feature {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private Epic epic;
    private List<UserStory> userStories;

    @Override
    public String toString() {
        return "Feature{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", status=" + status + ", epic=" + epic + ", userStories=" + userStories + '}';
    }
}
