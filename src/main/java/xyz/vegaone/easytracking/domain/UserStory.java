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
public class UserStory {

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
    private Feature feature;

    @Column(name = "task")
    @OneToMany(mappedBy = "userStory")
    private List<Task> taskList;

    @Column(name = "bug")
    @OneToMany(mappedBy = "userStory")
    private List<Bug> bugList;

    @Override
    public String toString() {
        return "UserStory{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", feature=" + feature +
                ", taskList=" + taskList +
                ", bugList=" + bugList +
                '}';
    }
}
