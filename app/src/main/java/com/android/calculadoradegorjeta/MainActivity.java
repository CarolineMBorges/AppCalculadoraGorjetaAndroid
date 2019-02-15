package com.android.calculadoradegorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekGorjeta;

    private double porcentagem = 0; //porcentagem inicial da gorjeta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValorId);
        textPorcentagem = findViewById(R.id.textPorcentagemId);
        textGorjeta = findViewById(R.id.textGorjetaId);
        textTotal = findViewById(R.id.textTotalId);
        seekGorjeta = findViewById(R.id.seekGorjetaId);

        //Controlar Seekbar
        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = seekBar.getProgress();

                //Math.round() retorna o valor de um número arredondado para o inteiro mais proximo.
                textPorcentagem.setText(Math.round(porcentagem) + "%");
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

        //recuperar valor
        Double valorDigitado = Double.parseDouble(editValor.getText().toString());

        Double gorjeta = valorDigitado * (porcentagem/100);
        Double total = gorjeta + valorDigitado;

        //exibir a gorjeta total
        //Math.round() retorna o valor de um número arredondado para o inteiro mais proximo
        textGorjeta.setText("R$ " + Math.round(gorjeta));
        textTotal.setText("R$ "+ total);
    }

}
