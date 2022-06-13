package Controller;

import IO.ReaderAndWriteProduct;
import Model.Product;
import validate.ValidateProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAll {
    static Scanner scanner = new Scanner(System.in);
    static manageProduct manageProducts = new manageProduct();
    static ReaderAndWriteProduct readerAndWriteProduct = new ReaderAndWriteProduct();
    static ArrayList products = new ArrayList<>();
    ValidateProduct validateProduct = new ValidateProduct();

    public static Product admin() {
        System.out.println("===========Menu==========");
        System.out.println("1. Hiển thị");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Sản phẩm có giá trị đắt nhất: ");
        System.out.println("7. Đọc file");
        System.out.println("8. Ghi file");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                manageProducts.show();
                break;
            case 2:
                manageProducts.addProduct(manageProducts.createProduct());
                break;
            case 3:
                manageProducts.editProduct();
                break;
            case 4:
                manageProducts.deleteStudent();
                break;
            case 5:
                manageProducts.sortByPrize();
                break;
            case 6:
            case 7:
                products = readerAndWriteProduct.reader();
                System.out.println("đã đọc");
                break;
            case 8:
                readerAndWriteProduct.write(products);
                System.out.println("đã ghi");
                break;
        }
        ;

//        public void member() {
//
//        }
        ;
        return null;
    }
}
