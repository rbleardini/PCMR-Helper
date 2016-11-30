package com.example.raffa.pcmr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Montando_PC extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "";
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_montando__pc);
    }

    protected void chamaMeuPc(View view){
        Intent meuPc = new Intent(this, Meu_PC.class);
        startActivity(meuPc);
    }

    protected void chamaProcessador(View view){
        Intent processador = new Intent(this, Peca_Geral.class);
        String message = "Processador";
        processador.putExtra(EXTRA_MESSAGE, message);
        startActivity(processador);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","processador");
        editor.apply();
    }

    protected void chamaPlacaMae(View view){
        Intent placaMae = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "Placa Mae";
        placaMae.putExtra(EXTRA_MESSAGE, message);
        startActivity(placaMae);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","placa_mae");
        editor.apply();
    }

    protected void chamaHD(View view){
        Intent hd = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "HD";
        hd.putExtra(EXTRA_MESSAGE, message);
        startActivity(hd);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","hd");
        editor.apply();
    }

    protected void chamaSSD(View view){
        Intent ssd = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "SSD";
        ssd.putExtra(EXTRA_MESSAGE, message);
        startActivity(ssd);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","ssd");
        editor.apply();
    }

    protected void chamaRAM(View view){
        Intent ram = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "RAM";
        ram.putExtra(EXTRA_MESSAGE, message);
        startActivity(ram);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","ram");
        editor.apply();
    }

    protected void chamaGabinete(View view){
        Intent gabinete = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "Gabinete";
        gabinete.putExtra(EXTRA_MESSAGE, message);
        startActivity(gabinete);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","gabinete");
        editor.apply();
    }

    protected void chamaFonte(View view){
        Intent fonte = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "Fonte";
        fonte.putExtra(EXTRA_MESSAGE, message);
        startActivity(fonte);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","fonte");
        editor.apply();
    }

    protected void chamaPlacaVideo(View view){
        Intent placaVideo = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "Placa de Video";
        placaVideo.putExtra(EXTRA_MESSAGE, message);
        startActivity(placaVideo);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","placa_video");
        editor.apply();
    }

    protected void chamaCoolerProc(View view){
        Intent coolerProc = new Intent(this, Peca_Geral.class);
        //pecas diferentes, chamam a mesma activity com outras informçoes
        String message = "Cooler";
        coolerProc.putExtra(EXTRA_MESSAGE, message);
        startActivity(coolerProc);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NomeTabela","cooler_processador");
        editor.apply();
    }
    protected void resetAll(View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
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
        Context context = getApplicationContext();
        CharSequence mensagem = "Resetou!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context,mensagem, duration).show();
    }
}
