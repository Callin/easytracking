package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "feature")
public class FeatureEntity {

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
    @JoinColumn(name = "epic")
    private EpicEntity epic;

    @OneToMany(mappedBy = "feature", cascade=CascadeType.ALL)
    private List<UserStoryEntity> userStoryList;

    @Override
    public String toString() {
        return "FeatureEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", epic=" + epic +
                ", userStoryList=" + userStoryList +
                '}';
    }
}
