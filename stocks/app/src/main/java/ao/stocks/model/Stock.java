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

	
}
