package com.example.jey.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    private int total = 0;
    private int holder1 = 0;
    private int holder2 = 0;
    TextView myTextView;
    boolean zedong = false;
    boolean flag2 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myTextView = (TextView) findViewById(R.id.textView);
    }
    public void onButtonClick(View v) {
        Button button = (Button) v;
        String bText = button.getText().toString();
        if(holder1 == 0 || zedong == true) {
            holder1 = Integer.parseInt(bText);
            if (holder1 == 0) {
                zedong = true;
            }
        }
        else{
            holder2 = Integer.parseInt(bText);
            flag2 = true;
        }
       // total += value;

        myTextView.setText(Integer.toString(total));
    }

    public void operateCalcClick(View v) {
        Button button = (Button) v;
        String bText = button.getText().toString();
        try {
            if (holder1 != 0 && holder2 == 0 && flag2 != true) {
                holder2 = holder1;
                holder1 = total;
            }
            else if(holder1 == 0 && holder2 == 0)
            {

            }

            if (bText.equals("+")) {
                total = holder1 + holder2;
            } else if (bText.equals("-")) {
                total = holder1 - holder2;
            } else if (bText.equals("*")) {
                total = holder1 * holder2;
            } else if (bText.equals("/")) {
                total = holder1 / holder2;
            }
            myTextView.setText(Integer.toString(total));

            holder1 = 0;
            holder2 = 0;
            zedong = false;
            flag2 = false;
        }
        catch(ArithmeticException e){
            myTextView.setText("you just the whole thing");
        }
    }

    public void operateClear(View v){
        total = 0;
        myTextView.setText(Integer.toString(total));

        holder1 = 0;
        holder2 = 0;
        zedong = false;
        flag2 = false;
    }

    }



