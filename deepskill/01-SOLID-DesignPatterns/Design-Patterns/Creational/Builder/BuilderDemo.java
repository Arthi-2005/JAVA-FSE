package Creational.Builder;

public class BuilderDemo {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel i9")
                .setRam("32GB")
                .setStorage("1TB SSD")
                .setHasGraphicsCard(true)
                .build();
        gamingPC.specs();
    }
}
