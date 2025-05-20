import java.util.Comparator;
import java.util.TreeSet;

class Laptop implements Comparable<Laptop>{
	
	private int laptopId;
	private String brand;
	private String processor;
	private String storageType;
	private int price;
	
	public Laptop(int laptopId, String brand, String processor, String storageType, int price) {
		this.laptopId = laptopId;
		this.brand = brand;
		this.processor = processor;
		this.storageType = storageType;
		this.price = price;
	}
	
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
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

	@Override
	public int compareTo(Laptop l) {
		if (this.laptopId > l.laptopId) { // ascending order
            return 1;
        } else if (this.laptopId < l.laptopId) {
            return -1;
        } else {
            return 0;
        }
	}
}

public class ComparatorVsComparable {
	private static void display(TreeSet<Laptop> set) {
		// TODO Auto-generated method stub
		Laptop b1 = new Laptop(1210, "Dell", "i3", "SSD", 10000);
        Laptop b2 = new Laptop(233, "HP", "i5", "SSD", 20000);
        Laptop b3 = new Laptop(1010, "Lenovo", "i7", "SSD", 40000);
        
        set.add(b1);
        set.add(b2);
        set.add(b3);
        
        for (Laptop b : set) {
            System.out.println(b.getLaptopId() + " " + b.getBrand() + " " + b.getProcessor() + " " + b.getStorageType() + " " + b.getPrice());
        }
		System.out.println();
	}

	public static void main(String[] args) {
		
		// descending order of id
		Comparator<Laptop> obj = (l1, l2) -> {
			if (l1.getLaptopId() < l2.getLaptopId()) { 
	            return 1;
	        } else if (l1.getLaptopId() > l2.getLaptopId()) {
	            return -1;
	        } else {
	            return 0;
	        }
		};
		
		TreeSet<Laptop> set = new TreeSet<>(obj);
		display(set);
		
		// descending order of price
		Comparator<Laptop> obj1 = (l1, l2) -> {
			if (l1.getPrice() < l2.getPrice()) {
	            return 1;
	        } else if (l1.getPrice() > l2.getPrice()) {
	            return -1;
	        } else {
	            return 0;
	        }
		};
		
		set = new TreeSet<>(obj1);
		display(set);
		
		// ascending order of price
		Comparator<Laptop> obj2 = (l1, l2) -> {
			if (l1.getPrice() > l2.getPrice()) {
	            return 1;
	        } else if (l1.getPrice() < l2.getPrice()) {
	            return -1;
	        } else {
	            return 0;
	        }
		};
		
		set = new TreeSet<>(obj2);
        display(set);
	}

}
