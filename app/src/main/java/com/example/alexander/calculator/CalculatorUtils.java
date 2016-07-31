package com.example.alexander.calculator;

/**
 * Created by Alexander on 30/07/2016.
 */
public class CalculatorUtils
{
    /**Calculate 2 values together based on an operator**/
    public static double calculate(double temp1, double temp2, String op)
    {
        double tempR = 0;
        if(op.equals("+"))
        {
            tempR = temp1 + temp2;
        }
        else if(op.equals("-"))
        {
            tempR = temp1 - temp2;
        }
        else if(op.equals("X"))
        {
            tempR = temp1 * temp2;
        }
        else if(op.equals("/"))
        {
            if(temp1 == 0 || temp2 == 0)
            {
                tempR = Double.POSITIVE_INFINITY;
            }
            tempR = temp1 / temp2;
        }
        return tempR;
    }
}
