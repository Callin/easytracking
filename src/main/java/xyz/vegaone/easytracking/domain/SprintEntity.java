package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

import java.util.List;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "sprintEntity")
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
    @JoinColumn(name = "projectEntity")
    private ProjectEntity projectEntity;

    @OneToMany(mappedBy = "sprintEntity")
    private List<EpicEntity> epicEntityList;

    @Override
    public String toString() {
        return "SprintEntity{" + "id=" + id + '}';
    }
}
