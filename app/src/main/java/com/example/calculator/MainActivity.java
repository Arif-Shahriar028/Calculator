package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button addButton, subButton, clearButton, mulButton, divButton;
    private TextView result, memory;
    private EditText edittext1, edittext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.add);
        subButton = (Button) findViewById(R.id.sub);
        mulButton= (Button) findViewById(R.id.mul);
        divButton= (Button) findViewById(R.id.div);
        clearButton= (Button) findViewById(R.id.clear);
        result = (TextView) findViewById(R.id.sumShow);
        memory = (TextView) findViewById(R.id.memory);
        edittext1= (EditText) findViewById(R.id.edit1);
        edittext2= (EditText) findViewById(R.id.edit2);


        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try {

           /* LayoutInflater inf = getLayoutInflater();
            View customView = inf.inflate(R.layout.customtoast_layout, (ViewGroup) findViewById(R.id.customLayoutId));

            Toast toast2 = new Toast(MainActivity.this);
            toast2.setDuration(Toast.LENGTH_SHORT);
            toast2.setGravity(Gravity.BOTTOM,0,0);
            toast2.setView(customView);*/


            String number1 = edittext1.getText().toString();
            String number2 = edittext2.getText().toString();

            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            if (v.getId() == R.id.add) {
                double sum = num1 + num2;
                result.setText("Result : " + sum);
                memory.setText("Memory : "+ sum);
            }
            if (v.getId() == R.id.sub) {
                double sub = num1 - num2;
                result.setText("Result : " + sub);
                memory.setText("Memory : "+ sub);
            }
            if (v.getId() == R.id.mul) {
                double mul = num1 * num2;
                result.setText("Result : " + mul);
                memory.setText("Memory : "+ mul);
            }
            if (v.getId() == R.id.div) {
                double div = num1 / num2;
                result.setText("Result : " + div);
                memory.setText("Memory : "+ div);
            }
            if(v.getId()==R.id.clear)
            {
                result.setText("Result : ");
                edittext1.getText().clear();
                edittext2.getText().clear();
            }
        } catch (Exception e)
        {
            Toast toast = Toast.makeText(MainActivity.this,"Please enter number", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}