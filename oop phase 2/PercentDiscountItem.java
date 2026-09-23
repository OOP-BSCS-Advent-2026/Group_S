/**
 * An {@link Item} that receives a percentage discount once a minimum
 * purchase quantity (the threshold) is reached.
 */
public class PercentDiscountItem extends Item {
    private int threshold;
    private double percentOff;

    /**
     * Creates a new item with a percentage-based bulk discount.
     *
     * @param name       the display name of the item
     * @param price      the unit price; must be greater than zero
     * @param threshold  the minimum quantity required to trigger the discount
     * @param percentOff the percentage to subtract from the subtotal (e.g. 5 = 5% off)
     */
    public PercentDiscountItem(String name, double price, int threshold, double percentOff) {
        super(name, price);
        this.threshold = threshold;
        this.percentOff = percentOff;
    }

    /**
     * Calculates the total cost, applying the percentage discount only
     * if the purchased quantity meets or exceeds the threshold.
     *
     * @param quantity the number of units being purchased
     * @return the discounted total if the threshold is met, otherwise the full price
     */
    @Override
    public double calculateTotal(int quantity) {
        double subtotal = super.calculateTotal(quantity);
        // Discount only applies once quantity meets or exceeds the threshold.
        if (quantity >= threshold) {
            subtotal = subtotal * (1 - percentOff / 100.0);
        }
        return subtotal;
    }
}