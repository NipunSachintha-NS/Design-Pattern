public class StrategyPatternDemo {
    public interface TravelStrategy {
        void travel(String destination);
    }

    public class CarTravelStrategy implements TravelStrategy {
        @Override
        public void travel(String destination) {
            System.out.println("Traveling to " + destination + " by car.");
            // Implement actual car travel logic here
        }
    }

    public class BicycleTravelStrategy implements TravelStrategy {
        @Override
        public void travel(String destination) {
            System.out.println("Traveling to " + destination + " by bicycle.");
            // Implement actual bicycle travel logic here
        }
    }

    public class Traveler {
        private TravelStrategy strategy;

        public void setStrategy(TravelStrategy strategy) {
            this.strategy = strategy;
        }

        public void travel(String destination) {
            strategy.travel(destination);
        }
    }

    public static void main(String[] args) {
        StrategyPatternDemo demo = new StrategyPatternDemo();
        Traveler traveler = demo.new Traveler();

        // Travel by Car
        traveler.setStrategy(demo.new CarTravelStrategy());
        traveler.travel("New York");

        // Travel by Bicycle
        traveler.setStrategy(demo.new BicycleTravelStrategy());
        traveler.travel("Central Park");
    }
}
