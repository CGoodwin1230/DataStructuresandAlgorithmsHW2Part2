package edu.monmouth.vehicle;

public class Motorcycle implements Vehicle {

    private PowerTypes powerSource;

    public Motorcycle(PowerTypes powerSource) {

        setPowerSource(powerSource);
    }

    public PowerTypes getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerTypes powerSource) {
        this.powerSource = powerSource;
    }

    @Override
    public void go() {
        System.out.println("Motorcycle is moving");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle stopped");
    }

    @Override
    public PowerTypes powerBy() {
        return powerSource;
    }

    @Override
    public String toString() {

        return "Motorcycle [powerSource="
                + powerSource
                + "]";
    }
    @Override
    public boolean equals(Object obj) {

        if(obj == null) {
            return false;
        }

        if(!(obj instanceof Motorcycle)) {
            return false;
        }

        Motorcycle other = (Motorcycle)obj;

        return powerSource == other.powerSource;
    }
}