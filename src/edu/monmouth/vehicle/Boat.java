package edu.monmouth.vehicle;

public class Boat implements Vehicle {

    private int boatLength;
    private PowerTypes powerSource;

    public Boat(PowerTypes powerSource,
                int boatLength)
                throws BoatException {

        setPowerSource(powerSource);
        setBoatLength(boatLength);
    }

    public int getBoatLength() {
        return boatLength;
    }

    public void setBoatLength(int boatLength)
            throws BoatException {

        if(boatLength < VehicleConstants.MIN_BOAT_LENGTH
                || boatLength > VehicleConstants.MAX_BOAT_LENGTH) {

            throw new BoatException(
                    "Invalid boat length: " + boatLength);
        }

        this.boatLength = boatLength;
    }

    @Override
    public void go() {
        System.out.println("Boat is moving");
    }

    @Override
    public void stop() {
        System.out.println("Boat stopped");
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

        return "Boat [boatLength="
                + boatLength
                + ", powerSource="
                + powerSource
                + "]";
    }
    @Override
    public boolean equals(Object obj) {

        if(obj == null) {
            return false;
        }

        if(!(obj instanceof Boat)) {
            return false;
        }

        Boat other = (Boat)obj;

        return boatLength == other.boatLength
                && powerSource == other.powerSource;
    }
}