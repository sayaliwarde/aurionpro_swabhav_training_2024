package com.aurionpro.streams.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.aurionpro.streams.model.Country;
import com.aurionpro.streams.model.Region;

public class CountryRegionPrinter {
	public static void main(String[] args) {
    
        List<Region> regions = Arrays.asList(
            new Region(1, "Europe"),
            new Region(2, "Americas"),
            new Region(3, "Asia"),
            new Region(4, "Middle East and Africa")
        );

        List<Country> countries = Arrays.asList(
            new Country("IT", "Italy", 1),
            new Country("JP", "Japan", 3),
            new Country("US", "United States of America", 2),
            new Country("CA", "Canada", 2),
            new Country("CN", "China", 3),
            new Country("IN", "India", 3),
            new Country("AU", "Australia", 3),
            new Country("ZW", "Zimbabwe", 4),
            new Country("SG", "Singapore", 3),
            new Country("UK", "United Kingdom", 1),
            new Country("FR", "France", 1),
            new Country("DE", "Germany", 1),
            new Country("ZM", "Zambia", 4),
            new Country("EG", "Egypt", 4),
            new Country("BR", "Brazil", 2),
            new Country("CH", "Switzerland", 1),
            new Country("NL", "Netherlands", 1),
            new Country("MX", "Mexico", 2),
            new Country("KW", "Kuwait", 4),
            new Country("IL", "Israel", 4),
            new Country("DK", "Denmark", 1),
            new Country("HK", "HongKong", 3),
            new Country("NG", "Nigeria", 4),
            new Country("AR", "Argentina", 2),
            new Country("BE", "Belgium", 1)
        );

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an operation:");
            System.out.println("1. Get the name of the country from the country code");
            System.out.println("2. Get all countries in a region by region id");
            System.out.println("3. Find count of countries in each region");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter country code: ");
                    String countryCode = scanner.nextLine();
                    String countryName = countries.stream()
                                                  .filter(country -> country.getCountryCode().equalsIgnoreCase(countryCode))
                                                  .map(Country::getCountryName)
                                                  .findFirst()
                                                  .orElse("Country not found");
                    System.out.println("Country with code " + countryCode + ": " + countryName);
                    break;

                case 2:
                    System.out.print("Enter region id: ");
                    int regionId = scanner.nextInt();
                    scanner.nextLine();
                    List<String> countriesInRegion = countries.stream()
                                                              .filter(country -> country.getRegionId() == regionId)
                                                              .map(Country::getCountryName)
                                                              .collect(Collectors.toList());
                    System.out.println("Countries in region " + regionId + ": " + countriesInRegion);
                    break;

                case 3:
                    Map<Integer, Long> countriesCountByRegion = countries.stream()
                                                                         .collect(Collectors.groupingBy(Country::getRegionId, Collectors.counting()));
                    System.out.println("Country count by region: " + countriesCountByRegion);
                    break;

                case 4:
                    System.out.println("Exit");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}


