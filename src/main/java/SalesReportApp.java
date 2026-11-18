import java.util.Scanner;

public class SalesReportApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] names = {
                "Cozy Nights Monarch mattress",
                "Restonic Barbados mattress",
                "Sealy Phuket mattress"
            };
            
            int[][] sales = new int[3][3];
            
            // 1. Gather input from the user (same as Q1.1)
            for (int i = 0; i < names.length; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("Enter number of sales for month " + (j + 1) + " for " + names[i] + ": ");
                    sales[i][j] = scanner.nextInt();
                }
                System.out.println();
            }

            // 2. Instantiate the Product class, passing the arrays to the constructor
            Product productReport = new Product(names, sales);
            
            // 3. Generate the report by calling the methods from the interface/class
            System.out.println("PRODUCT SALES REPORT - 2026");
            System.out.println("*************************************************");
            System.out.println("TOTAL PRODUCT SALES: " + productReport.getTotalProductsSold());
            System.out.println("AVERAGE PRODUCT SALES: " + Math.round(productReport.getAverageProductsSold()));
            System.out.println("MOST POPULAR PRODUCT: " + productReport.getMostPopularProduct());
        }
    }
}
