package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	public Order(){}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItens() {
		return itens;
	}
	
	public void addItem(OrderItem item){
		itens.add(item);		
	}
	
	public void removeItem(OrderItem item){
		itens.remove(item);
	}
	
	public double total(){
		double sum = 0;
		for(OrderItem c : itens){
			sum += c.subTotal();
		} 	
		return sum; 
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " (" + sdf2.format(client.getBirthDate()) + ")");
		sb.append(" - " + client.getEmail() + "\n");
		sb.append("Order itens:\n");
		
		for(OrderItem c : itens){
			sb.append(c.getProduto().getName());
			sb.append(", ");
			sb.append("$" + c.getProduto().getPrice());
			sb.append(", ");
			sb.append(" Quantity: " + c.getQuantity());
			sb.append(", ");
			sb.append("SubTotal: $" + c.subTotal() + "\n");
		}
		
		sb.append("Total price: $" + total());
		
		return sb.toString();
	}
	
	
	
	
	

}
