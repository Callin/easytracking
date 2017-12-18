package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "featureEnitty")
public class FeatureEnitty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    private EpicEnitty epicEnitty;

    @Column(name = "userStoryEnitty")
    @OneToMany(mappedBy = "featureEnitty")
    private List<UserStoryEnitty> userStoryEnittyList;

    @Override
    public String toString() {
        return "FeatureEnitty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", epicEnitty=" + epicEnitty +
                ", userStoryEnittyList=" + userStoryEnittyList +
                '}';
    }
}
