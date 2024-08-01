package com.bicoin.bitcoin.service;

import java.text.ParseException;

import com.bicoin.bitcoin.domain.Bpi;


public interface BitcoinService {

	Bpi getBitcoins(String startDate, String endDate, String currency) throws ParseException;
}