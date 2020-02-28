package at.ac.fhcampus.master.micro.accumulated.repositories;

import at.ac.fhcampus.master.micro.accumulated.entities.AccumulatedRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccumulatedRatingRepository extends JpaRepository<AccumulatedRating, Long> {
    @Query("FROM AccumulatedRating ar WHERE ar.articleId = :articleId")
    Optional<AccumulatedRating> findByArticleId(@Param("articleId") Long articleId);
}
