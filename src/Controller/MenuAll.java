package Controller;

import IO.ReaderAndWriteProduct;
import Model.Product;

import java.util.Scanner;



public class MenuAll {
    static Scanner scanner = new Scanner(System.in);
    static manageProduct manageProducts = new manageProduct();
    static ReaderAndWriteProduct readerAndWriteProduct = new ReaderAndWriteProduct();


    public static Product admin() {
        System.out.println("---------------- Menu ----------------");
        System.out.println("|    1. Danh mục sản phẩm             |");
        System.out.println("|    2. Thêm mới sản phẩm             |");
        System.out.println("|    3. Chỉnh sửa thông tin sản phẩm  |");
        System.out.println("|    4. Xóa sản phẩm                  |");
        System.out.println("|    5. Sắp xếp sản phẩm              |");
//        System.out.println("6. In mẫu thống kê sản phẩm");
        System.out.println("|    6. Sản phẩm có giá trị đắt nhất: |");
        System.out.println("|    7. Đọc file                      |");
        System.out.println("|    8. Ghi file                      |");
        System.out.println("|    9. Log out                       |");
        System.out.println("▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆");
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
                System.out.println("1. Sắp xếp theo giá");
                System.out.println("2. Sắp xếp theo số lượng");
                System.out.println("3. Sắp xếp theo mã sản phẩm");
                int choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1) {
                case 1:
                    manageProducts.sortByPrize();
                case 2:
                    manageProducts.sortByAmount();
                case 3:
                    manageProducts.sortById();
            }
                manageProducts.show();
            break;
            case 6:
                manageProducts.searchExpensiveProduct();
                break;
//
            case 7:
                manageProducts.products = readerAndWriteProduct.reader();
                System.out.println("đã đọc");
                manageProducts.show();
                MenuAll.admin();
                break;
            case 8:
                readerAndWriteProduct.write(manageProducts.products);
                System.out.println("đã ghi");
                manageProducts.show();
                MenuAll.admin();
                break;
            case 9:
                new ManagerRegisteredAccount();
                break;
//        }
//        ;

//        public void member() {
//
//        }
//        ;
        }
        return null;
    }

}
