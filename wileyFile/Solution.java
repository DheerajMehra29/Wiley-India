package Aug_26;

import java.util.Scanner;

class Laptop {
    private int laptopId;
    private String brandName;
    private String processorName;
    private String storageType;
    private int price;

    Laptop(int laptopId, String brandName, String processorName, String storageType, int price) {
        this.laptopId = laptopId;
        this.brandName = brandName;
        this.processorName = processorName;
        this.storageType = storageType;
        this.price = price;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Laptop[] array = new Laptop[3];
        for (int i = 0; i < 3; i++) {
            int laptopId = Integer.parseInt(scanner.nextLine());
            String brandName = scanner.nextLine();
            String processorName = scanner.nextLine();
            String storageType = scanner.nextLine();
            int price = Integer.parseInt(scanner.nextLine());
            array[i] = new Laptop(laptopId, brandName, processorName, storageType, price);
        }
        int id = Integer.parseInt(scanner.nextLine());
        scanner.close();
        // System.out.println("Output: ");
        Laptop obj1 = getLaptopWithMaxPrice(array);
        if (obj1 != null) {
            System.out.println(obj1.getBrandName());
        }
        // System.out.println((obj1 == null)?"":obj1.getBrandName());

        String output = getBrandWithGivenId(array, id);
        if (output != null) {
            System.out.println(output);
        } else {
            System.out.println("No matching Laptop.");
        }
        // System.out.println((output != null)?output:"No matching Laptop.");
    }

    static Laptop getLaptopWithMaxPrice(Laptop[] array) {
        // int maxPrice = 0;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getPrice() > array[j].getPrice()) {
                // maxPrice = array[i].getPrice();
                j = i;
            }
        }
        return array[j];
    }

    static String getBrandWithGivenId(Laptop[] array, int laptopId) {
        String brand = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getLaptopId() == laptopId) {
                brand = array[i].getBrandName();
                break;
            }
        }
        return brand;
    }

}
