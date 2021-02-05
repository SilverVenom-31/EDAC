package pojos;

public class Product {
private int id;
private String name;
private int price;
public Product(int i, String string, int j) {
	this.id = i;
	this.name = string;
	this.price = j;
	
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
}
