package com.example.raffa.pcmr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Meu_PC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu__pc);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String processador = preferences.getString("pecaprocessador","");
        String placa_mae = preferences.getString("pecaplaca_mae","");
        String hd = preferences.getString("pecahd","");
        String ssd = preferences.getString("pecassd","");
        String ram = preferences.getString("pecaram","");
        String gabinete = preferences.getString("pecagabinete","");
        String fonte = preferences.getString("pecafonte","");
        String placa_video = preferences.getString("pecaplaca_video","");
        String cooler_processador = preferences.getString("pecacooler_processador","");
        TextView textView = (TextView)findViewById(R.id.processadorTV);
        textView.setText(processador);
        TextView textView2 = (TextView)findViewById(R.id.placa_maeTV);
        textView2.setText(placa_mae);
        TextView textView3 = (TextView)findViewById(R.id.hdTV);
        textView3.setText(hd);
        TextView textView4 = (TextView)findViewById(R.id.ssdTV);
        textView4.setText(ssd);
        TextView textView5 = (TextView)findViewById(R.id.ramTV);
        textView5.setText(ram);
        TextView textView6 = (TextView)findViewById(R.id.gabineteTV);
        textView6.setText(gabinete);
        TextView textView7 = (TextView)findViewById(R.id.fonteTV);
        textView7.setText(fonte);
        TextView textView8 = (TextView)findViewById(R.id.placa_videoTV);
        textView8.setText(placa_video);
        TextView textView9 = (TextView)findViewById(R.id.cooler_procTV);
        textView9.setText(cooler_processador);

    }

    protected void chamaVerificar(View view){
        EditText nomePcET = (EditText)findViewById(R.id.editTextNomePC);
        String nomePcS = nomePcET.getText().toString();
        int verif = verifyPecas();
        if(verif == 1) {
            Intent faltamPecas = new Intent(this, Faltam_Pecas.class);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nomePC",nomePcS);
            editor.apply();
            startActivity(faltamPecas);
        }else if(verif == 0){
            //Mensagem 'Salvo com Sucesso!'
            Context context = getApplicationContext();
            DataBaseHelper myDbHelper = new DataBaseHelper(this);

            try {
                myDbHelper.createDataBase();
            } catch (IOException ioe) {
                throw new Error("Unable to create database");
            }
            try {
                myDbHelper.openDataBase();
            } catch (SQLException sqle) {
                throw sqle;
            }

            Intent listaComputadores = new Intent(this, Lista_Computadores.class);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            String processador = preferences.getString("pecaprocessador","");
            String placa_mae = preferences.getString("pecaplaca_mae","");
            String hd = preferences.getString("pecahd","");
            String ssd = preferences.getString("pecassd","");
            String ram = preferences.getString("pecaram","");
            String gabinete = preferences.getString("pecagabinete","");
            String fonte = preferences.getString("pecafonte","");
            String placa_video = preferences.getString("pecaplaca_video","");
            String cooler_processador = preferences.getString("pecacooler_processador","");

            //CHUTA PRA ESCANTEIO RONALDO
            boolean dibrou = true;
            try{
                myDbHelper.inserePc(nomePcS,processador,placa_mae,hd,ssd,ram,gabinete,fonte,placa_video,cooler_processador);
            }catch(Exception e){
                CharSequence mensagem = "Nome de computador já existente, altere o nome por favor!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,mensagem, duration);
                toast.show();
                Intent intent = new Intent(this,Meu_PC.class);
                startActivity(intent);
                dibrou = false;
            }
            // É TAFAREL
            if(dibrou){
                CharSequence mensagem = "Salvo com sucesso!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,mensagem, duration);
                toast.show();
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
                editor.putString("nomePC","");
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), Tela_Inicial.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                startActivity(listaComputadores);
                finish();
            }
        }else{
            Context context = getApplicationContext();
            CharSequence mensagem = "Você precisa adicionar pelo menos uma peça antes de salvar!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context,mensagem, duration);
            toast.show();
        }
    }

    protected void voltaMontandoPc(View view){
        Intent montandoPc = new Intent(this, Montando_PC.class);
        startActivity(montandoPc);
    }

    protected int verifyPecas(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean temUm = false;
        boolean naoTemUm = false;
        if(preferences.getString("pecaprocessador","")==""){
            naoTemUm = true;
        }else{
            temUm = true;
        }
        if(preferences.getString("pecaplaca_mae","")==""){
            naoTemUm = true;
        }else{
            temUm = true;
        }
        if(preferences.getString("pecahd","")==""){
            naoTemUm = true;
        }else{
            temUm = true;
        }
        if(preferences.getString("pecassd","")==""){
            naoTemUm = true;
        }else{
            temUm = true;
        }
        if(preferences.getString("pecaram","")==""){
            naoTemUm = true;
        }else{
            temUm = true;
        }
        if(preferences.getString("pecagabinete","")==""){
            naoTemUm = true;
        }else{
            temUm = true;
        }
        if(preferences.getString("pecafonte","")==""){
            naoTemUm = true;
        }else{
            temUm = true;
        }
        if(preferences.getString("pecaplaca_video","")==""){
            naoTemUm = true;
        }else{
            temUm = true;
        }
        if(preferences.getString("pecacooler_processador","")==""){
            naoTemUm = true;
        }else{
            temUm = true;
        }
        if(temUm && naoTemUm){
            return 1;
        }else if(!temUm && naoTemUm){
            return -1;
        }
        return 0;
    }
}
