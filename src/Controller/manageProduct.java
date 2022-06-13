package Controller;

import IO.ReaderAndWriteProduct;
import Model.Product;
import Sort.SortByAmount;
import Sort.SortById;
import Sort.SortByPrize;
import validate.ValidateProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class manageProduct {
    Scanner scanner = new Scanner(System.in);
   public static ArrayList products = new ArrayList<>();
    ValidateProduct validateProduct = new ValidateProduct();
    ReaderAndWriteProduct readerAndWriteProduct = new ReaderAndWriteProduct();

    public Product show() {
        for (int i = 0; i < products.size(); i++) {
            if (i % 5 == 0 && i != 0) {
                scanner.nextLine();
            }
            System.out.println(products.get(i));
        }
        MenuAll.admin();
        return null;
    }


    public Product createProduct() {
        int Id = validateProduct.validateID(products);
        String Name = validateProduct.validateString("Tên sản phẩm: ");
        int Prize = validateProduct.validatePrize();
        int Amount = validateProduct.validateAmount();
        String Describe = validateProduct.validateString("Mô tả: ");
              return new Product(Id, Name, Prize, Amount, Describe);



    }

    public void addProduct(Product product) {
        products.add(product);
        show();
    }

    public void editProduct() {
        System.out.println("Nhập id cần sửa ");
        int Id = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexId(Id, products);
        if (index != -1) {
            Product p=createProduct();
            products.set(index,p );
            show();
        } else {System.out.println("Id không tồn tại");
            editProduct();
        }
    }

    public void deleteStudent() {
        System.out.println("Nhập id cần xóa ");
        int Id = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexId(Id, products);
        if (index != -1) {
            System.out.println();
            products.remove(index);
        } else System.out.println("Id không tồn tại");
        show();
    }

    public void sortByPrize() {
        products.sort(new SortByPrize());
        System.out.println(" Đã sắp xếp");
        show();
    }
    public void sortByAmount() {
        products.sort(new SortByAmount());
        System.out.println(" Đã sắp xếp");
        show();
    }
    public void sortById() {
        products.sort(new SortById());
        System.out.println(" Đã sắp xếp");
        show();
    }

}

