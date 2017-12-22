package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "userStory")
public class UserStoryEntity {

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
    @JoinColumn(name = "feature")
    private FeatureEntity featureEntity;

    @OneToMany(mappedBy = "userStory")
    private List<TaskEntity> taskEntityList;

    @OneToMany(mappedBy = "userStory")
    private List<BugEntity> bugEntityList;

    @Override
    public String toString() {
        return "UserStoryEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", featureEntity=" + featureEntity +
                ", taskEntityList=" + taskEntityList +
                ", bugEntityList=" + bugEntityList +
                '}';
    }
}
