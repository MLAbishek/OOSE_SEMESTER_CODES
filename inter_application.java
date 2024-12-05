interface give {
    void put();
}

interface show extends give {
    void print();

}

class display implements show {
    public void print() {
        System.out.println("Hello world");
    }

    public void put() {
        System.out.println("by interface ");
    }
}

public class inter_application {
    public static void main(String[] args) {
        display d = new display();
        d.print();
    }
}
