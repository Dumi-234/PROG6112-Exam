public class PrintProduct {

    // Instance variable to hold the reference to the product data
    private IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }

    public void printTotalSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    
    public void printAverageSales() {
        double average = product.GetAverageProductSold();
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(average));
    }

    
    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    
    public void printFullReport() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        printTotalSales();
        printAverageSales();
        printMostPopularProduct();
    }
}
