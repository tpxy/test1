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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultDisplay = (TextView)findViewById(R.id.resultDisplay);
        currentValue = "";
        updateResult();
    }

    /**Handles when someone presses Number**/
    public void onClickNumber(View view)
    {
        Button b = (Button) view;
        currentValue += b.getText().toString();
        updateResult();
    }

    /**Handles when someone presses Clear**/
    public void onClickClear(View view)
    {

        updateResult();
    }

    /**Handles when someone presses an Operator Button (+, -, X, /)**/
    public void onClickOperate(View view)
    {

        updateResult();
    }

    /**Handles when someone presses the Equals Button**/
    public void onClickEquals(View view)
    {

        updateResult();
    }

    /**Will update the Calculator Screen**/
    private void updateResult()
    {
        resultDisplay.setText(currentValue);
    }
}