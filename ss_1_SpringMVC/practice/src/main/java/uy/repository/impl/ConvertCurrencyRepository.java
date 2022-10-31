package uy.repository.impl;

import org.springframework.stereotype.Repository;
import uy.repository.IConvertCurrencyRepository;
@Repository
public class  ConvertCurrencyRepository implements IConvertCurrencyRepository {

    @Override
    public double convertCurrency(double usd, double rate) {
        return usd*rate;
    }
}
