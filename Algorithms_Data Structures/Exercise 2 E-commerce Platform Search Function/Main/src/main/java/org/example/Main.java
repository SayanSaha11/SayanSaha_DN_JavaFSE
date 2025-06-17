import org.example.Product;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.UUID;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("System ID: " + getSystemId() + "\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = Integer.parseInt(scanner.nextLine());
        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Product " + (i + 1));
            System.out.print("Product ID: ");
            String id = scanner.nextLine();
            System.out.print("Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();
            products[i] = new Product(id, name, category);
        }

        System.out.print("Enter product name to search: ");
        String searchKey = scanner.nextLine();

        long startLinear = System.nanoTime();
        Product linearResult = linearSearch(products, searchKey);
        long endLinear = System.nanoTime();
        System.out.println("\n=== Linear Search ===");
        System.out.println(linearResult != null ? linearResult : "Product not found");
        System.out.println("Time taken: " + (endLinear - startLinear) + " ns");

        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));

        long startBinary = System.nanoTime();
        Product binaryResult = binarySearch(products, searchKey);
        long endBinary = System.nanoTime();
        System.out.println("\n=== Binary Search ===");
        System.out.println(binaryResult != null ? binaryResult : "Product not found");
        System.out.println("Time taken: " + (endBinary - startBinary) + " ns");
    }

    public static String getSystemId() {
        try {
            for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b : mac) {
                        sb.append(String.format("%02X", b));
                    }
                    return UUID.nameUUIDFromBytes(sb.toString().getBytes()).toString();
                }
            }
        } catch (Exception e) {
            return "UNKNOWN";
        }
        return "NO-MAC";
    }

    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = products[mid].getProductName().compareToIgnoreCase(name);
            if (compare == 0) return products[mid];
            else if (compare < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}
