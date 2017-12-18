package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "epicEnitty")
public class EpicEnitty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    private SprintEnitty sprintEnitty;

    @Column(name = "featureEnitty")
    @OneToMany(mappedBy = "epicEnitty")
    private List<FeatureEnitty> featureEnittyList;

    @Override
    public String toString() {
        return "EpicEnitty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", sprintEnitty=" + sprintEnitty +
                ", featureEnittyList=" + featureEnittyList +
                '}';
    }
}
