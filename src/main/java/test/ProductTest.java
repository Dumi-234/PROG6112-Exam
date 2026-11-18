package test; 

import com.mycompany.prog6112exam.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; 
import org.junit.jupiter.api.Test;

public class ProductTest {

    private Product product;
    private String[] testProductNames;
    private int[][] testSalesData;

    public void setUp() {
        testProductNames = new String[]{
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        testSalesData = new int[][]{
            {25, 18, 20}, // Cozy Nights: Total = 63
            {15, 10, 12}, // Restonic: Total = 37
            {18, 15, 20}  // Sealy Phuket: Total = 53
        };
        
        // Total across all = 153
        // Average = 153 / 3 = 51

        // 2. Initialize the Product object before each test runs
        product = new Product(testProductNames, testSalesData);
    }

    @Test
    public void GetTotalProductsSales_WithValidData_ReturnsCorrectValue() {
        int expectedTotal = 153;
        int actualTotal = product.GetTotalProductsSold();
        assertEquals(expectedTotal, actualTotal, "The total products sold calculation is incorrect.");
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // Purpose: Verify that GetAverageProductSold correctly returns the average number of products sold.
        
        // Expected average: Total (153) divided by number of products (3)
        double expectedAverage = 51.0; 
        
        // Actual value returned by the method
        double actualAverage = product.GetAverageProductSold();
        
        // Assert that the expected matches the actual. 
        // We use a 'delta' (0.0) because it's a double, to handle minor floating-point inaccuracies.
        assertEquals(expectedAverage, actualAverage, 0.0, "The average product sold calculation is incorrect.");
    }

    private void assertEquals(int expectedTotal, int actualTotal, String the_total_products_sold_calculation_is_in) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
