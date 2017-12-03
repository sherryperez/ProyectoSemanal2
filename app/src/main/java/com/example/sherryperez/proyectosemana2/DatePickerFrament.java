package com.example.sherryperez.proyectosemana2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePickerFrament extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private static final String ARG_FECHA = "com.example.sherryperez.proyectosemana2:arg:fecha";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        Se intenta recoger el parámetro fecha para establecer los valores con los que se
        inicializará el picker de fecha en su creación. Si no hubiese parámetro o estuviese vacío el
        picker de fecha se inicializará con el mínimo valor.
        */
        int year = -1;
        int month = -1;
        int dayofmonth = -1;

        try {
            if (getArguments() != null) {
                String strFecha = getArguments().getString(getResources().getString(R.string.prmFechaNacimiento));
                Date objFecha = DateFormat.getDateInstance().parse(strFecha);
                Calendar objCal = Calendar.getInstance();
                objCal.setTime(objFecha);

                year = objCal.get(Calendar.YEAR);
                month = objCal.get(Calendar.MONTH);
                dayofmonth = objCal.get(Calendar.DAY_OF_MONTH);
            }
        } catch (Exception objException) {
            year = -1;
            month = -1;
            dayofmonth = -1;
        }

        return new DatePickerDialog(getActivity(), this, year, month, dayofmonth);
    }

    /*
    Al pulsar el botón que establece la fecha seleccionada, se guardará esa fecha en formato texto
    en el campo correspondiente de la actividad que inicia este fragmento.
    */
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar objCal = Calendar.getInstance();
        objCal.set(year, month, day);

        String strFecha = DateFormat.getDateInstance().format(objCal.getTime());

        ((AppCompatEditText) getActivity().findViewById(R.id.txtFechaNacimiento)).setText(strFecha);
    }
}