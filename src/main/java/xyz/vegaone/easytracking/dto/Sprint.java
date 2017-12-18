package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
public class Sprint {
    LocalDate startDate;
    LocalDate endDate;
    int numberOfDays;
    private Project project;
    private List<Epic> epics;

    @Override
    public String toString() {
        return "SprintEnitty{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", numberOfDays=" + numberOfDays +
                ", projectEnitty=" + project +
                ", epics=" + epics +
                '}';
    }
}
