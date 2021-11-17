package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class consejo extends AppCompatActivity {
    private TextView nam,p,a,i,consejo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejo);

        nam=(TextView) findViewById(R.id.txtNombree);
        p=(TextView) findViewById(R.id.txtPeso);
        a=(TextView) findViewById(R.id.txtAltura);
        i=(TextView) findViewById(R.id.txtImc);
        consejo=(TextView) findViewById(R.id.txvCons);

        String name=getIntent().getStringExtra("nom");
        String pe=getIntent().getStringExtra("pes");
        String al=getIntent().getStringExtra("alt");

        nam.setText(name);
        p.setText(pe);
        a.setText(al);
        indice();

    }

    private void indice() {
        Double IMC,pe,al;
        pe=Double.parseDouble(p.getText().toString());
        al=Double.parseDouble(a.getText().toString());
        IMC=pe/(Math.pow(al,2));
        i.setText(""+IMC);

        if(IMC<16){
            consejo.setText("Peso bajo.\n\n Situacion: Muy grave.\n \nConsumir por lo menos 3 frutas por día y consumir ensalada en el almuerzo y en la cena ayuda a aumentar la cantidad de vitaminas y minerales de la dieta, los cuales son esenciales para el buen funcionamiento del metabolismo y para favorecer la ganancia de peso y de masa muscular. ");
        }else if(IMC<=16.99&&IMC>16){
            consejo.setText("Peso bajo.\n\n Situacion: Grave\n \nLos alimentos que son fuentes de grasas buenas como el cacahuate, almendras, nueces, aguacate, coco, aceite de oliva, aceite de linaza y semillas en general, son excelentes opciones para aumentar las calorías de la dieta con poco volumen de alimentos. Además de esto, estas grasas también ayudan a ganar masa muscular y no estimulan la acumulación de grasa en el cuerpo.");
        }else if(IMC>=17&&IMC<=18.49){
            consejo.setText("Peso bajo.\n\nIncluir proteínas en todas las comidas del día hace que los niveles de aminoácidos en la sangre se mantengan constantes a lo largo del día, favoreciendo una buena recuperación muscular post-entrenamiento.");
        }else if(IMC>18.49&&IMC<25){
            consejo.setText("Peso normal.\n\nCome 5 porciones de frutas y verduras por día. Las frutas y verduras son mucho más que simplemente vitaminas y minerales. También están llenas de fibra, lo cual significa que te llenarán. Y cuando te llenas con frutas y verduras, tienes menos probabilidades de comer demás.");
        }else if(IMC>=25&&IMC<35){
            consejo.setText("Obecidad.\nGrado I.\n\nHacer Ejercicio:\n El tipo de ejercicio no es lo más importante, pero sí aprovechar todas las oportunidades de quemar calorías siempre que sea posible, es de suma importancia que practique una actividad por lo menos 3 veces por semana.");
        }else if(IMC>=35&&IMC<40){
            consejo.setText("Obecidad.\nGrado II.\n\nBeber más agua durante el día\n" +
                    "Se deben beber muchos líquidos entre las comidas, ya que esto ayudará a disminuir el hambre y la retención de líquidos, porque mientras más agua se bebe más orina produce el cuerpo, y con su eliminación también se liberan toxinas que perjudican el proceso de pérdida de peso.");
        }else if(IMC>=40){
            consejo.setText("Obecidad.\nGrado III.\n\nComer de todo pero con moderación:\n" +
                    "El cuerpo necesita de todos los nutrientes, por lo que en las dietas en las que se prohíben los carbohidratos hacen con el peso aumente de nuevo poco tiempo después. Los mejores consejos son:\n"+
                    "* Preferir leche y sus derivados descremado;\n" +
                    "* Agregar 1 cucharada de semillas en los jugos y yogures como linaza y chía;\n" +
                    "* Comer un puñado de frutos secos, como maní o cacahuate, almendras, nueces, avellanas por día;\n" +
                    "* Escoger una sola fuente de carbohidrato por comida, dándole preferencia a los alimentos naturales;");
        }


    }

}