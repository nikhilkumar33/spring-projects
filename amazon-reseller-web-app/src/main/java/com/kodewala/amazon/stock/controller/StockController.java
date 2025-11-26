package com.kodewala.amazon.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StockController 
{
	int currStock;
	
	@RequestMapping("/createStockPage")
	public String showStockPage()
	{
		return "createStock";
	}
	
	@PostMapping("/addStock")
	public String createStock(@RequestParam("stock") String stock)
	{
		int newStock = Integer.parseInt(stock);
		currStock = newStock;
		return "amazon-reseller-home";
	}
	
	@RequestMapping("/updateStockPage")
	public String showUpdatePage(Model model)
	{
		model.addAttribute("currStock", currStock);
		return "updateStock";
	}
	
	@PostMapping("/updateStock")
	public String updateStock(@RequestParam("stock") String stock)
	{
		int newStock = Integer.parseInt(stock);
		currStock = newStock;
		return "amazon-reseller-home";
	}
	
	@RequestMapping("/deleteStockPage")
	public String showDeletePage(Model model)
	{
		model.addAttribute("currStock", currStock);
		return "deleteStock";
	}
	
	@RequestMapping("/deleteStock")
	public String deleteStock()
	{
		currStock = 0;
		return "amazon-reseller-home";
	}
	
	@RequestMapping("/viewStockPage")
	public String showStockPage(Model model)
	{
		model.addAttribute("currStock", currStock);
		return "viewStock";
	}
}
