package at.ac.fhcampus.master.micro.accumulated.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "accumulated_ratings")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccumulatedRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double objectivityRating;
    private Double completionRating;

    private Long articleId;

    private Long amount;
}
