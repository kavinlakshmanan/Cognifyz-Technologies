import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Temperature Converter");
        System.out.println("Enter the temperature value:");
        
        Scanner scanner = new Scanner(System.in);
        double temperature = scanner.nextDouble();
        
        System.out.println("Enter the unit of measurement (Celsius or Fahrenheit):");
        String unit = scanner.next();
        scanner.close();
        
        double convertedTemperature;
        if (unit.equalsIgnoreCase("Celsius")) {
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println(temperature + " Celsius is equal to " + convertedTemperature + " Fahrenheit.");
        } else if (unit.equalsIgnoreCase("Fahrenheit")) {
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println(temperature + " Fahrenheit is equal to " + convertedTemperature + " Celsius.");
        } else {
            System.out.println("Invalid unit of measurement. Please enter either Celsius or Fahrenheit.");
            return;
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

