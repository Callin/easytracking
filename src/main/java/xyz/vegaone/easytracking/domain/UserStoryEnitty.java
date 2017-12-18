package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "userStoryEnitty")
public class UserStoryEnitty {

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
    private FeatureEnitty featureEnitty;

    @Column(name = "task")
    @OneToMany(mappedBy = "userStoryEnitty")
    private List<TaskEnitty> taskEnittyList;

    @Column(name = "bug")
    @OneToMany(mappedBy = "userStoryEnitty")
    private List<BugEnitty> bugEnittyList;

    @Override
    public String toString() {
        return "UserStoryEnitty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", featureEnitty=" + featureEnitty +
                ", taskEnittyList=" + taskEnittyList +
                ", bugEnittyList=" + bugEnittyList +
                '}';
    }
}
