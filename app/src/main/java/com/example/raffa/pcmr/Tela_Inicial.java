package com.example.raffa.pcmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tela_Inicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__inicial);

    }

    protected void chamaNovoComputador(View view){
        Intent novoComputador = new Intent(this, Novo_Computador.class);
        startActivity(novoComputador);
    }

    protected void chamaListaComputadores(View view){
        Intent listaComputadores = new Intent(this, Lista_Computadores.class);
        startActivity(listaComputadores);
    }
}
