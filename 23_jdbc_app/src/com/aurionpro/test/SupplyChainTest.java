package com.aurionpro.test;

import com.aurionpro.model.SupplyChainDb;

import java.util.Scanner;

public class SupplyChainTest {

    public static void main(String[] args) {
        SupplyChainDb supplyChainDb = new SupplyChainDb();
        supplyChainDb.connectToDb();
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Select an option:");
            System.out.println("1. List all products with their supplier names");
            System.out.println("2. Get all orders with their details (including product names and quantities)");
            System.out.println("3. Find all suppliers who have supplied a specific product");
            System.out.println("4. List all products and their current inventory levels");
            System.out.println("5. Find all orders placed within the last month");
            System.out.println("6. Get total quantity ordered for each product");
            System.out.println("7. Retrieve all orders along with the total amount spent for each order");
            System.out.println("8. Find products supplied by more than one supplier");
            System.out.println("9. Get the average inventory level for each product");
            System.out.println("10. List suppliers who have not supplied any products");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline left-over

            switch (choice) {
                case 1:
                    supplyChainDb.getProductsWithSuppliers();
                    break;
                case 2:
                    supplyChainDb.getAllOrdersWithDetails();
                    break;
                case 3:
                	
                    supplyChainDb.findSuppliersForProduct();
                    break;
                case 4:
                    supplyChainDb.listAllProductsAndInventory();
                    break;
                case 5:
                    supplyChainDb.findAllOrdersLastMonth();
                    break;
                case 6:
                    supplyChainDb.getTotalQuantityOrderedForEachProduct();
                    break;
                case 7:
                    supplyChainDb.retrieveAllOrdersWithTotalAmount();
                    break;
                case 8:
                    supplyChainDb.findProductsSuppliedByMoreThanOneSupplier();
                    break;
                case 9:
                    supplyChainDb.getAverageInventoryForEachProduct();
                    break;
                case 10:
                    supplyChainDb.listSuppliersWithoutProducts();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            System.out.println();  
        }

        scanner.close();
    }
}
