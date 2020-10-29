package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i< images.length; i++)
        {
            flip_image(images[i]);
        }
    }
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2200);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);


    }
    public void info(View v)
    {
        Intent i = new Intent (this, Info.class);
        startActivity(i);
    }
    public void Seguridad(View v)
    {
        Intent i = new Intent (this, Seguridad.class);
        startActivity(i);
    }
    public void Clientes(View v)
    {
        Intent i = new Intent (this, Clientes.class);
        startActivity(i);
    }

    public void Prestamos(View v)
    {
        ArrayList<String> listaClientes = new ArrayList<String>();
        ArrayList<String> listaCreditos = new ArrayList<String>();

        listaClientes.add("Axel");
        listaClientes.add("Roxana");

        listaCreditos.add("Credito Hipotecario");
        listaCreditos.add("Credito Automotriz");

        Intent i = new Intent (this, Prestamos.class);
        i.putExtra("listaClientes", listaClientes);
        i.putExtra("listaCreditos", listaCreditos);

        startActivity(i);
    }



}