package edu.monmouth.vehicle;

public class Car implements Vehicle {

    private int engineSize;
    private PowerTypes powerSource;

    public Car(PowerTypes powerSource, int engineSize)
            throws CarException {

        setPowerSource(powerSource);
        setEngineSize(engineSize);
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize)
            throws CarException {

        if(engineSize < VehicleConstants.MIN_ENGINE_SIZE
                || engineSize > VehicleConstants.MAX_ENGINE_SIZE) {

            throw new CarException(
                    "Invalid engine size: " + engineSize);
        }

        this.engineSize = engineSize;
    }

    @Override
    public void go() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public PowerTypes powerBy() {
        return powerSource;
    }

    public void setPowerSource(PowerTypes powerSource) {
        this.powerSource = powerSource;
    }

    public PowerTypes getPowerSource() {
        return powerSource;
    }

    @Override
    public String toString() {

        return "Car [engineSize="
                + engineSize
                + ", powerSource="
                + powerSource
                + "]";
    }
    @Override
    public boolean equals(Object obj) {

        if(obj == null) {
            return false;
        }

        if(!(obj instanceof Car)) {
            return false;
        }

        Car other = (Car)obj;

        return engineSize == other.engineSize
                && powerSource == other.powerSource;
    }
}