package com.example.raffa.pcmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Computador_Item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computador__item);
    }

    protected void chamaMontandoPc(View view){
        Intent montandoPc = new Intent(this, Montando_PC.class);
        startActivity(montandoPc);
    }
}
