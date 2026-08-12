package com.pdsa.recommendation_tool.controller;

import com.pdsa.recommendation_tool.dto.RecommendationResponse;
import com.pdsa.recommendation_tool.service.RecommendationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendation")
@CrossOrigin(origins = "http://localhost:5173")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(
            RecommendationService recommendationService) {

        this.recommendationService =
                recommendationService;
    }
    
    // GET RECOMMENDATION

    @GetMapping
    public ResponseEntity<RecommendationResponse> getRecommendation(
            @RequestParam String currentLocation) {

        RecommendationResponse response =
                recommendationService.getRecommendation(
                        currentLocation
                );

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }
}