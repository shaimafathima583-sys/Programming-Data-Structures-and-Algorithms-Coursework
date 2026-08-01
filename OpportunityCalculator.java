public class OpportunityCalculator {
    public double calculateScore(Location location) {

        // Normalize population (assuming max population = 1,000,000)
        double populationScore = (location.getPopulation() / 1000000.0) * 100;

        // Convert values to percentages
        double purchasingPowerScore = location.getPurchasingPower() * 100;
        double competitionScore = location.getCompetition() * 100;
        double facilitiesScore = location.getFacilities() * 100;

        // Opportunity Score Formula
        double score =
                (populationScore * 0.30) +
                (purchasingPowerScore * 0.35) +
                (facilitiesScore * 0.25) -
                (competitionScore * 0.10);

        return Math.round(score * 100.0) / 100.0;
    }
}
