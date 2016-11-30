package com.example.raffa.pcmr;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Peca_Geral extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peca__geral);

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
        ;

        /*SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor c = db.query("processador",null,null,null,null,null,null);
        if(c.moveToFirst()){
            System.out.println("null");
        };
        String proc = c.getString(c.getColumnIndex("processador"));
        System.out.println(proc); */
        /*Cursor c = myDbHelper.lerBD("processador");
        c.moveToFirst();
        String proc = c.getString(4);
        Context context = getApplicationContext();
        CharSequence mensagem = proc;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,mensagem, duration);
        toast.show();*/


        Intent intent = getIntent();
        String message = intent.getStringExtra(Montando_PC.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setTextColor(Color.BLACK);
        textView.setText(message);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_peca__geral);
        layout.addView(textView);

        //Mexendo no Listview

        // TodoDatabaseHandler is a SQLiteOpenHelper class connecting to SQLite
        //TodoDatabaseHandler handler = new TodoDatabaseHandler(this);
        // Get access to the underlying writeable database
        //SQLiteDatabase db = handler.getWritableDatabase();
        // Query for items from the database and get a cursor back
        //Cursor todoCursor = db.rawQuery("SELECT  * FROM todo_items", null);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String nome = preferences.getString("NomeTabela", "");
        String objetivo = preferences.getString("Objetivo", "");
        Cursor c = myDbHelper.lerBD(nome, objetivo);

        TextView tvCol1 = (TextView) findViewById(R.id.tvColuna1);
        TextView tvCol2 = (TextView) findViewById(R.id.tvColuna2);
        TextView tvCol3 = (TextView) findViewById(R.id.tvColuna3);
        TextView tvCol4 = (TextView) findViewById(R.id.tvColuna4);
        TextView tvCol5 = (TextView) findViewById(R.id.tvColuna5);
        TextView tvCol6 = (TextView) findViewById(R.id.tvColuna6);
        TextView tvCol7 = (TextView) findViewById(R.id.tvColuna7);
        TextView tvCol8 = (TextView) findViewById(R.id.tvColuna8);
        TextView tvCol9 = (TextView) findViewById(R.id.tvColuna9);
        TextView tvCol10 = (TextView) findViewById(R.id.tvColuna10);
        TextView tvCol11 = (TextView) findViewById(R.id.tvColuna11);

        if(nome == "processador") {
            //hue
            tvCol1.setText("Nome");
            tvCol2.setText("Nucleos");
            tvCol3.setText("Thread");
            tvCol4.setText("Frequencia");
            tvCol5.setText("Socket");
            String s = preferences.getString("pecaplaca_mae","");
            if( s != ""){
                c = myDbHelper.limitaSocket(s,"placa_mae","processador");
            }
        }
        else if(nome == "placa_mae") {
            //hue
            tvCol1.setText("Nome");
            tvCol2.setText("Socket");
            tvCol3.setText("Pentes Ram");
            tvCol4.setText("Máx Ram");
            tvCol5.setText("Tipo Ram");
            tvCol6.setText("Latência Ram");
            tvCol7.setText("Formato HD");
            tvCol8.setText("Qtd. SATA");
            tvCol9.setText("Tamanho");
            tvCol10.setText("Interface HD");
            tvCol11.setText("Socket VGA");
            String v,r,p;
            v = preferences.getString("pecaplaca_video","");
            r = preferences.getString("pecaram","");
            p = preferences.getString("pecaprocessador","");
            if(r != "" && v != "" && p != ""){
                c = myDbHelper.limitaMBALL(p,v,r,"placa_mae");
            }else if(r != "" && v != ""){
                c = myDbHelper.limitaMBRV(r,v,"placa_mae");
            }else if(r != "" && p != ""){
                c = myDbHelper.limitaMBRP(r,p,"placa_mae");
            }else if(v != "" && p != ""){
                c = myDbHelper.limitaMBPV(p,v,"placa_mae");
            }else if(v != ""){
                c = myDbHelper.limitaVGA(v,"placa_video","placa_mae");
            }else if(p != ""){
                c = myDbHelper.limitaSocket(p,"processador","placa_mae");
            }else if(r != ""){
                c = myDbHelper.limitaRAM(r,"ram","placa_mae");
            }
        }
        else if(nome == "ram") {
            //hue
            tvCol1.setText("Nome");
            tvCol2.setText("Capacidade");
            tvCol3.setText("Pentes");
            tvCol4.setText("Tipo");
            tvCol5.setText("Frequência");
            String s = preferences.getString("pecaplaca_mae","");
            if( s != ""){
                c = myDbHelper.limitaRAM(s,"placa_mae","ram");
            }
        }
        else if(nome == "hd") {
            //hue
            tvCol1.setText("Nome");
            tvCol2.setText("Interface");
            tvCol3.setText("Capacidade");
            tvCol4.setText("RPM");
            tvCol5.setText("Cache");
            tvCol6.setText("Formato");
        }
        else if(nome == "ssd") {
            //hue
            tvCol1.setText("Nome");
            tvCol2.setText("Capacidade");
            tvCol3.setText("Formato");
            tvCol4.setText("Interface");
        }
        else if(nome == "gabinete") {
            //hue
            tvCol1.setText("Nome");
            tvCol2.setText("Tipo");
            tvCol3.setText("T. Placa Mãe");
            tvCol4.setText("T. Placa Vídeo");
        }
        else if(nome == "fonte") {
            //hue
            tvCol1.setText("Nome");
            tvCol2.setText("Potência");
            tvCol3.setText("Eficiência");
        }
        else if(nome == "placa_video") {
            //hue
            tvCol1.setText("Nome");
            tvCol2.setText("GPU");
            tvCol3.setText("Memória");
            tvCol4.setText("Vel. GPU");
            tvCol5.setText("Vel. Memória");
            tvCol6.setText("Socket");
            tvCol7.setText("Comprimento");
            tvCol8.setText("Tipo Memória");
            String s = preferences.getString("pecaplaca_mae","");
            if(s != ""){
                c = myDbHelper.limitaVGA(s,"placa_mae","placa_video");
            }
        }
        else if(nome == "cooler_processador") {
            //hue
            tvCol1.setText("Nome");
            tvCol2.setText("Socket");
            tvCol3.setText("Velocidade");
            tvCol4.setText("Voltagem");
        }
        c.moveToFirst();
        // Find ListView to populate
        ListView lvItems = (ListView) findViewById(R.id.listViewPeca_Geral);
        // Setup cursor adapter using cursor from last step
        PecaCursorAdapter pecaAdapter = new PecaCursorAdapter(this, c);
        // Attach cursor adapter to the ListView
        lvItems.setAdapter(pecaAdapter);
        // Switch to new cursor and update contents of ListView
        //procAdapter.changeCursor(newCursor);
        registerForContextMenu(lvItems);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_salvar, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int i = item.getItemId();
        if(i == R.id.salvar_peca){
            salvaPeca(info.position);
        }
        else if(i == R.id.resetar_peca){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            String nome = preferences.getString("NomeTabela", "");
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("peca"+nome,"");
            editor.apply();
            Context context = getApplicationContext();
            CharSequence mensagem = "Resetou a peça!";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context,mensagem, duration).show();
        }else{
            return false;
        }
        return true;
    }

    public void salvaPeca(int i){
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
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String nome = preferences.getString("NomeTabela", "");
        String objetivo = preferences.getString("Objetivo", "");

        Cursor c = myDbHelper.lerBD(nome, objetivo);
        c.moveToFirst();
        for (int j = 0; j < i; j++) {
            c.moveToNext();
        }
        String s = c.getString(0);
        CharSequence mensagem = "Peça Salva: "+ s;
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context,mensagem, duration).show();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("peca"+nome,s);
        editor.apply();
    }

}
