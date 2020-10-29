package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Creditos;

public class Prestamos extends AppCompatActivity {

    private Spinner spin1, spin2;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos);

        spin1= (Spinner)findViewById(R.id.spinclientes);
        spin2= (Spinner)findViewById(R.id.spincreditos);
        txt = (TextView)findViewById(R.id.mostrar);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaClientes);
        ArrayAdapter<String> adapt1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaCreditos);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapt1);

    }

    public void calc_prestamo(View v)
    {

        Creditos cl = new Creditos();
        String cliente = spin1.getSelectedItem().toString();
        String credito = spin2.getSelectedItem().toString();

        int credit_auto = cl.getCredito_automotriz();
        int credit_hipot = cl.getCredito_hipotecario();

        if(cliente.equals("Axel") && credito.equals("Credito Hipotecario"))
        {

            int saldo = credit_hipot + 750000;
            txt.setText("El valor Smart band: " + saldo);
        }
        if(cliente.equals("Axel") && credito.equals("Credito Automotriz"))
        {
            int saldo = credit_auto + 750000;
            txt.setText("El valor Smart band: " + saldo);
        }


        if(cliente.equals("Roxana") && credito.equals("Credito Hipotecario"))
        {
            int saldo = credit_hipot + 900000;
            txt.setText("El valor Smart band: " + saldo);
        }
        if(cliente.equals("Axel") && credito.equals("Credito Automotriz"))
        {
            int saldo = credit_auto + 900000;
            txt.setText("El valor Smart band: " + saldo);
        }

    }

    public void calc_deuda(View v)
    {

        Creditos cl = new Creditos();
        String cliente = spin1.getSelectedItem().toString();
        String credito = spin2.getSelectedItem().toString();

        int credit_auto = cl.getCredito_automotriz();
        int credit_hipot = cl.getCredito_hipotecario();
        int cuota_auto = cl.getCuotas_automotriz();
        int cutoa_hipot = cl.getCuotas_hiopotecario();

        if(cliente.equals("Axel") && credito.equals("Credito Hipotecario"))
        {

            int saldo = credit_hipot + 750000;
            int cuota = saldo / cutoa_hipot;
            txt.setText("El valor Smart band: " + cuota);
        }
        if(cliente.equals("Axel") && credito.equals("Credito Automotriz"))
        {
            int saldo = credit_hipot + 750000;
            int cuota = saldo / cuota_auto;
            txt.setText("El valor Smart band: " + cuota);
        }


        if(cliente.equals("Roxana") && credito.equals("Credito Hipotecario"))
        {
            int saldo = credit_auto + 900000;
            int cuota = saldo / cutoa_hipot;
            txt.setText("El valor Smart band: " + cuota);
        }
        if(cliente.equals("Axel") && credito.equals("Credito Automotriz"))
        {
            int saldo = credit_auto + 900000;
            int cuota = saldo / cuota_auto;
            txt.setText("El valor Smart band: " + cuota);
        }

    }


}