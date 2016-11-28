package com.example.raffa.pcmr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Lista_Computadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__computadores);

        DataBaseHelper myDbHelper = new DataBaseHelper(this);

        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        }catch(SQLException sqle){
            throw sqle;
        };

        String message = "Meus Computadores";
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setTextColor(Color.rgb(0,0,0));
        textView.setText(message);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_lista__computadores);
        layout.addView(textView);

        /*String message2 = "Voltar para tela inicial";
        Button button = new Button(this);
        button.setX(150);
        button.setY(1300);
        button.setTextSize(20);
        button.setText(message2);
        layout.addView(button);
        boolean trigger = button.callOnClick();
        if(trigger){
            Intent telaInicial = new Intent(this, Tela_Inicial.class);
            startActivity(telaInicial);
        }*/
        //Mexendo no Listview

        Cursor c = myDbHelper.lerTabelaListaPC();
        c.moveToFirst();
        // Find ListView to populate
        ListView lvItems = (ListView) findViewById(R.id.listViewListaComputadores);
        // Setup cursor adapter using cursor from last step
        ListaComputadoresCursorAdapter listaComputadoresAdapter = new ListaComputadoresCursorAdapter(this, c);
        // Attach cursor adapter to the ListView
        lvItems.setAdapter(listaComputadoresAdapter);
        // Switch to new cursor and update contents of ListView
        //procAdapter.changeCursor(newCursor);
        registerForContextMenu(lvItems);

    }

    protected void chamaTelaInicial(View view){
        Intent telaInicial = new Intent(this, Tela_Inicial.class);
        startActivity(telaInicial);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_listapc, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId() == R.id.deletar_pc){
            deletarPC(info.position);
        }
        else if(item.getItemId() == R.id.alterar_pc){
            alterarPC(info.position);
        }
        else {
            return false;
        }
        return true;
    }

    public void deletarPC(int i){
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


        Cursor c = myDbHelper.lerTabelaListaPC();
        c.moveToFirst();
        for (int j = 0; j < i; j++) {
            c.moveToNext();
        }

        String s = c.getString(0);
        myDbHelper.deletarPc(s);
        CharSequence mensagem = "PC deletado: "+ s;
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context,mensagem, duration).show();
        Intent reload = new Intent(this,Lista_Computadores.class);
        startActivity(reload);
        finish();
    }

    public void alterarPC(int i){
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


        Cursor c = myDbHelper.lerTabelaListaPC();
        c.moveToFirst();
        for (int j = 0; j < i; j++) {
            c.moveToNext();
        }

        String nome = c.getString(0);
        String processador = c.getString(1);
        String placa_mae = c.getString(2);
        String hd = c.getString(3);
        String ssd = c.getString(4);
        String ram = c.getString(5);
        String gabinete = c.getString(6);
        String fonte = c.getString(7);
        String placa_video = c.getString(8);
        String cooler_processador = c.getString(9);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("pecaprocessador",processador);
        editor.putString("pecaplaca_mae",placa_mae);
        editor.putString("pecahd",hd);
        editor.putString("pecassd",ssd);
        editor.putString("pecaram",ram);
        editor.putString("pecagabinete",gabinete);
        editor.putString("pecafonte",fonte);
        editor.putString("pecaplaca_video",placa_video);
        editor.putString("pecacooler_processador",cooler_processador);

        editor.apply();
        myDbHelper.deletarPc(nome);
        Intent montandoPC = new Intent(this, Montando_PC.class);
        startActivity(montandoPC);
    }
}
