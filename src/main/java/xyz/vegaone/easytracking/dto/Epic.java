package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.domain.FeatureEnitty;
import xyz.vegaone.easytracking.domain.SprintEnitty;
import xyz.vegaone.easytracking.utils.Status;

import java.util.List;

@Getter
@Setter
public class Epic {

    private Long id;
    private String title;
    private Status status;
    private SprintEnitty sprintEnitty;
    private List<FeatureEnitty> featureEnitties;

    @Override
    public String toString() {
        return "EpicEnitty{" + "id=" + id + ", title='" + title + '\'' + ", status=" + status + ", sprintEnitty=" + sprintEnitty + ", featureEnitties=" + featureEnitties + '}';
    }
}