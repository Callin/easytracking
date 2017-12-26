package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
public class Sprint {
    private long id;
    private Date startDate;
    private Date endDate;
    private int numberOfDays;
    private Project project;
    private List<Epic> epicList;

    @Override
    public String toString() {
        return "Sprint{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", numberOfDays=" + numberOfDays +
                ", project=" + project +
                ", epicList=" + epicList +
                '}';
    }
}
