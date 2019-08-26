package itsight.bancamovil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import itsight.bancamovil.lista.Lista_Adaptador;
import itsight.bancamovil.lista.Lista_Entrada_Movimiento;

public class Movimiento extends Fragment {

    ArrayList<Lista_Entrada_Movimiento> movientos = new ArrayList<Lista_Entrada_Movimiento>();


    public Movimiento() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movimiento, container, false);

        movientos.add(new Lista_Entrada_Movimiento("Fecha1", "Movimiento Descricion1", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha2", "Movimiento Descricion2", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha9", "Movimiento Descricion9", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha4", "Movimiento Descricion4", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha5", "Movimiento Descricion5", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha3", "Movimiento Descricion3", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha4", "Movimiento Descricion4", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha5", "Movimiento Descricion5", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha6", "Movimiento Descricion6", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha7", "Movimiento Descricion7", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha8", "Movimiento Descricion8", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha6", "Movimiento Descricion6", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha7", "Movimiento Descricion7", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha8", "Movimiento Descricion8", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha9", "Movimiento Descricion9", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha4", "Movimiento Descricion4", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha5", "Movimiento Descricion5", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha6", "Movimiento Descricion6", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha7", "Movimiento Descricion7", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha8", "Movimiento Descricion8", 250));
        movientos.add(new Lista_Entrada_Movimiento("Fecha9", "Movimiento Descricion9", 250));


        ListView lista = (ListView) view.findViewById(R.id.lvw_Movimientos);
        lista.setAdapter(new Lista_Adaptador(getContext(), R.layout.item_movimiento, movientos) {

            @Override
            public void onEntrada(Object entrada, View view) {
                TextView txt_Fila_Lista_Fecha = (TextView) view.findViewById(R.id.txt_Fila_Lista_Fecha);
                txt_Fila_Lista_Fecha.setText(((Lista_Entrada_Movimiento) entrada).getFecha());

                TextView txt_Fila_Lista_Descripcion = (TextView) view.findViewById(R.id.txt_Fila_Lista_Descripcion);
                txt_Fila_Lista_Descripcion.setText(((Lista_Entrada_Movimiento) entrada).getDescripcion());

                TextView txt_Fila_Lista_Monto = (TextView) view.findViewById(R.id.txt_Fila_Lista_Monto);
                txt_Fila_Lista_Monto.setText(String.valueOf(((Lista_Entrada_Movimiento) entrada).getMonto()));

//                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.txt_Fila_Lista_Monto);
//                imagen_entrada.setImageResource(((Lista_Entrada_Movimiento) entrada).getMonto());
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_Entrada_Movimiento elegido = (Lista_Entrada_Movimiento) pariente.getItemAtPosition(posicion);

                CharSequence texto = "Seleccionado: " + elegido.getDescripcion();
                Toast toast = Toast.makeText(getContext(), texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });
        return view;
    }

}
