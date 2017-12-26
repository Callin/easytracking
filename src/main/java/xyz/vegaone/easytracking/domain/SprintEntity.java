package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "sprint")
public class SprintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @Column(name = "numberOfDays")
    private int numberOfDays;

    @ManyToOne
    @JoinColumn(name = "project")
    private ProjectEntity project;

    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    private List<UserStoryEntity> userStoryList;

    @Override
    public String toString() {
        return "SprintEntity{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", numberOfDays=" + numberOfDays +
                ", project=" + project +
                ", userStoryList=" + userStoryList +
                '}';
    }
}
