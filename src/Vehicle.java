public class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected int speed;
    protected int gear;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = 0;  // Default speed
        this.gear = 1;   // Default gear
    }

    public void start() {
        System.out.println(brand + " " + model + " is starting...");
    }

    public void changeSpeed(int newSpeed) {
        this.speed = newSpeed;
        System.out.println(brand + " " + model + " is now running at " + speed + " km/h.");
    }

    public void changeGear(int newGear) {
        this.gear = newGear;
        System.out.println(brand + " " + model + " changed to gear " + gear + ".");
    }
}
