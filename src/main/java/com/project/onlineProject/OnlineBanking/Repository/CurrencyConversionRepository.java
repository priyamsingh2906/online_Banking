package com.project.onlineProject.OnlineBanking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.onlineProject.OnlineBanking.Entity.CurrencyConversion;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long> {
    CurrencyConversion findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);

	CurrencyConversion findByCurrencyPair(String fromCurrency, String toCurrency);
}
