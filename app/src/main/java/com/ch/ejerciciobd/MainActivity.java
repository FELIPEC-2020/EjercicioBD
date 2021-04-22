package com.ch.ejerciciobd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtId;
    private EditText txtNombre;
    private EditText txtLatitud;
    private EditText txtLongitud;
    private EditText txtPoblacion;
    private ListView lvRespuesta;
    private Button btnGuardar;
    private ArrayAdapter<String> adapter;
    private ArrayList<Ciudad> listaciudades;
    DBCiudades db = new DBCiudades(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombre);
        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);
        txtPoblacion = findViewById(R.id.txtPoblacion);
        lvRespuesta = findViewById(R.id.lvRespuesta);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnGuardar)
        guardarCiudad();
        listaciudades = db.seleccionarCiudad(db.getWritableDatabase());
        orden();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaciudades);
        lvRespuesta.setAdapter(adapter);
    }

    private void limpiar() {
        txtId.getText().clear();
        txtNombre.getText().clear();
        txtLatitud.getText().clear();
        txtLongitud.getText().clear();
        txtPoblacion.getText().clear();
    }

    private void orden() {
        //Metodo para Ordenar de Menor a Mayor la Lista de Ciudades
        Collections.sort(listaciudades, new Comparator<Ciudad>() {
            @Override
            public int compare(Ciudad o1, Ciudad o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });
    }

    private void guardarCiudad() {
        int cId = Integer.parseInt(txtId.getText().toString());
        String cNombre = txtNombre.getText().toString();
        double cLatitud = Double.parseDouble(txtLatitud.getText().toString());
        double cLongitud = Double.parseDouble(txtLongitud.getText().toString());
        int cPoblacion = Integer.parseInt(txtPoblacion.getText().toString());

        Ciudad cCiudad = new Ciudad(cId, cNombre, cLatitud, cLongitud, cPoblacion);
        listaciudades.add(cCiudad);
        limpiar();
    }
}