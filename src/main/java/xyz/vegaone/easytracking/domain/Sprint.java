package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.dto.Epic;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity
@Table(name = "sprint")
public class Sprint {
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
    private Project project;

    @OneToMany(mappedBy = "epic")
    private List<Epic> epicList;

}





