package com.example.raffa.pcmr;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;



/**
 * Created by raffa on 15/11/2016.
 */
public class PecaCursorAdapter extends CursorAdapter {
    public PecaCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_peca__geral, parent, false);

    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String nomePeca = preferences.getString("NomeTabela", "");
        if(nomePeca == "processador") {
            TextView tvNome = (TextView) view.findViewById(R.id.tvColuna1);
            TextView tvNucleos = (TextView) view.findViewById(R.id.tvColuna2);
            TextView tvThreads = (TextView) view.findViewById(R.id.tvColuna3);
            TextView tvFrequencia = (TextView) view.findViewById(R.id.tvColuna4);
            TextView tvSocket = (TextView) view.findViewById(R.id.tvColuna5);
            // Extract properties from cursor
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            int nucleos = cursor.getInt(cursor.getColumnIndexOrThrow("n_nucleos"));
            int threads = cursor.getInt(cursor.getColumnIndexOrThrow("n_threads"));
            float frequencia = cursor.getFloat(cursor.getColumnIndexOrThrow("frequencia"));
            String socket = cursor.getString(cursor.getColumnIndexOrThrow("socket"));
            // Populate fields with extracted properties
            tvNome.setText(nome);
            tvNucleos.setText(String.valueOf(nucleos));
            tvThreads.setText(String.valueOf(threads));
            tvFrequencia.setText(String.valueOf(frequencia));
            tvSocket.setText(socket);
        }
        else if(nomePeca == "placa_mae"){
            TextView tvColuna1 = (TextView) view.findViewById(R.id.tvColuna1);
            TextView tvColuna2 = (TextView) view.findViewById(R.id.tvColuna2);
            TextView tvColuna3 = (TextView) view.findViewById(R.id.tvColuna3);
            TextView tvColuna4 = (TextView) view.findViewById(R.id.tvColuna4);
            TextView tvColuna5 = (TextView) view.findViewById(R.id.tvColuna5);
            TextView tvColuna6 = (TextView) view.findViewById(R.id.tvColuna6);
            TextView tvColuna7 = (TextView) view.findViewById(R.id.tvColuna7);
            TextView tvColuna8 = (TextView) view.findViewById(R.id.tvColuna8);
            TextView tvColuna9 = (TextView) view.findViewById(R.id.tvColuna9);

            // Extract properties from cursor
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String socket = cursor.getString(cursor.getColumnIndexOrThrow("socket"));
            int qtdPentesRam = cursor.getInt(cursor.getColumnIndexOrThrow("qtd_pentes_ram"));
            String capacidadeMaxRam = cursor.getString(cursor.getColumnIndexOrThrow("capacidade_max_ram"));
            String tipoRam = cursor.getString(cursor.getColumnIndexOrThrow("tipo_ram"));
            int latRam = cursor.getInt(cursor.getColumnIndexOrThrow("latencia_ram"));
            String interfaceHD = cursor.getString(cursor.getColumnIndexOrThrow("interface_hd"));
            int qtdSata = cursor.getInt(cursor.getColumnIndexOrThrow("qtd_sata"));
            String tamanho = cursor.getString(cursor.getColumnIndexOrThrow("tamanho"));


            // Populate fields with extracted properties
            tvColuna1.setText(nome);
            tvColuna2.setText(socket);
            tvColuna3.setText(String.valueOf(qtdPentesRam));
            tvColuna4.setText(capacidadeMaxRam);
            tvColuna5.setText(tipoRam);
            tvColuna6.setText(String.valueOf(latRam));
            tvColuna7.setText(interfaceHD);
            tvColuna8.setText(String.valueOf(qtdSata));
            tvColuna9.setText(tamanho);

        }
        else if(nomePeca == "ram"){
            TextView tvColuna1 = (TextView) view.findViewById(R.id.tvColuna1);
            TextView tvColuna2 = (TextView) view.findViewById(R.id.tvColuna2);
            TextView tvColuna3 = (TextView) view.findViewById(R.id.tvColuna3);
            TextView tvColuna4 = (TextView) view.findViewById(R.id.tvColuna4);
            TextView tvColuna5 = (TextView) view.findViewById(R.id.tvColuna5);
            TextView tvColuna6 = (TextView) view.findViewById(R.id.tvColuna6);

            // Extract properties from cursor
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            int capacidade = cursor.getInt(cursor.getColumnIndexOrThrow("capacidade"));
            int qtdPentes = cursor.getInt(cursor.getColumnIndexOrThrow("qtd_pentes"));
            String tipo = cursor.getString(cursor.getColumnIndexOrThrow("tipo"));
            int frequencia = cursor.getInt(cursor.getColumnIndexOrThrow("frequencia"));


            // Populate fields with extracted properties
            tvColuna1.setText(nome);
            tvColuna2.setText(String.valueOf(capacidade));
            tvColuna3.setText(String.valueOf(qtdPentes));
            tvColuna4.setText(tipo);
            tvColuna5.setText(String.valueOf(frequencia));


        }
        else if(nomePeca == "hd"){
            TextView tvColuna1 = (TextView) view.findViewById(R.id.tvColuna1);
            TextView tvColuna2 = (TextView) view.findViewById(R.id.tvColuna2);
            TextView tvColuna3 = (TextView) view.findViewById(R.id.tvColuna3);
            TextView tvColuna4 = (TextView) view.findViewById(R.id.tvColuna4);
            TextView tvColuna5 = (TextView) view.findViewById(R.id.tvColuna5);
            TextView tvColuna6 = (TextView) view.findViewById(R.id.tvColuna6);

            // Extract properties from cursor
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String interfaceHD = cursor.getString(cursor.getColumnIndexOrThrow("interface"));
            int capacidade = cursor.getInt(cursor.getColumnIndexOrThrow("capacidade"));
            int rpm = cursor.getInt(cursor.getColumnIndexOrThrow("rpm"));
            int cache = cursor.getInt(cursor.getColumnIndexOrThrow("cache"));
            float formato = cursor.getFloat(cursor.getColumnIndexOrThrow("formato"));


            // Populate fields with extracted properties
            tvColuna1.setText(nome);
            tvColuna2.setText(interfaceHD);
            tvColuna3.setText(String.valueOf(capacidade));
            tvColuna4.setText(String.valueOf(rpm));
            tvColuna5.setText(String.valueOf(cache));
            tvColuna6.setText(String.valueOf(formato));


        }
        else if(nomePeca == "ssd"){
            TextView tvColuna1 = (TextView) view.findViewById(R.id.tvColuna1);
            TextView tvColuna2 = (TextView) view.findViewById(R.id.tvColuna2);
            TextView tvColuna3 = (TextView) view.findViewById(R.id.tvColuna3);
            TextView tvColuna4 = (TextView) view.findViewById(R.id.tvColuna4);

            // Extract properties from cursor
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            int capacidade = cursor.getInt(cursor.getColumnIndexOrThrow("capacidade"));
            float formato = cursor.getFloat(cursor.getColumnIndexOrThrow("formato"));
            String interfaceSSD = cursor.getString(cursor.getColumnIndexOrThrow("interface"));


            // Populate fields with extracted properties
            tvColuna1.setText(nome);
            tvColuna2.setText(String.valueOf(capacidade));
            tvColuna3.setText(String.valueOf(formato));
            tvColuna4.setText(interfaceSSD);

        }
        else if(nomePeca == "gabinete"){
            TextView tvColuna1 = (TextView) view.findViewById(R.id.tvColuna1);
            TextView tvColuna2 = (TextView) view.findViewById(R.id.tvColuna2);
            TextView tvColuna3 = (TextView) view.findViewById(R.id.tvColuna3);
            TextView tvColuna4 = (TextView) view.findViewById(R.id.tvColuna4);

            // Extract properties from cursor
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String tipo = cursor.getString(cursor.getColumnIndexOrThrow("tipo"));
            String tamPlacaMae = cursor.getString(cursor.getColumnIndexOrThrow("tamanho_placa_mae"));
            String tamPlacaVideo = cursor.getString(cursor.getColumnIndexOrThrow("tamano_placa_video")); //tamano = tamanho - señor trump, cabron


            // Populate fields with extracted properties
            tvColuna1.setText(nome);
            tvColuna2.setText(tipo);
            tvColuna3.setText(tamPlacaMae);
            tvColuna4.setText(tamPlacaVideo);

        }
        else if(nomePeca == "fonte"){
            TextView tvColuna1 = (TextView) view.findViewById(R.id.tvColuna1);
            TextView tvColuna2 = (TextView) view.findViewById(R.id.tvColuna2);
            TextView tvColuna3 = (TextView) view.findViewById(R.id.tvColuna3);

            // Extract properties from cursor
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            int potencia = cursor.getInt(cursor.getColumnIndexOrThrow("potencia"));
            int eficiencia = cursor.getInt(cursor.getColumnIndexOrThrow("eficiencia"));



            // Populate fields with extracted properties
            tvColuna1.setText(nome);
            tvColuna2.setText(String.valueOf(potencia));
            tvColuna3.setText(String.valueOf(eficiencia));

        }
        else if(nomePeca == "placa_video"){
            TextView tvColuna1 = (TextView) view.findViewById(R.id.tvColuna1);
            TextView tvColuna2 = (TextView) view.findViewById(R.id.tvColuna2);
            TextView tvColuna3 = (TextView) view.findViewById(R.id.tvColuna3);
            TextView tvColuna4 = (TextView) view.findViewById(R.id.tvColuna4);
            TextView tvColuna5 = (TextView) view.findViewById(R.id.tvColuna5);
            TextView tvColuna6 = (TextView) view.findViewById(R.id.tvColuna6);
            TextView tvColuna7 = (TextView) view.findViewById(R.id.tvColuna7);
            TextView tvColuna8 = (TextView) view.findViewById(R.id.tvColuna8);

            // Extract properties from cursor
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String gpu = cursor.getString(cursor.getColumnIndexOrThrow("gpu"));
            int memoria = cursor.getInt(cursor.getColumnIndexOrThrow("memoria"));
            int velocidadeGpu = cursor.getInt(cursor.getColumnIndexOrThrow("velocidade_gpu"));
            int velocidadeMemoria = cursor.getInt(cursor.getColumnIndexOrThrow("velocidade_memoria"));
            String interfaceGPU = cursor.getString(cursor.getColumnIndexOrThrow("interface"));
            float comprimento = cursor.getFloat(cursor.getColumnIndexOrThrow("comprimento"));
            String tipoMemoria = cursor.getString(cursor.getColumnIndexOrThrow("tipo_memoria"));



            // Populate fields with extracted properties
            tvColuna1.setText(nome);
            tvColuna2.setText(gpu);
            tvColuna3.setText(String.valueOf(memoria));
            tvColuna4.setText(String.valueOf(velocidadeGpu));
            tvColuna5.setText(String.valueOf(velocidadeMemoria));
            tvColuna6.setText(interfaceGPU);
            tvColuna7.setText(String.valueOf(comprimento));
            tvColuna8.setText(tipoMemoria);




        }
        else if(nomePeca == "cooler_processador"){
            TextView tvColuna1 = (TextView) view.findViewById(R.id.tvColuna1);
            TextView tvColuna2 = (TextView) view.findViewById(R.id.tvColuna2);
            TextView tvColuna3 = (TextView) view.findViewById(R.id.tvColuna3);
            TextView tvColuna4 = (TextView) view.findViewById(R.id.tvColuna4);

            // Extract properties from cursor
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String socket = cursor.getString(cursor.getColumnIndexOrThrow("socket"));
            int velocidade = cursor.getInt(cursor.getColumnIndexOrThrow("velocidade"));
            int consumo = cursor.getInt(cursor.getColumnIndexOrThrow("consumo"));


            // Populate fields with extracted properties
            tvColuna1.setText(nome);
            tvColuna2.setText(socket);
            tvColuna3.setText(String.valueOf(velocidade));
            tvColuna4.setText(String.valueOf(consumo));

        }

    }


}