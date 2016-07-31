package com.example.alexander.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    private TextView resultDisplay;
    private String currentValue;
    private String operator = "";
    private Double tempValue1, tempValue2, tempValue;
    private Boolean justCalculated;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultDisplay = (TextView)findViewById(R.id.resultDisplay);
        justCalculated = true;
        currentValue = "";
        updateResult();
    }

    /**Handles when someone presses Number**/
    public void onClickNumber(View view)
    {
        //If result was obtained, start a new equation
        if(justCalculated)
        {
            currentValue = "";
            justCalculated = false;
        }

        Button b = (Button) view;
        currentValue += b.getText().toString();
        updateResult();
    }

    /**Handles when someone presses Clear**/
    public void onClickClear(View view)
    {
        currentValue = "";
        operator = "";
        updateResult();
    }

    /**Handles when someone presses an Operator Button (+, -, X, /)**/
    public void onClickOperate(View view)
    {
        if(currentValue == "")
        {
            return;
        }

        //Logic for a continuing/multi-operational equation
        if(operator != "")
        {
            tempValue2 = Double.parseDouble(currentValue);
            tempValue1 = CalculatorUtils.calculate(tempValue1, tempValue2, operator);
            currentValue = "";
        }
        else
        {
            tempValue1 = Double.parseDouble(currentValue);
            currentValue = "";
        }

        Button b = (Button)view;
        operator = b.getText().toString();
        updateResult();
    }

    /**Handles when someone presses the Equals Button**/
    public void onClickEquals(View view)
    {
        if(currentValue == "" || operator == "")
        {
            return;
        }

        //If the user continues pressing equal apply the last operation again
        if(justCalculated)
        {
            tempValue1 = Double.parseDouble(currentValue);
        }
        else
        {
            tempValue2 = Double.parseDouble(currentValue);
        }

        tempValue = CalculatorUtils.calculate(tempValue1, tempValue2, operator);
        currentValue = String.valueOf(tempValue);
        justCalculated = true;
        updateResult();
    }

    /**Will update the Calculator Screen**/
    private void updateResult()
    {
        resultDisplay.setText(currentValue);
    }
}