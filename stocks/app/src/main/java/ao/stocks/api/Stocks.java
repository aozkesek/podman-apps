package ao.stocks.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ao.stocks.model.Stock;
import ao.stocks.repo.StockRepo;

@RestController
@RequestMapping("/stocks")
public class Stocks {

	@Autowired
	StockRepo stocks;

	@GetMapping("/list")
	@ResponseBody()
	public List<Stock> getList() {
		
		List<Stock> stockList = new ArrayList<>();
		
		return stockList;
	}
	
}