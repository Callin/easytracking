package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.domain.UserStory;
import xyz.vegaone.easytracking.utils.Status;

@Getter
@Setter
public class Task {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private UserStory userStory;

}
