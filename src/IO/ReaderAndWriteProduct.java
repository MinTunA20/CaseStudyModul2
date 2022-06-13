package IO;

import Model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriteProduct {
    File file = new File("product.csv");

    public void write(List<Product> products){
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p:products){
                bufferedWriter.write(p.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Product> reader(){
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str !=null){
                String[] arr = str.split(",");
                int Id = Integer.parseInt(arr[0]);
                String Name = arr[1];
                int Prize = Integer.parseInt(arr[2]);
                int Amount = Integer.parseInt(arr[3]);
                String Describe = arr[4];

                products.add(new Product(Id, Name, Prize, Amount, Describe));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;


    }
}
