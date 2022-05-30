package controller;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInOut {

    public static List<Product> fileToProductList(File file) {

        List<Product> list = new ArrayList<>();

        try (Scanner reader = new Scanner(file)) {

            if (!reader.hasNext()) { return null; }

            while (reader.hasNext()) {

                String[] line = reader.nextLine().split(",");
                Product local = new Product(line);
                list.add(local);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return list;

    }

    public static boolean listToCsvOut(List<Product> list, File file) {

        if (list == null) {
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (list.size() == 0) {
            throw new IllegalStateException("The list cannot be empty!");
        }

        File out = new File(file.getParent() + "\\out");

        if (out.exists()) {
            System.out.println("Directory already exists!");
        } else {
            System.out.println("Directory created:" + out.mkdir());
        }

        File summary = new File(out + "\\summary.csv");

        try (BufferedWriter br = new BufferedWriter(new FileWriter(summary))) {

            for (Product p: list) {

                String line = String.format("%s,%.2f" , p.getName() , p.totalValue());
                br.write(line);
                br.newLine();

            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


}
