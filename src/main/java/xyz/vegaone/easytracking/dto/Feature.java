package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;
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
    private List<UserStory> userStoryList;

    @Override
    public String toString() {
        return "FeatureEntity{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", status=" + status + ", epicEntity=" + epic + ", userStoryList=" + userStoryList + '}';
    }
}
