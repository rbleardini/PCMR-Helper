package com.example.raffa.pcmr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Novo_Computador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo__computador);
    }

    protected void chamaMontandoTrab(View view){
        Intent montandoTrab = new Intent(this, Montando_PC.class);

        startActivity(montandoTrab);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Objetivo", "trabalho");
        editor.putString("pecaprocessador","");
        editor.putString("pecaplaca_mae","");
        editor.putString("pecahd","");
        editor.putString("pecassd","");
        editor.putString("pecaram","");
        editor.putString("pecagabinete","");
        editor.putString("pecafonte","");
        editor.putString("pecaplaca_video","");
        editor.putString("pecacooler_processador","");
        editor.apply();
        editor.apply();
    }
    protected void chamaMontandoJogos(View view){
        Intent montandoJogos = new Intent(this, Montando_PC.class);

        startActivity(montandoJogos);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Objetivo", "jogos");
        editor.putString("pecaprocessador","");
        editor.putString("pecaplaca_mae","");
        editor.putString("pecahd","");
        editor.putString("pecassd","");
        editor.putString("pecaram","");
        editor.putString("pecagabinete","");
        editor.putString("pecafonte","");
        editor.putString("pecaplaca_video","");
        editor.putString("pecacooler_processador","");
        editor.apply();
    }
    protected void chamaMontandoGeral(View view){
        Intent montandoGeral = new Intent(this, Montando_PC.class);

        startActivity(montandoGeral);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Objetivo", "geral");
        editor.putString("pecaprocessador","");
        editor.putString("pecaplaca_mae","");
        editor.putString("pecahd","");
        editor.putString("pecassd","");
        editor.putString("pecaram","");
        editor.putString("pecagabinete","");
        editor.putString("pecafonte","");
        editor.putString("pecaplaca_video","");
        editor.putString("pecacooler_processador","");
        editor.apply();
    }
}
