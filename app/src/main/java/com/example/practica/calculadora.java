package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class calculadora extends AppCompatActivity {

    TextView txt1;
    TextView txt2;
    String num1,num2;
    String op;
    Boolean operacion = false;
    Boolean decimal = false;
    int error = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculadora);
        txt2 = (TextView)findViewById(R.id.textView1);
        txt1 = (TextView)findViewById(R.id.textView2);
        num1 = "";
        num2 = "";
        txt1.setText("0");
        txt2.setText("La calculadora mas bonita desde 2021");
        op = "";
    }

    public void Escribir()
    {
        if(error == 2)
        {
            num1 = "";
            num2 = "";
            txt1.setText("0");
            op = "";
            operacion = false;
            decimal = false;
            error = 0;
        }
        txt1.setText(num1);
        if(num2 != "")
        {
            txt2.setText(num2);
            decimal = false;
        }
        else
            txt2.setText("la calculadora mas bonita desde 2021");
    }

    public void punto(View view) {
        if(!decimal)
        {
            num1 += ".";
            decimal = true;
        }
        Escribir();
    }
    public void BorrarTodo(View view) {
        num1 = "";
        num2 = "";
        txt1.setText("0");
        op = "";
        operacion = false;
        decimal = false;
    }
    public void Borrar(View view) {
        if(num1 != "")
        {
            if(num1.substring(num1.length() - 1, num1.length()).equals("."))
                decimal = false;
            num1 = num1.substring(0, num1.length() - 1);
            Escribir();
        }
    }
    public void porcentaje(View view) {
        if(operacion && op.equals("x"))
        {
            num1 = String.valueOf(Double.valueOf(num2.substring(0, num2.length() - 1))*(Double.valueOf(num1)*0.01));
            num2 = "";
            Escribir();
            operacion = false;
        }
    }
    public void opbasicas(Character ope)
    {
        if(num1.substring(num1.length() - 1, num1.length()).equals("."))
        {
            num1 = num1.substring(0, num1.length() - 1);
            decimal = false;
        }
        if(operacion)
        {
            num2 = num2.substring(0, num2.length() - 1);
            num2 += ope;
        }
        else
        {
            num2 = num1 + ope;
            num1 = "";
            operacion = true;
        }
        op = String.valueOf(ope);
        Escribir();
    }
    public void division(View view) {
        opbasicas('/');
    }
    public void multiplicar(View view) {
        opbasicas('x');
    }
    public void menos(View view) {
        opbasicas('-');
    }
    public void mas(View view) {
        opbasicas('+');
    }
    public void igual(View view) {
        if(operacion)
        {
            switch (op)
            {
                case "/":
                {
                    if(Double.valueOf(num1) == 0)
                    {
                        num1 = "NO / 0, Andina, No?";
                        error += 1;
                    }
                    else
                    {
                        num1 = String.valueOf(Double.valueOf(num2.substring(0, num2.length() - 1))/Double.valueOf(num1));
                    }
                }
                break;
                case "x":  num1 = String.valueOf(Double.valueOf(num2.substring(0, num2.length() - 1))*Double.valueOf(num1));;
                    break;
                case "-":  num1 = String.valueOf(Double.valueOf(num2.substring(0, num2.length() - 1))-Double.valueOf(num1));
                    break;
                case "+":  num1 = String.valueOf(Double.valueOf(num2.substring(0, num2.length() - 1))+Double.valueOf(num1));;
                    break;
                default:
                {
                    BorrarTodo(view);
                    txt1.setText("SYNTAX ERROR");
                }break;
            }
            num2 = "";
            Escribir();
            error += 1;
            decimal = true;
            operacion = false;
        }
    }
    public void cero(View view) {
        num1+='0';
        Escribir();
    }
    public void uno(View view) {
        num1+='1';
        Escribir();
    }
    public void dos(View view) {
        num1+='2';
        Escribir();
    }
    public void tres(View view) {
        num1+='3';
        Escribir();
    }
    public void cuatro(View view) {
        num1+='4';
        Escribir();
    }
    public void cinco(View view) {
        num1+='5';
        Escribir();
    }
    public void seis(View view) {
        num1+='6';
        Escribir();
    }
    public void siete(View view) {
        num1+='7';
        Escribir();
    }
    public void ocho(View view) {
        num1+='8';
        Escribir();
    }
    public void nueve(View view) {
        num1+='9';
        Escribir();
    }

}