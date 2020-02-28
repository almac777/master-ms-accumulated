package at.ac.fhcampus.master.micro.accumulated.services;

import at.ac.fhcampus.master.micro.accumulated.entities.AccumulatedRating;
import at.ac.fhcampus.master.micro.shared.RatingDto;

import java.util.List;

public interface AccumulatedRatingService {
    List<AccumulatedRating> list();
    RatingDto accumulate(RatingDto ratingDto);
}
