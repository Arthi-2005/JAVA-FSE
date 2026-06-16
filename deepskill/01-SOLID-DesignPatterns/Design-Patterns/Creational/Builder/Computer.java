package Creational.Builder;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private boolean hasGraphicsCard;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
    }

    public void specs() {
        System.out.println("CPU: " + cpu + ", RAM: " + ram + ", Storage: " + storage + ", GPU: " + hasGraphicsCard);
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private boolean hasGraphicsCard;

        public Builder setCpu(String cpu) { this.cpu = cpu; return this; }
        public Builder setRam(String ram) { this.ram = ram; return this; }
        public Builder setStorage(String storage) { this.storage = storage; return this; }
        public Builder setHasGraphicsCard(boolean gpu) { this.hasGraphicsCard = gpu; return this; }
        public Computer build() { return new Computer(this); }
    }
}
