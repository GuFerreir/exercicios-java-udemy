package entities;

public class OrderItem {
	private int quantity;
	private double price;	
	private Product produto;
	
	public OrderItem(){}
	
	public OrderItem(int quantity, double price, Product produto) {
		this.quantity = quantity;
		this.price = price;
		this.produto = produto;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduto() {
		return produto;
	}

	public double subTotal(){
		return price * quantity;
	}

	
	

}
