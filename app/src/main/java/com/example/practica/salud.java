package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.lang.Math;


public class salud extends AppCompatActivity {

    TextView msj;
    EditText nombre,peso,altura;
    Button btnCalcular,btnlimpiar;
    RadioButton rbMujer,rbVaron;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);

        nombre=(EditText) findViewById(R.id.txtNom);
        peso=(EditText) findViewById(R.id.txtPeso);
        altura=(EditText) findViewById(R.id.txtAltura);
        btnlimpiar=(Button) findViewById(R.id.btnLimpiar);
        btnCalcular=(Button) findViewById(R.id.btncalcular);
        rbVaron=(RadioButton) findViewById(R.id.rbVaron);
        rbMujer=(RadioButton) findViewById(R.id.rbMujer);
        msj=(TextView) findViewById(R.id.txtWenas);

        btnlimpiar.setOnClickListener((v)->{limpiar();});
        btnCalcular.setOnClickListener((v)->{calcular();});

    }

    private void limpiar() {
        altura.setText("");
        peso.setText("");
        nombre.setText("");
        msj.setText("hola");

    }



    private void calcular() {

        Double IMC,p,a;
        p=Double.parseDouble(peso.getText().toString());
        a=Double.parseDouble(altura.getText().toString());
        IMC=p/(Math.pow(a,2));

        if(IMC<16){
            msj.setText("Peso bajo, muy grave: IMC="+IMC);
        }else if(IMC<=16.99&&IMC>16){
            msj.setText("Peso bajo, grave: IMC="+IMC);
        }else if(IMC>=17&&IMC<=18.49){
            msj.setText("Peso bajo: IMC="+IMC);
        }else if(IMC>18.49&&IMC<25){
            msj.setText("Peso normal: IMC="+IMC);
        }else if(IMC>=25&&IMC<35){
            msj.setText("Obecidad grado I: IMC="+IMC);
        }else if(IMC>=35&&IMC<40){
            msj.setText("Obecidad grado II: IMC="+IMC);
        }else if(IMC>=40){
            msj.setText("Obecidad grado III: IMC="+IMC);
        }

    }

    public void consejo(View view) {
        Intent con=new Intent(this,consejo.class);
        con.putExtra("nom",nombre.getText().toString());
        con.putExtra("pes",peso.getText().toString());
        con.putExtra("alt",altura.getText().toString());
        startActivity(con);
    }
}
























