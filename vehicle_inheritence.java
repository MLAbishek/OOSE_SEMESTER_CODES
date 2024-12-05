
class Vehicle {
    int noOfSeats;
    int noOfWheels;

    Vehicle(int wheel, int seats) {
        this.noOfWheels = wheel;
        this.noOfSeats = seats;
    }

    void display() {
        System.out.println("The vehicle has " + noOfWheels + " Wheels and " + noOfSeats + " seats");
    }
}

class car extends Vehicle {
    car(int seat) {
        super(4, seat);
    }

    void display() {
        System.out.println("The car has " + noOfWheels + " wheels and" + noOfSeats + " seats");
    }
}

class bike extends Vehicle {
    bike(int seat) {
        super(2, seat);
    }

    void display() {
        System.out.println("The bike has " + noOfWheels + " wheels and" + noOfSeats + " seats");
    }
}

public class vehicle_inheritence {
    public static void main(String[] args) {
        Vehicle v;
        v = new car(5);
        v.display();
        v = new bike(3);
        v.display();

    }
}
