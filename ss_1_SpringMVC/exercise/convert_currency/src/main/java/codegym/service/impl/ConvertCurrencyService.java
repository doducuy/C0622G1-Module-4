package codegym.service.impl;

import codegym.service.IConvertCurrencyService;
import org.springframework.stereotype.Service;

@Service
public class ConvertCurrencyService implements IConvertCurrencyService {
    @Override
    public double Convert(double usd, double rate) {
        return usd*rate;
    }
}
