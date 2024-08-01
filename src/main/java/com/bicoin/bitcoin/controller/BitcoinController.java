package com.bicoin.bitcoin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bicoin.bitcoin.domain.Bitcoins;
import com.bicoin.bitcoin.domain.Bpi;
import com.bicoin.bitcoin.service.BitcoinService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/bits")
@Api(value="Bitcoin Controller for Swagger")
public class BitcoinController {

	@Autowired
	BitcoinService bitcoinService;

	@GetMapping("/all")
	@ApiOperation(value="Bitcoin Controller")
	@ApiResponses(value= {
	@ApiResponse(code=200,message="Successful Retrieval",response=Bitcoins.class)
	})
	Bpi getBitcoins(String startDate, String endDate, String currency){
		Bpi map = new Bpi();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	System.out.println(sdf.parse(startDate).before(sdf.parse(endDate)));
        	boolean dateCompare = sdf.parse(startDate).before(sdf.parse(endDate));
        	if(dateCompare == true)
        		map = bitcoinService.getBitcoins(startDate, endDate, currency);			
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			//map.updateMap(Configurations.offlineBpi.getAdditionalProperties());
		}
        return map;
	}
}
