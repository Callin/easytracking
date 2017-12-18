package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

import java.util.List;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "sprintEnitty")
public class SprintEnitty {

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
    @JoinColumn(name = "projectEnitty")
    private ProjectEnitty projectEnitty;

    @OneToMany(mappedBy = "sprintEnitty")
    private List<EpicEnitty> epicEnittyList;

    @Override
    public String toString() {
        return "SprintEnitty{" + "id=" + id + '}';
    }
}
