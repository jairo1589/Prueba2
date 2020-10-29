package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad extends AppCompatActivity {

    private EditText edit;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad);

        edit = (EditText)findViewById(R.id.edit);
        tv = (TextView) findViewById(R.id.tv);
    }
    // Metodo para generar una key// llave
    private SecretKeySpec generateKey(String password) throws Exception{
        MessageDigest sh = MessageDigest.getInstance("SHA-256");//LA  firma HMAC se utiliza para verificar la integridad
        byte[] key = password.getBytes("UTF-8");
        key = sh.digest(key); //aplico firma HMAC a mi cadena de bytes

        SecretKeySpec secretKey = new SecretKeySpec(key,"AES");
        return secretKey;
    }

    // Metodo que me permite cifrar bajo el algoritmo AES

    public String Encriptar(String datos, String password)throws Exception{
        if(!edit.getText(). toString(). isEmpty())
        {
            //Encriptar dato
            SecretKeySpec secretKey = generateKey(password);//obtengo kjey generere en mi funcion

            Cipher cipher = Cipher.getInstance("AES");//obtengo algoritmo AES para cifrar mi password
            cipher.init(cipher.ENCRYPT_MODE, secretKey);

            byte[] datosEncriptadosBt = cipher.doFinal(datos.getBytes());
            String datosEncriptadosSt = Base64.encodeToString(datosEncriptadosBt, Base64.DEFAULT);

            return datosEncriptadosSt;
        }
        else
        {
            Toast.makeText(this,"Debe ingresar una contraeña.", Toast.LENGTH_LONG).show();
            return null;
        }

    }

    public void Encriptar(View v)
    {
        try {
            String mensaje = Encriptar (edit.getText().toString(), tv.getText().toString());//obtengo mi metodo para encriptar
            tv.setText(mensaje);//pasamos el resultado al text view
        }
        catch(Exception e)
        {
            e.printStackTrace();// sino capturamos la excepcion o problema
        }
    }
}
