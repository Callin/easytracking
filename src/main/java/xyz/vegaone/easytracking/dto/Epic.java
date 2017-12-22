package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;

import java.util.List;

@Getter
@Setter
public class Epic {

    private Long id;
    private String title;
    private Status status;
    private Sprint sprint;
    private List<Feature> featureList;

    @Override
    public String toString() {
        return "EpicEntity{" + "id=" + id + ", title='" + title + '\'' + ", status=" + status + ", sprint=" + sprint + ", featureList=" + featureList + '}';
    }
}