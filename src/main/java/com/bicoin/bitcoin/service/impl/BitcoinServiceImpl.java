package com.bicoin.bitcoin.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bicoin.bitcoin.domain.Bitcoins;
import com.bicoin.bitcoin.domain.Bpi;
import com.bicoin.bitcoin.service.BitcoinService;

@Service
public class BitcoinServiceImpl implements BitcoinService {

	final String bitcoinsURL = "https://api.coindesk.com/v1/bpi/historical/close.json";
	final String currencyURL = "https://v6.exchangerate-api.com/v6/c3f99da3506e341d99d0ce13/latest/USD?Key=c3f99da3506e341d99d0ce13";
	final RestTemplate restTemplate;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
	
	public BitcoinServiceImpl(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	
	@Override
	public Bpi getBitcoins(String startDate, String endDate, String currency) throws ParseException {
		ResponseEntity<Bitcoins> response = restTemplate.getForEntity(bitcoinsURL, Bitcoins.class);
		Bpi bpi = response.getBody().getBpi();
		SortedMap<String, Double> subMaps = displayBitcoinPrice(startDate, endDate, currency, bpi.getAdditionalProperties());
		bpi.updateMap(subMaps);
		return bpi;
	}
	//find the historical Bitcoin price along with the highest & lowest price markers 
	//for a user provided Start date, End date and Output Currency along with the default USD value
	
	private SortedMap<String, Double> displayBitcoinPrice(String startDate, String endDate, String currency, Map<String, Double> map) throws ParseException {
    	TreeMap<String, Double> treeMap = new TreeMap<>();
    	treeMap.putAll(map);
    	SortedMap<String, Double> subMaps = treeMap.subMap(startDate, endDate);
    	Map<String, Double> currencyMap = getCurrency();
    	Double conversionPrice = currencyMap.get(currency);
    	System.out.println("Date"+"  "+"Currency"+"Bitcoin Price"+"  "+" "+"USD"+"\n");
    	subMaps.forEach((k,v)->System.out.println(k+"  "+currency+" "+v+" "+conversionPrice*v));
    	
    	System.out.println("Mininmum Bitcoin Price :");
    	System.out.print("Date :"+subMaps.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey());
		System.out.print(" | Bitcoin Price :"+currency+" "+subMaps.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue());
		System.out.println(" | USD :"+conversionPrice*subMaps.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue());
		
		System.out.println("Maximum Bitcoin Price :");
    	System.out.print("Date :"+subMaps.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());
		System.out.print(" | Bitcoin Price :"+currency+" "+subMaps.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue());
		System.out.println(" | USD :"+conversionPrice*subMaps.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue());
		
		return subMaps;
	}
	
	// Get Currency
	private Map<String, Double> getCurrency() {
		ResponseEntity<Map> response = restTemplate.getForEntity(currencyURL, Map.class);
		Map<String, Double> map = (Map<String, Double>) response.getBody().get("conversion_rates");
		System.out.println(map.get("USD"));
		return map;
	}
		
}
