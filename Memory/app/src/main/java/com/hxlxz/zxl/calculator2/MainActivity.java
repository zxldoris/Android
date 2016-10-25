package com.hxlxz.zxl.calculator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textViewBig;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
    }

    public void onClickNum(View view) {
        if (textView2.getText().toString().toCharArray()[0] != ' ') {
            if(textView3.getText().toString().toCharArray()[0] == 0){
                textViewBig.setText('0');
            }
            else {
                String ButtonNum2 = ((TextView) findViewById(view.getId())).getText().toString();
                String textViewNum = textView3.getText().toString();
                textView3.setText(textViewNum + ButtonNum2);
                textViewBig.setText(textViewNum + ButtonNum2);
            }
        } else {
                if(textView1.getText().toString().toCharArray()[0] == 0){
                textViewBig.setText('0');
            }
            String ButtonNum1 = ((TextView) findViewById(view.getId())).getText().toString();
            textView1.setText(textView1.getText().toString() + ButtonNum1);
        }
    }

    public void onClickOperator(View view) {
        textView2.setText(((Button) findViewById(view.getId())).getText().toString());
    }

    public void onClickClean(View view) {
        textView1.setText("");
        textView2.setText(" ");
        textView3.setText("");
        textView4.setText("");
    }

    public void onClickEnter(View view) {
        double num1 = Double.parseDouble(textView1.getText().toString());
        double num2 = Double.parseDouble(textView3.getText().toString());
        switch (textView2.getText().toString().toCharArray()[0]) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        textView4.setText("= " + new Double(result).toString());
    }

    public void onClickDel(View view) {
        if (textView2.getText().toString().toCharArray()[0] == ' ') {
            if (textView1.getText().toString().toCharArray().length != 0) {
                String stringView1 = textView1.getText().toString();
                textView1.setText(stringView1.toCharArray(), 0, stringView1.length() - 1);
            } else {
            }
        } else {
            if (textView3.getText().toString().length() == 0) {
                textView2.setText(" ");
            } else if (textView4.getText().toString().length() == 0) {
                if (textView3.getText().toString().length() != 0) {
                    String stringView3 = textView3.getText().toString();
                    textView3.setText(stringView3.toCharArray(), 0, stringView3.length() - 1);
                }
            } else {
                String stringView4 = textView4.getText().toString();
                textView4.setText(stringView4.toCharArray(), 0, stringView4.length() - 1);
            }
        }
    }
}