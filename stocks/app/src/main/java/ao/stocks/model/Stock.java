package ao.stocks.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("stock")
public class Stock {
	
	@Id String id;
	String name;
	Double price;
	Double quantity;
	
	Stock() {	
	}
	
	public static Stock of(String id, String name, Double price, Double quantity) {
		Stock stock = new Stock();
		stock.id = id;
		stock.name = name;
		stock.price = price;
		stock.quantity = quantity;
		return stock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	
	
}
