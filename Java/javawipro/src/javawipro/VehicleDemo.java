package javawipro;

abstract class Vehicle {
    // Abstract methods that must be implemented by subclasses
    public abstract void startEngine();
    public abstract void stopEngine();
}

class racecar extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine started with key ignition.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped.");
    }
}

class Motorcycle extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine started with self-start button.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Motorcycle engine stopped.");
    }
}

// Renamed this class to avoid the conflict with the file name
public  class VehicleDemo {
    public static void main(String[] args) {
        // Creating instances of Car and Motorcycle using VehicleBase reference
        Vehicle myCar = new racecar();
        Vehicle myMotorcycle = new Motorcycle();

        // Performing actions on the car
        System.out.println("Car:");
        myCar.startEngine();
        myCar.stopEngine();

        // Performing actions on the motorcycle
        System.out.println("\nMotorcycle:");
        myMotorcycle.startEngine();
        myMotorcycle.stopEngine();
    }
}
