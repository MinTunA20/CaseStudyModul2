package Sort;

import Model.Product;

import java.util.Comparator;

public class SortById implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getId() > o2.getId()){
            return 1;
        }
        return -1;
    }
}
