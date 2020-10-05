package com.example.androidtaller3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private List<Auto> mlista= new ArrayList<>();
    ListAdapter mAdapter;

    private EditText textMarca,textModelo,textPlaca;
    //  private TextView text_resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMarca= (EditText)findViewById(R.id.textMarca);
        textModelo= (EditText)findViewById(R.id.textModelo);
        textPlaca= (EditText)findViewById(R.id.textPlaca);
    }
    public boolean ValidarVacio(String n1,String n2,String n3){

        boolean vacio=false;
        if(n1.isEmpty()){
            textMarca.setError("Este campo no puede quedar vacio");
            vacio=true;
        }
        if(n2.isEmpty()){
            textModelo.setError("Este campo no puede quedar vacio");
            vacio=true;
        }
        if(n3.isEmpty()){
            textPlaca.setError("Este campo no puede quedar vacio");
            vacio=true;
        }

        return vacio;
    }
    private String marca,modelo,placa;
    public void Agregar(View vie){
        marca=textMarca.getText().toString();
        modelo=textModelo.getText().toString();
        placa=textPlaca.getText().toString();
        if(!ValidarVacio(marca,modelo,placa)){
            mListView = findViewById(R.id.listView);
            mlista.add(new Auto(marca,modelo,placa));
            mAdapter= new ListAdapter(MainActivity.this,R.layout.item_row,mlista);
            mListView.setAdapter(mAdapter);
        }

    }


}
