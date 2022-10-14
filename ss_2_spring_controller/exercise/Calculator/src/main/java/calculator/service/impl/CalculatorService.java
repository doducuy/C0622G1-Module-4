package calculator.service.impl;

import calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {


    @Override
    public String calculate(double operatorOne, double operatorTwo, String calculation) {
        String result="Số Chia Không Được Bằng 0";
        switch (calculation){
            case "Addition(+)":
                result = operatorOne+operatorTwo+"";
                break;
            case "Subtraction(-)":
                result = operatorOne-operatorTwo+"";
                break;
            case "Multiplication(*)":
                result = operatorOne*operatorTwo+"";
                break;
            case "Division(/)":
                if(operatorTwo==0){
                    return result;
                }
                result = operatorOne/operatorTwo+"";
                break;
        }
        return result;
    }
}
