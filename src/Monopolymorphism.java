import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Property {
    private String name;
    private int cost;
    private String color;

    public Property(String name, int cost, String color) {
        this.name = name;
        this.cost = cost;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }
}

class ChanceSpot {
    private String name;

    public ChanceSpot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class TaxSpot {
    private String name;

    public TaxSpot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Railroad {
    private String name;

    public Railroad(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Monopolymorphism {
    private List<Property> properties;
    private List<ChanceSpot> chanceSpots;
    private List<TaxSpot> taxSpots;
    private List<Railroad> railroads;
    private String[] propertyColors = {"Purple", "White", "Magenta", "Orange", "Red", "Yellow", "Green", "Blue"};

    public Monopolymorphism() {
        properties = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (String color : propertyColors) {
                String name = generatePropertyName(color);
                int cost = getPropertyCost(color);
                Property property = new Property(name, cost, color);
                properties.add(property);
            }
        }

        chanceSpots = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String name = generateChanceSpotName();
            ChanceSpot chanceSpot = new ChanceSpot(name);
            chanceSpots.add(chanceSpot);
        }

        taxSpots = new ArrayList<>();
        taxSpots.add(new TaxSpot("Watershow"));
        taxSpots.add(new TaxSpot("Fireworks"));

        railroads = new ArrayList<>();
        railroads.add(new Railroad("Railroad 1"));
        railroads.add(new Railroad("Railroad 2"));
        railroads.add(new Railroad("Railroad 3"));
        railroads.add(new Railroad("Railroad 4"));

        Collections.shuffle(properties);
    }

    public void play() {
        System.out.println("Welcome to Monopoly Junior!");
        System.out.println("You have " + properties.size() + " properties to buy.");
        for (Property property : properties) {
            System.out.println("Do you want to buy " + property.getName() + " for $" + property.getCost() + "?");
            // Add your game logic here
        }
    }

    private String generatePropertyName(String color) {
        Random random = new Random();
        String[] names = {"Park Place", "Boardwalk", "Broadway", "Madison", "Lexington", "Fifth Avenue", "Wall Street", "Rodeo Drive"};
        int index = random.nextInt(names.length);
        return color + " " + names[index];
    }

    private String generateChanceSpotName() {
        Random random = new Random();
        String[] names = {"Go to Restroom", "Loose Change", "Skip a Turn", "Extra $1", "Roll Again", "Move Forward 2 Spaces", "Go Back 1 Space", "Buy One Property for Half Price"};
        int index = random.nextInt(names.length);
        return names[index];
    }

    private int getPropertyCost(String color) {
        switch (color) {
            case "Purple":
                return 1;
            case "White":
            case "Magenta":
                return 2;
            case "Orange":
            case "Red":
                return 3;
            case "Yellow":
            case "Green":
                return 4;
            case "Blue":
                return 5;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Monopolymorphism game = new Monopolymorphism();
        game.play();
    }
}