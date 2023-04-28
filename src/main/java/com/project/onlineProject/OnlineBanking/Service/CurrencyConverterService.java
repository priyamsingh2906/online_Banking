package com.project.onlineProject.OnlineBanking.Service;

import org.springframework.stereotype.Service;

import com.project.onlineProject.OnlineBanking.Entity.CurrencyConversion;
import com.project.onlineProject.OnlineBanking.Repository.CurrencyConversionRepository;

@Service
public class CurrencyConverterService {
    private final CurrencyConversionRepository conversionRepository;

    public CurrencyConverterService(CurrencyConversionRepository conversionRepository) {
        this.conversionRepository = conversionRepository;
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        CurrencyConversion conversion = conversionRepository.findByCurrencyPair(fromCurrency, toCurrency);

        if (conversion == null) {
            throw new IllegalArgumentException("Currency conversion rate not found.");
        }

        return amount * conversion.getConversionRate();
    }
}
