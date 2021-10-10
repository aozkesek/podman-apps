package ao.stocks.repo;

import org.springframework.data.repository.CrudRepository;

import ao.stocks.model.Stock;

public interface StockRepo extends CrudRepository<Stock, String>{

}
