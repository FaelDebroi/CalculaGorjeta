package com.example.calculadora_gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextView Textoporcentagem, gorjetaTexto,valorTotal;
    private SeekBar seekBar;
    private EditText VRdigitado;
    private double procentagem = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Textoporcentagem = findViewById(R.id.Textoporcentagem);
        seekBar = findViewById(R.id.seekBar2);
        VRdigitado = findViewById(R.id.valorDigitado);
        gorjetaTexto = findViewById(R.id.textView5);
        valorTotal = findViewById(R.id.textView6);




        //seekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                procentagem = i;
                //Math.round ele arredonda para um numero sem virgula
                Textoporcentagem.setText(Math.round( procentagem ) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }



    public void calcular(){

        String valorRecuperado = VRdigitado.getText().toString();
//        Toast.makeText(this, "ESTOU AQUI !!!"+ VRdigitado, Toast.LENGTH_SHORT).show();

        if(valorRecuperado == null || valorRecuperado.equals("")){  // equals pergunta compara uma string
            Toast.makeText(this, "Voce nao digitou nada!!!", Toast.LENGTH_SHORT).show();
        }else{
            //convertendo de string para double
            Double ValorDigitado = Double.parseDouble(valorRecuperado);

            //calculo a gorjeta total
            double gorjeta = ValorDigitado * (procentagem/100);
            double Divida = ValorDigitado + gorjeta;
            //exibe a gorjeta e total
            gorjetaTexto.setText("R$ "+ Math.round(gorjeta));
            valorTotal.setText("R$ " +  Divida);


        }
    }

}