package org.example.DesignPatterns;

public class Factory {

    // Abstract base class
    public static abstract class Computer {
        public abstract String getRAM();

        @Override
        public String toString() {
            return "RAM= " + this.getRAM();
        }
    }

    // Concrete PC class
    public static class PC extends Computer {
        private String ram;

        public PC(String ram) {
            this.ram = ram;
        }

        @Override
        public String getRAM() {
            return this.ram;
        }
    }

    // Concrete Server class
    public static class Server extends Computer {
        private String ram;

        public Server(String ram) {
            this.ram = ram;
        }

        @Override
        public String getRAM() {
            return this.ram;
        }
    }

    // Factory class
    public static class ComputerFactory {
        public static Computer getComputer(String type, String ram) {
            if ("PC".equalsIgnoreCase(type)) return new PC(ram);
            else if ("Server".equalsIgnoreCase(type)) return new Server(ram);
            return null;
        }
    }

    // Main method
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("pc", "2 GB");
        Computer server = ComputerFactory.getComputer("server", "16 GB");

        System.out.println("Factory PC Config:: " + pc);
        System.out.println("Factory Server Config:: " + server);
    }
}

