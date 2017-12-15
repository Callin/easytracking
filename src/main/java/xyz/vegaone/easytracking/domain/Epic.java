package xyz.vegaone.easytracking.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Bogdan on 14/12/2017.
 */
@Entity
public class Epic {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="sprint")
    private Sprint sprint;
}
