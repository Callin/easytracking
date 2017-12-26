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

    @OneToMany(mappedBy = "epic", cascade = CascadeType.ALL)
    private List<FeatureEntity> featureList;

    @ManyToOne
    @JoinColumn(name = "project")
    private ProjectEntity project;

    @Override
    public String toString() {
        return "EpicEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", featureList=" + featureList +
                ", project=" + project +
                '}';
    }
}
