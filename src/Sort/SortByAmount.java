package Sort;

import Model.Product;

import java.util.Comparator;

public class SortByAmount implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getAmount() > o2.getAmount()){
            return 1;
        }
        return -1;
    }
}
