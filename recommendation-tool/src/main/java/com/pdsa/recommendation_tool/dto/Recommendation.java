package com.pdsa.recommendation_tool.dto;

public class Recommendation<T> {

    private final T candidate;
    private final double opportunityScore;
    private final double distanceFromStart;
    private final double finalScore;

    public Recommendation(T candidate, double opportunityScore, double distanceFromStart, double finalScore) {
        this.candidate = candidate;
        this.opportunityScore = opportunityScore;
        this.distanceFromStart = distanceFromStart;
        this.finalScore = finalScore;
    }

    public T getCandidate() {
        return candidate;
    }

    public double getOpportunityScore() {
        return opportunityScore;
    }

    public double getDistanceFromStart() {
        return distanceFromStart;
    }

    public double getFinalScore() {
        return finalScore;
    }

    @Override
    public String toString() {
        return String.format(
                "%s -> opportunityScore=%.2f, distance=%.1fkm, finalScore=%.2f",
                candidate, opportunityScore, distanceFromStart, finalScore
        );
    }
}
