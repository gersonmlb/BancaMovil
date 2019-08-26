package itsight.bancamovil.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import itsight.bancamovil.R;
import itsight.bancamovil.common.BaseFragment;
import itsight.bancamovil.lista.Lista_Adaptador;
import itsight.bancamovil.lista.Lista_Entrada_Mensaje;


public class EntradaFragment extends BaseFragment {

    ArrayList<Lista_Entrada_Mensaje> mensajes = new ArrayList<Lista_Entrada_Mensaje>();

    public static EntradaFragment newInstance() {
        EntradaFragment entradaFragment = new EntradaFragment();
        return entradaFragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_entrada;
    }

    @Override
    public boolean hasOptionsMenuEnable() {
        return false;
    }

    @Override
    protected void setupView(View view) {

        mensajes.add(new Lista_Entrada_Mensaje("Fecha1", "Descricion1"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha2", "Descricion2"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha3", "Descricion3"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha4", "Descricion4"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha5", "Descricion5"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha6", "Descricion6"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha7", "Descricion7"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha8", "Descricion8"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha9", "Descricion9"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha1", "Descricion1"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha2", "Descricion2"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha3", "Descricion3"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha4", "Descricion4"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha5", "Descricion5"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha6", "Descricion6"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha7", "Descricion7"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha8", "Descricion8"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha9", "Descricion9"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha1", "Descricion1"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha2", "Descricion2"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha3", "Descricion3"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha4", "Descricion4"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha5", "Descricion5"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha6", "Descricion6"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha7", "Descricion7"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha8", "Descricion8"));
        mensajes.add(new Lista_Entrada_Mensaje("Fecha9", "Descricion9"));


        ListView lista = (ListView) view.findViewById(R.id.lvw_Mensajes);
        lista.setAdapter(new Lista_Adaptador(getContext(), R.layout.item_mensaje, mensajes) {

            @Override
            public void onEntrada(Object entrada, View view) {
                TextView txt_Fila_Lista_Fecha = (TextView) view.findViewById(R.id.txt_Fila_Lista_Fecha);
                txt_Fila_Lista_Fecha.setText(((Lista_Entrada_Mensaje) entrada).getFecha());

                TextView txt_Fila_Lista_Descripcion = (TextView) view.findViewById(R.id.txt_Fila_Lista_Descripcion);
                txt_Fila_Lista_Descripcion.setText(((Lista_Entrada_Mensaje) entrada).getDescripcion());
//
//                TextView txt_Fila_Lista_Monto = (TextView) view.findViewById(R.id.txt_Fila_Lista_Monto);
//                txt_Fila_Lista_Monto.setText(String.valueOf(((Lista_Entrada_Movimiento) entrada).getMonto()));

//                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.txt_Fila_Lista_Monto);
//                imagen_entrada.setImageResource(((Lista_Entrada_Movimiento) entrada).getMonto());
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_Entrada_Mensaje elegido = (Lista_Entrada_Mensaje) pariente.getItemAtPosition(posicion);

                CharSequence texto = "Seleccionado: " + elegido.getDescripcion();
                Toast toast = Toast.makeText(getContext(), texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

    @Override
    protected void onRestoreView(Bundle savedInstanceState) {

    }
}
