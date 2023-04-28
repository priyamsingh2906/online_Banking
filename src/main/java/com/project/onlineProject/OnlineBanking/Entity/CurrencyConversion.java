package com.project.onlineProject.OnlineBanking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency_conversion")
public class CurrencyConversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency")
    private String fromCurrency;

    @Column(name = "to_currency")
    private String toCurrency;

    @Column(name = "conversion_rate")
    private double conversionRate;

    // Getters and setters

    public CurrencyConversion() {
    }

    public CurrencyConversion(String fromCurrency, String toCurrency, double conversionRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionRate = conversionRate;
    }

	public double getConversionRate() {
		// TODO Auto-generated method stub
		return 0;
	}
}

