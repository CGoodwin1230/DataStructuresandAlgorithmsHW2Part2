package edu.monmouth.hw1;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import edu.monmouth.vehicle.*;
public class HW1 {
	public static void main(String[] args) {
		final int REQUIREDARGS=1, BADARGS=1, BADREDIRECT=2;
		
		if(args.length != REQUIREDARGS) {
			System.err.println("Give the name of a log file");
			System.exit(BADARGS);
		}
		try {
			PrintStream redirectStream = new PrintStream(args[0]);
			System.setOut(redirectStream);
			System.setErr(redirectStream);
		} catch(FileNotFoundException ioe) {
			System.err.println("Cannot redirect stderr and stdout " + ioe.getMessage());
			ioe.printStackTrace();
			System.exit(BADREDIRECT);
		}

		VehicleList vehicleList = new VehicleList();
		
		System.out.println("First: " + vehicleList.first());
		System.out.println("Removed first: " + vehicleList.removeFirst());
		System.out.println("Last: " + vehicleList.last());
		System.out.println("Number of Vehicles in list: " + vehicleList.size());
		System.out.println("Is list empty: " + vehicleList.isEmpty());
		System.out.println("Entire list: \n" + vehicleList);
		
		Vehicle fishingBoat=null, battleShip=null, cruiseShip=null, tesla=null, camaro=null, f350=null, harley=null, ninja=null, ducati=null;

		try {
			fishingBoat=new Boat(PowerTypes.Gasoline, 12);
			battleShip=new Boat(PowerTypes.FuelOil, 900);
			cruiseShip=new Boat(PowerTypes.Diesel, 500);
			tesla=new Car(PowerTypes.Electricity, 12);
			camaro=new Car(PowerTypes.Gasoline, 10);
			f350=new Car(PowerTypes.Diesel, 4);
			harley=new Motorcycle(PowerTypes.Gasoline);
			ninja=new Motorcycle(PowerTypes.Gasoline);
			ducati=new Motorcycle(PowerTypes.Gasoline);
		} catch(BoatException be) {
			System.out.println(be.getMessage());
			be.printStackTrace();
		} catch(CarException ce) {
			System.out.println(ce.getMessage());
			ce.printStackTrace();
		}
		Vehicle invalidBoat=null, invalidCar=null;
		try {
			invalidBoat = new Boat(PowerTypes.FuelOil, -8);
		} catch(BoatException be) {
			System.out.println(be.getMessage());
			be.printStackTrace();
		}
		try {
			invalidCar = new Car(PowerTypes.Gasoline, -4);
		} catch (CarException ce) {
			System.out.println(ce.getMessage());
			ce.printStackTrace();
		}
		
		vehicleList.insert(fishingBoat);
		vehicleList.insert(cruiseShip);
		vehicleList.insert(tesla);
		vehicleList.insert(f350);
		vehicleList.insert(harley);
		vehicleList.insert(ninja);
		vehicleList.insert(ducati);
			
		System.out.println("After inserting Vehicles: \n" + vehicleList);
		
		vehicleList.insertEnd(camaro);
		 
		System.out.println("After adding another Vehicle to end: \n" + vehicleList);
		
		System.out.println("First: " + vehicleList.first().toString());
		
		System.out.println("Last: " + vehicleList.last());

		System.out.println("Removed first: " + vehicleList.removeFirst());
		System.out.println("list after removing first: \n" + vehicleList);

		vehicleList.insert(battleShip);
		System.out.println("list after adding another Vehicle: \n" + vehicleList);
		System.out.println("Number of Vehicles in list with motorcycles: " + vehicleList.size());
		System.out.println("Is list empty: " + vehicleList.isEmpty());
	}

}
