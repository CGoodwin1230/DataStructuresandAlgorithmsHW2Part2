package edu.monmouth.hw1;

import edu.monmouth.vehicle.Vehicle;

public class VehicleList {

    private VehicleNode head;

    public VehicleList() {

        head = null;
    }

    public void insert(Vehicle vehicle) {

        VehicleNode newNode =
                new VehicleNode(vehicle);

        newNode.setNext(head);

        head = newNode;
    }

    public void insertEnd(Vehicle vehicle) {

        VehicleNode newNode =
                new VehicleNode(vehicle);

        if(isEmpty()) {
            head = newNode;
            return;
        }

        VehicleNode current = head;

        while(current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
    }

    public Vehicle first() {

        if(isEmpty()) {
            return null;
        }

        return head.getVehicle();
    }

    public Vehicle last() {

        if(isEmpty()) {
            return null;
        }

        VehicleNode current = head;

        while(current.getNext() != null) {
            current = current.getNext();
        }

        return current.getVehicle();
    }

    public Vehicle removeFirst() {

        if(isEmpty()) {
            return null;
        }

        Vehicle temp = head.getVehicle();

        head = head.getNext();

        return temp;
    }

    public boolean isEmpty() {

        return head == null;
    }

    public int size() {

        int count = 0;

        VehicleNode current = head;

        while(current != null) {

            count++;

            current = current.getNext();
        }

        return count;
    }

    @Override
    public String toString() {

        String output = "";

        VehicleNode current = head;

        while(current != null) {

            output += current + "\n";

            current = current.getNext();
        }

        return output;
    }
}