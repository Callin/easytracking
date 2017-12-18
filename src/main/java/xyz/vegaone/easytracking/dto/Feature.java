package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.domain.UserStoryEnitty;
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
    private List<UserStoryEnitty> userStories;

    @Override
    public String toString() {
        return "FeatureEnitty{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", status=" + status + ", epicEnitty=" + epic + ", userStories=" + userStories + '}';
    }
}
