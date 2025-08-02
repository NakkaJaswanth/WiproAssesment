package javawipro;

 class Vehicle {
    String color;
    int wheels;
    String model;

    Vehicle(String color, int wheels, String model) {
        this.color = color;
        this.wheels = wheels;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Wheels: " + wheels);
    }

    public void start() {
        System.out.println(model + " is starting.");
    }

    public void stop() {
        System.out.println(model + " is stopping.");
    }
}

class Truck extends VehicleDemo {
    public Truck(String color, String model) {
        super(color, 6, model);  
    }

    public void loadGoods() {
        System.out.println(model + " is loading goods.");
    }

	public void displayInfo() {
		// TODO Auto-generated method stub
		
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}
}

class Bus extends VehicleDemo {
    public Bus(String color, String model) {
        super(color, 4, model); 
    }

    public void boardPassengers() {
        System.out.println(model + " is boarding passengers.");
    }

	public void displayInfo() {
		// TODO Auto-generated method stub
		
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}
}

class Car extends VehicleDemo {
    public Car(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public void Car(String color, String model) {
        super(color, 4, model);  
    }

    public void playMusic() {
        String model = null;
		System.out.println(model + " is playing music.");
    }

	public void displayInfo() {
		// TODO Auto-generated method stub
		
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}
}

public class Road {
    public static void main(String[] args) {
        Truck truck = new Truck("Red", "Volvo Truck");
        Car car = new Car("Blue", "Toyota Corolla");
        Bus bus = new Bus("Yellow", "City Bus");

        System.out.println("\n--- Truck Info ---");
        truck.displayInfo();
        truck.start();
        truck.loadGoods();
        truck.stop();

        System.out.println("\n--- Car Info ---");
        car.displayInfo();
        car.start();
        car.playMusic();
        car.stop();

        System.out.println("\n--- Bus Info ---");
        bus.displayInfo();
        bus.start();
        bus.boardPassengers();
        bus.stop();
    }
}
