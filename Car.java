public class Car {
    private String brand;
    private int gasLevel;
    private int speed;
    private boolean engineRunning;
    private int tyreCount;
    private static int carCount = 0;
    private static int totalTyreCount = 0;

    // Default constructor
    public Car() {
        this("No brand", 0, 4);
    }

    // Parameterized constructor – direct field assignment with validation
    public Car(String brand, int gasLevel, int tyreCount) {
        this.brand = brand;
        this.gasLevel = (gasLevel < 0) ? 0 : gasLevel;           // enforce non-negative
        this.speed = 0;
        this.engineRunning = false;

        // Validate tyreCount and update static total
        int newTyreCount = (tyreCount < 0) ? 0 : tyreCount;
        totalTyreCount += newTyreCount;   // add to static total
        this.tyreCount = newTyreCount;

        carCount++;   // increment static car count
    }

    // Static getters
    public static int getCarCount() {
        return carCount;
    }

    public static int getTotalTyreCount() {
        return totalTyreCount;
    }

    // Getter and setter for brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter and setter for gasLevel (with validation)
    public int getGasLevel() {
        return gasLevel;
    }

    public void setGasLevel(int gasLevel) {
        this.gasLevel = (gasLevel < 0) ? 0 : gasLevel;
    }

    // Getter and setter for speed (with validation)
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = (speed < 0) ? 0 : speed;
    }

    // Getter and setter for engineRunning
    public boolean isEngineRunning() {
        return engineRunning;
    }

    public void setEngineRunning(boolean engineRunning) {
        this.engineRunning = engineRunning;
    }

    // Getter and setter for tyreCount (updates static total)
    public int getTyreCount() {
        return tyreCount;
    }

    public void setTyreCount(int tyreCount) {
        int newCount = (tyreCount < 0) ? 0 : tyreCount;
        totalTyreCount = totalTyreCount - this.tyreCount + newCount;
        this.tyreCount = newCount;
    }

    // Required method: returns a welcome message (called from App.java)
    public String toString(String name) {
        return "Hello " + name + ", welcome to your car: " + brand + ", " + gasLevel + "% full.";
    }

    // Required method from class diagram
    public String retHelloMessage(String name) {
        return toString(name);
    }

    // Engine control
    public void startEngine() {
        engineRunning = true;
    }

    public void stopEngine() {
        engineRunning = false;
    }

    // Acceleration (only if engine is running)
    public void accelerate() {
        if (engineRunning) {
            speed += 10;
        }
    }

    // Brake (decrease speed, never below 0)
    public void brake() {
        speed -= 10;
        if (speed < 0) speed = 0;
    }
}
