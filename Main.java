public class Main {
    public static void main(String[] args) {
        Item[] items = {
            new PercentDiscountItem("Jersey", 35000, 3, 5),
            new NoDiscountItem("Ball", 25000),
            new FlatDiscountItem("Shoes", 80000, 2, 8000),
            new PercentDiscountItem("Gym Gloves", 15000, 4, 10)
        };

        int[] quantities = {2, 2, 1, 4};

        System.out.println("==== PROSPORT SHOP ====");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i].getName()
                    + " UGX " + items[i].getPrice());
        }

        System.out.println();
        System.out.println("==== RECEIPT ====");
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            double lineTotal = items[i].calculateTotal(quantities[i]);
            System.out.println(items[i].getName() + " x" + quantities[i]
                    + " = UGX " + lineTotal);
            total += lineTotal;
        }
        System.out.println("----------------------------------------------------");
        System.out.println("TOTAL = UGX " + total);
    }
}
