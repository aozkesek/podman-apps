package ao.stocks.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ao.stocks.model.Stock;
import ao.stocks.repo.StockRepo;

@RestController
@RequestMapping("/stocks")
public class Stocks {

	@Autowired
	StockRepo stocks;

	@PutMapping("/save")
	public Stock putStock(@RequestBody() Stock stock) {
		if (stock == null || stock.getName() == null)
			return null;
		
		stock = stocks.save(stock);
		return stock;
	}
	
	@GetMapping("/list")
	@ResponseBody()
	public List<Stock> getList() {
		
		List<Stock> stockList = new ArrayList<>();
		stocks.findAll().forEach(stockList::add);		
		return stockList;
	}
	
	@GetMapping("/{id}")
	@ResponseBody()
	public Stock getStock(@PathVariable String id) {
		Optional<Stock> stock = stocks.findById(id);
		if (!stock.isEmpty())
			return stock.get();
		else
			return Stock.of(id, null, null, null);
	}
	
	
	
}
