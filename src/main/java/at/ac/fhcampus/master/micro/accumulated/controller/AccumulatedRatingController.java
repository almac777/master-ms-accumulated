package at.ac.fhcampus.master.micro.accumulated.controller;

import at.ac.fhcampus.master.micro.accumulated.entities.AccumulatedRating;
import at.ac.fhcampus.master.micro.accumulated.services.AccumulatedRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AccumulatedRatingController.BASE_URL)
public class AccumulatedRatingController {
    static final String BASE_URL = "";
    private static final String ROOT_URL = "/";

    private final AccumulatedRatingService accumulatedRatingService;

    @GetMapping(ROOT_URL)
    public List<AccumulatedRating> list() {
        return this.accumulatedRatingService.list();
    }
}
