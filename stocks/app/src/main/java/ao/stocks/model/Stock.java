package ao.stocks.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("stock")
public class Stock {
	
	@Id Long id;
	String name;
	Double price;
	Double quantity;
	
	Stock() {	
	}
	
	public static Stock of(Long id, String name, Double price, Double quantity) {
		Stock stock = new Stock();
		stock.id = id;
		stock.name = name;
		stock.price = price;
		stock.quantity = quantity;
		return stock;
	}

	
}
