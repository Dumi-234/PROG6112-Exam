public class Product {
    // Instance variables for the single and two-dimensional arrays
    private String[] productNames;
    private int[][] salesData;

    // Constructor to initialize the data
    public Product(String[] productNames, int[][] salesData) {
        this.productNames = productNames;
        this.salesData = salesData;
    }

    // Distinct Method 1: Obtaining the total products sold
    public int getTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                total += salesData[i][j];
            }
        }
        return total;
    }

    // Distinct Method 2: Calculating the average products sold
    public double getAverageProductsSold() {
        // Reusing the total method to avoid duplicate logic
        int total = getTotalProductsSold();
        
        // Average is total sales divided by the number of products (rows)
        return (double) total / productNames.length;
    }

    // Distinct Method 3: Determining the most popular product
    public String getMostPopularProduct() {
        int highestTotal = -1;
        int mostPopularIndex = -1;

        for (int i = 0; i < salesData.length; i++) {
            int currentProductTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                currentProductTotal += salesData[i][j];
            }

            if (currentProductTotal > highestTotal) {
                highestTotal = currentProductTotal;
                mostPopularIndex = i;
            }
        }

        
        if (mostPopularIndex != -1) {
            return productNames[mostPopularIndex] + " (" + highestTotal + ")";
        }
        return "N/A";
    }
}
