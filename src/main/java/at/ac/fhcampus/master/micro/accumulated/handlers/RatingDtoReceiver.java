package at.ac.fhcampus.master.micro.accumulated.handlers;

import at.ac.fhcampus.master.micro.accumulated.services.AccumulatedRatingService;
import at.ac.fhcampus.master.micro.shared.RatingDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class RatingDtoReceiver {

    private final AccumulatedRatingService accumulatedRatingService;

    @RabbitListener(queues = {"accumulated-ratings"})
    public void receive(RatingDto ratingDto) {
        Optional.of(ratingDto)
                .map(RatingDto.class::cast)
                .map(this::printRatingDto)
                .map(accumulatedRatingService::accumulate)
                .orElseThrow(() -> new RuntimeException("Failed to unpack"));
    }

    private RatingDto printRatingDto(RatingDto input) {
        log.info("ratingDto received! {}", input);
        return input;
    }

}
