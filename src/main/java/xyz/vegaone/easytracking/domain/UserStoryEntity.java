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
    private FeatureEntity feature;

    @ManyToOne
    @JoinColumn(name = "sprint")
    private SprintEntity sprint;

    @OneToMany(mappedBy = "userStory", cascade=CascadeType.ALL)
    private List<TaskEntity> taskList;

    @OneToMany(mappedBy = "userStory", cascade=CascadeType.ALL)
    private List<BugEntity> bugList;

    @Override
    public String toString() {
        return "UserStoryEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", feature=" + feature +
                ", sprint=" + sprint +
                ", taskList=" + taskList +
                ", bugList=" + bugList +
                '}';
    }
}
