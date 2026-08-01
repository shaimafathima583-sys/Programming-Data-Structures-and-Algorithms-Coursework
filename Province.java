public class Province {

    private String name;
    private int population;


    // Constructor
    public Province(String name, int population) {

        this.name = name;
        this.population = population;

    }


    // Getter for province name
    public String getName() {

        return name;

    }


    // Getter for population
    public int getPopulation() {

        return population;

    }


    // Display province details
    public void displayDetails() {

        System.out.println("Province Details");
        System.out.println("------------------------");

        System.out.println("Province Name : " + name);
        System.out.println("Population    : " + population);

        System.out.println("------------------------");

    }


    // To display object name in graph
    @Override
    public String toString() {

        return name;

    }
    
}
