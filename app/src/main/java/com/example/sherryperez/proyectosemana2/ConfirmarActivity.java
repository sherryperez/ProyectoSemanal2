package com.example.sherryperez.proyectosemana2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class ConfirmarActivity extends AppCompatActivity {
    private TextView txtNombreCompleto;
    private TextView txtFechaNacimiento;
    private TextView txtTelefono;
    private TextView txtEmail;
    private TextView txtDescripcionContacto;
    private Button btnEditarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        txtNombreCompleto = findViewById(R.id.txtNombreCompleto);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        txtDescripcionContacto = findViewById(R.id.txtDescripcionContacto);
        btnEditarDatos = findViewById(R.id.btnEditarDatos);


        txtNombreCompleto.setText(getIntent().getExtras().getString(getResources().getString(R.string.prmNombreCompleto)));
        txtFechaNacimiento.setText(getIntent().getExtras().getString(getResources().getString(R.string.prmFechaNacimiento)));
        txtTelefono.setText(getIntent().getExtras().getString(getResources().getString(R.string.prmTelefono)));
        txtEmail.setText(getIntent().getExtras().getString(getResources().getString(R.string.prmEmail)));
        txtDescripcionContacto.setText(getIntent().getExtras().getString(getResources().getString(R.string.prmDescripcionContacto)));


        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntent = new Intent(ConfirmarActivity.this, MainActivity.class);

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
