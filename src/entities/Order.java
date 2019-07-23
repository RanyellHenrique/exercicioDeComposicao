package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private OrderStatus status;
	private Date moment;
	private Client client;

	private List<OrdemItem> items = new ArrayList<>();

	public Order(OrderStatus status, Date moment, Client client) {
		this.status = status;
		this.moment = moment;
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrdemItem> getItems() {
		return items;
	}
	
	public void addItems(OrdemItem item) {
		items.add(item);
	}
	
	public void removeItems(OrdemItem item) {
		items.remove(item);
	}
	
	public double total() {
		double soma = 0;
		for (OrdemItem item : items) {
			soma += item.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrdemItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

}
