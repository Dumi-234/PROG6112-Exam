import java.util.Scanner;

public class SalesReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] productNames = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        // 2. Two-dimensional array for sales over three months
        int[][] salesData = new int[3][3];

        // Loop through each product to get their monthly sales
        for (int i = 0; i < productNames.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + productNames[i] + ": ");
                salesData[i][j] = scanner.nextInt();
            }
            System.out.println(); // Print a blank line to separate products like the screenshot
        }

        int grandTotalSales = 0;
        int mostPopularProductIndex = 0;
        int highestProductTotal = -1;

        // Calculate total sales and find the most popular product
        for (int i = 0; i < salesData.length; i++) {
            int currentProductTotal = 0;
            
            // Sum the 3 months of sales for the current product
            for (int j = 0; j < 3; j++) {
                currentProductTotal += salesData[i][j];
            }
            
            grandTotalSales += currentProductTotal;

            // Check if this product is the highest selling so far
            if (currentProductTotal > highestProductTotal) {
                highestProductTotal = currentProductTotal;
                mostPopularProductIndex = i;
            }
        }

        double averageSales = (double) grandTotalSales / productNames.length;


        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("*************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + grandTotalSales);
        // Using Math.round() to match the integer format in the sample screenshot (183 / 3 = 61)
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(averageSales)); 
        System.out.println("MOST POPULAR PRODUCT: " + productNames[mostPopularProductIndex] + " (" + highestProductTotal + ")");

        scanner.close();
    }
}
