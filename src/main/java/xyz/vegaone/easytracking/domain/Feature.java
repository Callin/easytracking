package xyz.vegaone.easytracking.domain;

import lombok.Getter;
import lombok.Setter;
import xyz.vegaone.easytracking.utils.Status;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Feature {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Status status;

    @Column(name = "epic")
    @ManyToOne
    private Epic epic;

    @Column(name = "userstory")
    @OneToMany(mappedBy = "feature")
    private List<UserStory> userStories;

    @Override
    public String toString() {
        return "FeatureDao{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", epic=" + epic +
                ", userStories=" + userStories +
                '}';
    }
}
