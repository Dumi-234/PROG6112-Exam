public class ProductCalculations {
    
    private double productPrice;

    // Constructor to receive the price when an object is created
    public ProductCalculations(double productPrice) {
        this.productPrice = productPrice;
    }

    public double GetVat() {
        // VAT: 15% of the product price
        return productPrice * 0.15;
    }

    public double GetCommission() {
        // Commission: 5% of the product price
        return productPrice * 0.05;
    }

    public double GetTotal() {
        // Total Sale Amount: Price + VAT + Commission
        // We call the methods here to use the calculated values
        return productPrice + GetVat() + GetCommission();
    }
}