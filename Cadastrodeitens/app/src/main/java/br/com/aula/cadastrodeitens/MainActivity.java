package br.com.aula.cadastrodeitens;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner spinner1, spinner2;
    Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spNome);
        spinner2 = findViewById(R.id.spCidade);
        cadastrar = findViewById(R.id.cadastrar);

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        cadastrar.setOnClickListener(this);

        carregarListaNomes();
        carregarListaCidades();

    }
    private void carregarListaNomes() {
        ArrayAdapter<CharSequence> lista1 = ArrayAdapter.createFromResource(MainActivity.this,R.array.nomes ,android.R.layout.simple_spinner_item);
        lista1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(lista1);
    }

    private void carregarListaCidades() {
        ArrayList listaCidades = new ArrayList<String>();

        listaCidades.add("São Paulo");
        listaCidades.add("Paraná");
        listaCidades.add("Salvador");
        listaCidades.add("Campina Grande");
        listaCidades.add("Pedra de Fogo");
        listaCidades.add("João Pessoa");
        listaCidades.add("Brasília");
        listaCidades.add("Rio de janiero");

        ArrayAdapter<String> lista2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, listaCidades);
        lista2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(lista2);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cadastrar) {
            AlertDialog.Builder dl = new AlertDialog.Builder( this);
            dl.setTitle(R.string.app_name);
            dl.setMessage("Cadastrado com sucesso!");
            dl.setPositiveButton("OK", null);
            dl.show();


        }
    }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(MainActivity.this, "Você selecionou " + item + " na posição " + position, Toast.LENGTH_SHORT).show();
        }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
