package com.digioz.tipcalculator;

import java.math.BigDecimal;
import java.text.NumberFormat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class DigiOzTipCalculatorActivity extends Activity {
	    EditText txtAmount;
    	EditText txtPercent;
    	EditText txtTip;
    	Button buttonCalculate;
    	
	public static double round(double unrounded, int precision, int roundingMode)
	{
	    BigDecimal bd = new BigDecimal(unrounded);
	    BigDecimal rounded = bd.setScale(precision, roundingMode);
	    return rounded.doubleValue();
	}
    	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    	
    	txtAmount = (EditText) findViewById(R.id.txtAmount);
    	txtPercent = (EditText) findViewById(R.id.txtPercent);
    	txtTip = (EditText) findViewById(R.id.txtTip);
    	buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
    	
    	buttonCalculate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {		
				try {
					Double amount = Double.parseDouble(txtAmount.getText().toString());
					Double percent = Double.parseDouble(txtPercent.getText().toString());
					Double tip;
					Double tipRounded;
									
					tip = (amount * percent) / 100;
					tipRounded = round(tip,2,BigDecimal.ROUND_HALF_UP);
					
					NumberFormat nf = NumberFormat.getInstance();
					nf.setMinimumFractionDigits(2);
					nf.setMaximumFractionDigits(2);
					String tipOutput = nf.format(tipRounded);
					
					Log.d("DigiOzTipCalculatorActivity", "Calculated Tip: "+tipOutput.toString());
					
					txtTip.setText(tipOutput.toString());
					
					// Hide keyboard
					InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(txtTip.getWindowToken(), 0);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					Log.d("DigiOzTipCalculatorActivity", "Failed to calculate Tip with error: "+e.toString());
				}
			}
		});
    }
}