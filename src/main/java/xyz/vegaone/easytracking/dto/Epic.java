package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.domain.FeatureEntity;
import xyz.vegaone.easytracking.domain.SprintEntity;
import xyz.vegaone.easytracking.utils.Status;

import java.util.List;

@Getter
@Setter
public class Epic {

    private Long id;
    private String title;
    private Status status;
    private SprintEntity sprintEntity;
    private List<FeatureEntity> featureEnitties;

    @Override
    public String toString() {
        return "EpicEntity{" + "id=" + id + ", title='" + title + '\'' + ", status=" + status + ", sprintEntity=" + sprintEntity + ", featureEnitties=" + featureEnitties + '}';
    }
}