package BuilderPatternExample;

public class TestBuilderPattern {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();

        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .build();
        Computer officeComputer = new Computer.Builder("AMD Ryzen 5", "16GB")
                .setStorage("512GB SSD")
                .build();
        System.out.println("Basic Computer:");
        basicComputer.displayConfiguration();

        System.out.println("Gaming Computer:");
        gamingComputer.displayConfiguration();

        System.out.println("Office Computer:");
        officeComputer.displayConfiguration();
    }
}

