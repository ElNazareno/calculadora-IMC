package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void calculadora(View view) {
        Intent calculadora=new Intent(this,calculadora.class);
        startActivity(calculadora);
    }

    public void salud(View view) {

        Intent salud=new Intent(this,salud.class);
        startActivity(salud);
    }

    public void salir(View view) {
        finish();
    }
}