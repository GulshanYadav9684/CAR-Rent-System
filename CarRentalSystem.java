import java.util.*;

class Car 
{
    private String name;
    private double pricePerDay;
    private boolean isAvailable;

    public Car(String name, double pricePerDay, boolean isAvailable) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Car Name: " + name + ", Price per Day: $" + pricePerDay + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

public class CarRentalSystem 
{
    private List<Car> cars;

    public CarRentalSystem() {
        cars = new ArrayList<>();
    }

    public void addCar(String name, double pricePerDay, boolean isAvailable) {
        cars.add(new Car(name, pricePerDay, isAvailable));
    }

    public void displayCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void rentCar(String name) {
        for (Car car : cars) {
            if (car.getName().equalsIgnoreCase(name)) {
                if (car.isAvailable()) {
                    car.setAvailable(false);
                    System.out.println("You have successfully rented the car: " + name);
                } else {
                    System.out.println("Sorry, the car is already rented.");
                }
                return;
            }
        }
        System.out.println("Car not found.");
    }

    public void returnCar(String name) {
        for (Car car : cars) {
            if (car.getName().equalsIgnoreCase(name)) {
                if (!car.isAvailable()) {
                    car.setAvailable(true);
                    System.out.println("You have successfully returned the car: " + name);
                } else {
                    System.out.println("The car was not rented.");
                }
                return;
            }
        }
        System.out.println("Car not found.");
    }

    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();
        system.addCar("Toyota Camry", 50.0, true);
        system.addCar("Honda Accord", 55.0, true);
        system.addCar("Tesla Model 3", 100.0, true);
        system.addCar("Mahindra Thar", 300.0, true);
        system.addCar("BMW", 400.0, true);
        system.addCar("SKoda", 450.0, true);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nGulshan Present's Car Rental System:");
            System.out.println("1. Display Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    system.displayCars();
                    break;
                case 2:
                    System.out.print("Enter the name of the car to rent: ");
                    String rentCarName = scanner.nextLine();
                    system.rentCar(rentCarName);
                    break;
                case 3:
                    System.out.print("Enter the name of the car to return: ");
                    String returnCarName = scanner.nextLine();
                    system.returnCar(returnCarName);
                    break;
                case 4:
                    System.out.println("Thank you for using the Car Rental System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
