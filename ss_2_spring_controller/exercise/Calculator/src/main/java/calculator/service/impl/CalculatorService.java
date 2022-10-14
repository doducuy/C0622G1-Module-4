package calculator.service.impl;

import calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {


    @Override
    public double calculate(double operatorOne, double operatorTwo, String calculation) {
        double result =0;
        switch (calculation){
            case "Addition(+)":
                result = operatorOne+operatorTwo;
                break;
            case "Subtraction(-)":
                result = operatorOne-operatorTwo;
                break;
            case "Multiplication(*)":
                result = operatorOne*operatorTwo;
                break;
            case "Division(/)":
                result = operatorOne/operatorTwo;
                break;
        }
        return result;
    }
}
