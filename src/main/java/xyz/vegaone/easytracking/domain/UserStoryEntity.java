package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "userStoryEntity")
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
    private FeatureEntity featureEntity;

    @Column(name = "task")
    @OneToMany(mappedBy = "userStoryEntity")
    private List<TaskEntity> taskEntityList;

    @Column(name = "bug")
    @OneToMany(mappedBy = "userStoryEntity")
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
