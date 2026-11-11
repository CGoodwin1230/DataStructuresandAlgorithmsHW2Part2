package edu.monmouth.hw2;
import java.io.*;
import java.util.*;
import edu.monmouth.vehicle.*;
public class HW2 {

    public static void main(String[] args) {

        if(args.length != HW2Constants.REQUIRED_ARGS) {

            System.err.println(
                    "Give output file, string file and vehicle file");

            System.exit(1);
        }

        try {

            PrintStream redirectStream =
                    new PrintStream(args[0]);

            System.setOut(redirectStream);
            System.setErr(redirectStream);

        }
        catch(FileNotFoundException e) {

            System.err.println(
                    "Cannot create output file");

            return;
        }

        ArrayList<String> stringList =
                new ArrayList<String>();

        ArrayList<Vehicle> vehicleList =
                new ArrayList<Vehicle>();

        try {

            Scanner stringInput =
                    new Scanner(new File(args[1]));

            while(stringInput.hasNextLine()) {

                String line =
                        stringInput.nextLine();

                stringList.add(line);
            }

            stringInput.close();
        }
        catch(FileNotFoundException e) {

            System.err.println(
                    "Cannot open string file");
        }

        System.out.println(
                "String list empty: "
                + stringList.isEmpty());

        System.out.println();

        Iterator<String> stringIterator =
                stringList.iterator();

        while(stringIterator.hasNext()) {

            System.out.println(
                    stringIterator.next());
        }

        try {

            Scanner vehicleInput =
                    new Scanner(new File(args[2]));

            while(vehicleInput.hasNextLine()) {

                String line =
                        vehicleInput.nextLine();

                try {

                    String[] parts =
                            line.split(",");

                    if(parts.length != 3) {

                        throw new Exception();
                    }

                    if(parts[0].equalsIgnoreCase("c")) {

                        Vehicle car =
                                new Car(
                                        PowerTypes.valueOf(parts[1].trim()),
                                        Integer.parseInt(parts[2].trim()));

                        vehicleList.add(car);
                    }

                    else if(parts[0].equalsIgnoreCase("b")) {

                        Vehicle boat =
                                new Boat(
                                        PowerTypes.valueOf(parts[1].trim()),
                                        Integer.parseInt(parts[2].trim()));

                        vehicleList.add(boat);
                    }

                    else {

                        throw new Exception();
                    }
                }

                catch(Exception e) {

                    System.out.println(
                            "Invalid vehicle discarded: "
                            + line);
                }
            }

            vehicleInput.close();
        }
        catch(FileNotFoundException e) {

            System.err.println(
                    "Cannot open vehicle file");
        }

        System.out.println();

        System.out.println(
                "Vehicle list empty: "
                + vehicleList.isEmpty());

        System.out.println();

        Iterator<Vehicle> vehicleIterator =
                vehicleList.iterator();

        while(vehicleIterator.hasNext()) {

            System.out.println(
                    vehicleIterator.next());
        }
        System.out.println();
        System.out.println("REMOVE STRING AT INDEX 0");
        stringList.remove(0);

        Iterator<String> stringIterator2 =
                stringList.iterator();

        while(stringIterator2.hasNext()) {

            System.out.println(
                    stringIterator2.next());
        }

        System.out.println();
        System.out.println("REMOVE VEHICLE AT INDEX 0");

        vehicleList.remove(0);

        Iterator<Vehicle> vehicleIterator2 =
                vehicleList.iterator();

        while(vehicleIterator2.hasNext()) {

            System.out.println(
                    vehicleIterator2.next());
        }

        try {

            Vehicle existingVehicle =
                    new Car(
                            PowerTypes.Gasoline,
                            4);

            Vehicle missingVehicle =
                    new Car(
                            PowerTypes.Gasoline,
                            99);

            System.out.println();
            System.out.println(
                    "Contains existing vehicle: "
                    + vehicleList.contains(
                            existingVehicle));

            System.out.println(
                    "Contains missing vehicle: "
                    + vehicleList.contains(
                            missingVehicle));

        }
        catch(CarException e) {

            System.out.println(
                    e.getMessage());
        }
        System.out.println();
        System.out.println(
                "Number of Strings in List: "
                + stringList.size());

        System.out.println();
        System.out.println(
                "String List Forward");

        ListIterator<String> stringListIterator =
                stringList.listIterator();

        while(stringListIterator.hasNext()) {

            System.out.println(
                    stringListIterator.next());
        }

        System.out.println();
        System.out.println(
                "String List Reverse");

        while(stringListIterator.hasPrevious()) {

            System.out.println(
                    stringListIterator.previous());
        }

        System.out.println();
        System.out.println(
                "Number of Vehicles in List: "
                + vehicleList.size());

        System.out.println();
        System.out.println(
                "Vehicle List Forward");

        ListIterator<Vehicle> vehicleListIterator =
                vehicleList.listIterator();

        while(vehicleListIterator.hasNext()) {

            System.out.println(
                    vehicleListIterator.next());
        }

        System.out.println();
        System.out.println(
                "Vehicle List Reverse");

        while(vehicleListIterator.hasPrevious()) {

            System.out.println(
                    vehicleListIterator.previous());
        }

        try {

            Vehicle vehicleToRemove =
                    new Car(
                            PowerTypes.Gasoline,
                            4);

            vehicleList.remove(vehicleToRemove);

            System.out.println();
            System.out.println(
                    "Vehicle List After remove(Object)");

            Iterator<Vehicle> vehicleIterator3 =
                    vehicleList.iterator();

            while(vehicleIterator3.hasNext()) {

                System.out.println(
                        vehicleIterator3.next());
            }

        }
        catch(CarException e) {

            System.out.println(
                    e.getMessage());
        }
    }
    
}