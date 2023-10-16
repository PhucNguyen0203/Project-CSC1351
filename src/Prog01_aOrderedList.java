import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prog01_aOrderedList {
    public static void main(String[] args) {
        // Step 2: Get input file from the user
        Scanner inputScanner = getInputFile("Enter input filename: ");
        aOrderedList<Car> orderedList = new aOrderedList<>();

        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            String[] tokens = line.split(",");

            if (tokens[0].equals("A")) {
                // Add a car to the ordered list
                if (tokens.length == 4) {
                    String make = tokens[1];
                    int year = Integer.parseInt(tokens[2]);
                    int price = Integer.parseInt(tokens[3]);
                    Car newCar = new Car(make, year, price);
                    orderedList.add(newCar);
                }
            } else if (tokens[0].equals("D")) {
                // Delete a car from the ordered list
                if (tokens.length == 3) {
                    String make = tokens[1];
                    int year = Integer.parseInt(tokens[2]);
                    // Implement delete logic
                }
            }
        }

        // Step 4: Get output file from the user
        PrintWriter outputWriter = getOutputFile("Enter output filename: ");
        outputWriter.println("Number of cars: " + orderedList.size());
        for (int i = 0; i < orderedList.size(); i++) {
            outputWriter.println(orderedList.get(i).toString());
        }

        // Close resources
        inputScanner.close();
        outputWriter.close();
    }

    public static Scanner getInputFile(String userPrompt) {
        Scanner scanner = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                Scanner inputScanner = new Scanner(System.in);
                System.out.print(userPrompt);
                String filename = inputScanner.next();
                File file = new File(filename);

                if (file.exists()) {
                    scanner = new Scanner(file);
                    validInput = true;
                } else {
                    System.out.println("File specified <" + filename + "> does not exist. Would you like to continue? <Y/N> ");
                    String response = inputScanner.next();

                    if (response.equalsIgnoreCase("N")) {
                        throw new FileNotFoundException("File not found.");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Program execution canceled.");
                System.exit(1);
            }
        }

        return scanner;
    }

    public static PrintWriter getOutputFile(String userPrompt) {
        PrintWriter printWriter = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                Scanner inputScanner = new Scanner(System.in);
                System.out.print(userPrompt);
                String filename = inputScanner.next();
                File file = new File(filename);

                if (!file.exists()) {
                    // Create the file if it doesn't exist
                    file.createNewFile();
                }

                printWriter = new PrintWriter(file);
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid output filename. Please try again.");
            }
        }

        return printWriter;
    }
}

class Car implements Comparable<Car> {
    private String make;
    private int year;
    private int price;

    public Car(String make, int year, int price) {
        this.make = make;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Car other) {
        if (!this.make.equals(other.make)) {
            return this.make.compareTo(other.make);
        }
        if (this.year != other.year) {
            return this.year - other.year;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Make: " + make + ", Year: " + year + ", Price: " + price;
    }
}

class aOrderedList<T extends Comparable<T>> {
    private final int SIZEINCREMENTS = 20;
    private T[] oList;
    private int listSize;
    private int numObjects;

    public aOrderedList() {
        listSize = SIZEINCREMENTS;
        oList = (T[]) new Comparable[listSize];
        numObjects = 0;
    }

    public void add(T newObject) {
        // Implement insertion in sorted order
        if (numObjects == listSize) {
            // Manage array size
            listSize += SIZEINCREMENTS;
            T[] newOList = (T[]) new Comparable[listSize];
            System.arraycopy(oList, 0, newOList, 0, oList.length);
            oList = newOList;
        }

        int i = numObjects - 1;
        while (i >= 0 && oList[i].compareTo(newObject) > 0) {
            oList[i + 1] = oList[i];
            i--;
        }
        oList[i + 1] = newObject;
        numObjects++;
    }

    public int size() {
        return numObjects;
    }

    public T get(int index) {
        if (index >= 0 && index < numObjects) {
            return oList[index];
        }
        return null;
    }
}
