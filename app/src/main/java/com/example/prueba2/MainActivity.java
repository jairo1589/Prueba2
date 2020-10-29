package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txt, txt2;
    private ProgressBar progress;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText) findViewById(R.id.txt);
        txt2 = (EditText) findViewById(R.id.txt2);
        progress = (ProgressBar) findViewById(R.id.pb);

        progress.setVisibility(View.INVISIBLE);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new Task().execute();
            }

        });
    }

    public void Iniciar(View v) {
        String nombre = txt.getText().toString();
        String contraseña = txt2.getText().toString();

        if (nombre.equalsIgnoreCase("android") && contraseña.equalsIgnoreCase("123")) {
            Intent i = new Intent(this, Menu.class);
            startActivity(i);

        } else if (nombre.equalsIgnoreCase("ANDROID") && contraseña.equalsIgnoreCase("123")) {
            Intent i = new Intent(this, Menu.class);
            startActivity(i);

        } else {

            Toast.makeText(this, "Login incorrecto", Toast.LENGTH_SHORT).show();
        }

    }

    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
        }

        protected void onPostExecute(String s) {
            Intent i = new Intent(getBaseContext(), Menu.class);
            startActivity(i);
        }
    }
}