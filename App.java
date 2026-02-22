public class App {
    public static void main(String[] args) {
        Car[] cargo = new Car[100];

        addNewCar(cargo, "Toyota", 50);
        addNewCar(cargo, "Saab", 60);
        addNewCar(cargo, "Ferrari", 20);

        int carCount = Car.getCarCount();

        for (int i = 0; i < carCount; i++) {
            Car car = cargo[i];
            String msg = car.toString("Milan");
            System.out.println(msg);
        }

        double result = Math.sqrt(carCount);
        System.out.println("Square root of car count: " + result);

        System.out.println("You have total " + Car.getTotalTyreCount() + " tyres in your cargo.");
    }

    public static void addNewCar(Car[] cars, String brand, int gasLevel) {
        Car newCar = new Car(brand, gasLevel, 4);
        cars[Car.getCarCount() - 1] = newCar;
    }
}
