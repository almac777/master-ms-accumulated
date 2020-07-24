package at.ac.fhcampus.master.micro.accumulated.services;

import at.ac.fhcampus.master.micro.accumulated.entities.AccumulatedRating;
import at.ac.fhcampus.master.micro.accumulated.repositories.AccumulatedRatingRepository;
import at.ac.fhcampus.master.micro.shared.RatingDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultAccumulatedRatingService implements AccumulatedRatingService {

    private final AccumulatedRatingRepository accumulatedRatingRepository;

    @Override
    public List<AccumulatedRating> list() {
        return accumulatedRatingRepository.findAll();
    }

    @Override
    public RatingDto accumulate(RatingDto ratingDto) {
        var accumulated = accumulatedRatingRepository.findByArticleId(ratingDto.getArticleId());
        AccumulatedRating accumulatedRating = null;
        if (accumulated.isEmpty()) {
            accumulatedRating = AccumulatedRating.builder()
                    .articleId(ratingDto.getArticleId())
                    .completionRating(Double.valueOf(ratingDto.getCompletionRating()))
                    .objectivityRating(Double.valueOf(ratingDto.getObjectivityRating()))
                    .amount(1L)
                    .build();
        } else {
            var acc = accumulated.get(0);
            var amount = acc.getAmount();
            var objectivityRating = acc.getObjectivityRating() * amount;
            var completionRating = acc.getCompletionRating() * amount;
            amount++;
            var newObjectivityRating = (objectivityRating + ratingDto.getObjectivityRating()) / amount;
            var newCompletionRating = (completionRating + ratingDto.getCompletionRating()) / amount;
            accumulatedRating = AccumulatedRating.builder()
                    .id(acc.getId())
                    .articleId(ratingDto.getArticleId())
                    .completionRating(newCompletionRating)
                    .objectivityRating(newObjectivityRating)
                    .amount(amount)
                    .build();
        }
        this.accumulatedRatingRepository.save(accumulatedRating);
        return ratingDto;
    }

    @Override
    public List<AccumulatedRating> byArticle(Long id) {
        return accumulatedRatingRepository.findByArticleId(id);
    }
}
