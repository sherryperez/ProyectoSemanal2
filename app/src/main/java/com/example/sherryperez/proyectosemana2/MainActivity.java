package com.example.sherryperez.proyectosemana2;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private AppCompatEditText txtNombreCompleto;
    private AppCompatEditText txtFechaNacimiento;
    private AppCompatEditText txtTelefono;
    private AppCompatEditText txtEmail;
    private AppCompatEditText txtDescripcionContacto;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombreCompleto = findViewById(R.id.txtNombreCompleto);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtTelefono.setFilters(new InputFilter[]{new InputFilter.LengthFilter(9)});
        txtEmail = findViewById(R.id.txtEmail);
        txtDescripcionContacto = findViewById(R.id.txtDescripcionContacto);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        /*
        En esta actividad de principal se recogen los datos recibidos por parámetro para rellenar el
        formulario. Solo vienen cuando se inicia como edición desde la actividad de confirmación.
        Cuando se inicia la actividad como arranque de la aplicación no vienen parámetros.
        */
        if (getIntent().getExtras() != null) {
            txtNombreCompleto.setText(getIntent().getExtras().getString(getResources().getString(R.string.prmNombreCompleto)));
            txtFechaNacimiento.setText(getIntent().getExtras().getString(getResources().getString(R.string.prmFechaNacimiento)));
            txtTelefono.setText(getIntent().getExtras().getString(getResources().getString(R.string.prmTelefono)));
            txtEmail.setText(getIntent().getExtras().getString(getResources().getString(R.string.prmEmail)));
            txtDescripcionContacto.setText(getIntent().getExtras().getString(getResources().getString(R.string.prmDescripcionContacto)));
        }

        /*
        Al hacer click se inicia el fragmento para el picker de fecha.
        Se pasará por parámetro la fecha almacenada en el formulario.
        */
        txtFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dlfFecha = new DatePickerFrament();
                Bundle dlfFechaArgs = new Bundle();

                dlfFechaArgs.putString(getResources().getString(R.string.prmFechaNacimiento), txtFechaNacimiento.getText().toString().trim());

                dlfFecha.setArguments(dlfFechaArgs);

                dlfFecha.show(getFragmentManager(), getResources().getString(R.string.lblFechaNacimiento));
            }
        });

        /*
        Se inicia la actividad de confirmación pasándole los datos introducidos.
        También se finalizará esta actividad.
        */
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntent = new Intent(MainActivity.this, ConfirmarActivity.class);

                objIntent.putExtra(getResources().getString(R.string.prmNombreCompleto), txtNombreCompleto.getText().toString().trim());
                objIntent.putExtra(getResources().getString(R.string.prmFechaNacimiento), txtFechaNacimiento.getText().toString().trim());
                objIntent.putExtra(getResources().getString(R.string.prmTelefono), txtTelefono.getText().toString().trim());
                objIntent.putExtra(getResources().getString(R.string.prmEmail), txtEmail.getText().toString().trim());
                objIntent.putExtra(getResources().getString(R.string.prmDescripcionContacto), txtDescripcionContacto.getText().toString().trim());

                startActivity(objIntent);

                finish();
            }
        });
    }
}