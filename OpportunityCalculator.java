public class OpportunityCalculator {


    public static double calculateScore(Location location) {


        double score = 0;


        // More population = more customers

        score += location.getPopulation() * 0.00001;



        // Higher purchasing power is better

        score += location.getPurchasingPower() * 0.5;



        // More facilities are better

        score += location.getFacilities() * 0.3;



        // More competition reduces opportunity

        score -= location.getCompetition() * 0.4;



        return score;

    }

}