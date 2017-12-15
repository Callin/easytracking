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

    @OneToMany(mappedBy = "sprint")
    private List<Epic> epicList;

    @Override
    public String toString() {
        return "Sprint{" + "id=" + id + '}';
    }
}
