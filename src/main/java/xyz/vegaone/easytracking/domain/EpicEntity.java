package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "epic")
public class EpicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "sprint")
    private SprintEntity sprintEntity;

    @OneToMany(mappedBy = "epic")
    private List<FeatureEntity> featureEntityList;

    @Override
    public String toString() {
        return "EpicEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", sprintEntity=" + sprintEntity +
                ", featureEntityList=" + featureEntityList +
                '}';
    }
}
