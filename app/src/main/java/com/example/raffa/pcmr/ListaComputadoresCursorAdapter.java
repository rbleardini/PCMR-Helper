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
 * Created by raffa on 22/11/2016.
 */
public class ListaComputadoresCursorAdapter extends CursorAdapter {
    public ListaComputadoresCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_lista__computadores, parent, false);

    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tvColuna1 = (TextView) view.findViewById(R.id.tvColuna1);
        TextView tvColuna2 = (TextView) view.findViewById(R.id.tvColuna2);
        TextView tvColuna3 = (TextView) view.findViewById(R.id.tvColuna3);
        TextView tvColuna4 = (TextView) view.findViewById(R.id.tvColuna4);
        TextView tvColuna5 = (TextView) view.findViewById(R.id.tvColuna5);
        TextView tvColuna6 = (TextView) view.findViewById(R.id.tvColuna6);
        TextView tvColuna7 = (TextView) view.findViewById(R.id.tvColuna7);
        TextView tvColuna8 = (TextView) view.findViewById(R.id.tvColuna8);
        TextView tvColuna9 = (TextView) view.findViewById(R.id.tvColuna9);
        TextView tvColuna10 = (TextView) view.findViewById(R.id.tvColuna10);
        // Extract properties from cursor
        String nome = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String processador = cursor.getString(cursor.getColumnIndexOrThrow("processador"));
        String placa_mae = cursor.getString(cursor.getColumnIndexOrThrow("placa_mae"));
        String hd = cursor.getString(cursor.getColumnIndexOrThrow("hd"));
        String ram = cursor.getString(cursor.getColumnIndexOrThrow("ram"));
        String ssd = cursor.getString(cursor.getColumnIndexOrThrow("ssd"));
        String placa_video = cursor.getString(cursor.getColumnIndexOrThrow("placa_video"));
        String fonte = cursor.getString(cursor.getColumnIndexOrThrow("fonte"));
        String gabinete = cursor.getString(cursor.getColumnIndexOrThrow("gabinete"));
        String cooler_proc = cursor.getString(cursor.getColumnIndexOrThrow("cooler_processador"));

        // Populate fields with extracted properties
        tvColuna1.setText(nome);
        tvColuna2.setText(processador);
        tvColuna3.setText(placa_mae);
        tvColuna4.setText(hd);
        tvColuna5.setText(ram);
        tvColuna6.setText(ssd);
        tvColuna7.setText(placa_video);
        tvColuna8.setText(fonte);
        tvColuna9.setText(gabinete);
        tvColuna10.setText(cooler_proc);


    }
}
