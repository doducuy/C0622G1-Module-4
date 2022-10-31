package uy.service.impl;

import uy.service.IConvertCurrencyService;

public class ConvertCurrencyService implements IConvertCurrencyService {
    @Override
    public double convertCurrency(double usd, double rate) {
        return usd*rate;
    }
}
