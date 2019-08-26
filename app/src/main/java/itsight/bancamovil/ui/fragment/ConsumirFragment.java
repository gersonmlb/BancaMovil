package itsight.bancamovil.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import itsight.bancamovil.R;
import itsight.bancamovil.common.BaseFragment;
import itsight.bancamovil.io.model.Cliente;
import itsight.bancamovil.io.service.network.BancaMovilApiAdapter;
import itsight.bancamovil.io.service.network.BancaMovilApiService;
import itsight.bancamovil.lista.Lista_Adaptador;
import itsight.bancamovil.lista.Lista_Entrada_Mensaje;
import itsight.bancamovil.ui.adapter.ClienteAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConsumirFragment extends BaseFragment {

    private BancaMovilApiService bancaMovilApiService;
    private TextView txt_Consumir_2;

//    private RecyclerView rvw_Clientes;

//    private ClienteAdapter clienteAdapter;

    private BancaMovilApiService getApiService() {
        if (bancaMovilApiService == null) {
            bancaMovilApiService = BancaMovilApiAdapter.getInstance().create(BancaMovilApiService.class);
        }
        return bancaMovilApiService;
    }


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_consumir;
    }

    @Override
    public boolean hasOptionsMenuEnable() {
        return false;
    }

    @Override
    protected void setupView(View view) {


        final ArrayList<Lista_Entrada_Mensaje> mensajes = new ArrayList<Lista_Entrada_Mensaje>();
        final RecyclerView rvw_Clientes = (RecyclerView) view.findViewById(R.id.rvw_Clientes);
        rvw_Clientes.setLayoutManager(new LinearLayoutManager(getContext()));

        txt_Consumir_2 = (TextView) view.findViewById(R.id.txt_Consumir_2);
        //------------------------------------------------
        //------------------------------------------------

        Call<List<Cliente>> call = getApiService().loadRepo();

        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {

                List<Cliente> l = response.body();

                txt_Consumir_2.setText("Total : " + l.size());


//                List<Movie> movies = response.body().getResults();
                ClienteAdapter adapter = new ClienteAdapter(l, getContext());
                rvw_Clientes.setAdapter(adapter);


//                for (Cliente cliente : l) {
//
//                    mensajes.add(new Lista_Entrada_Mensaje(cliente.getNombre(), cliente.getTelefono()));
//
//                }
//
//                txt_Consumir_2.setText("Total : "+mensajes.size());
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {

            }
        });

        /*Call<Cliente> call = getApiService().One_Cliente(1);

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                 Cliente c = response.body();

                txt_Consumir_2.setText(c.toString());
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {

            }
        });*/
        //------------------------------------------------
        //------------------------------------------------

      /*  Call<String> call = getApiService().Hola();


        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                txt_Consumir_2.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });*/

        //------------------------------------------------
        //------------------------------------------------
//        Call<Cliente> call = getApiService().One_Cliente(1);

//        call.enqueue(new Callback<Cliente>() {
//            @Override
//            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
//
//                Cliente c = response.body();
//
////                String Nombre = c.getNombre();
////                String Telefono = c.getTelefono();
//
////                txt_Consumir_2.setText(Nombre + " -- " + Telefono);
//                txt_Consumir_2.setText(c.Nombre + " - " + c.Telefono);
//            }
//
//            @Override
//            public void onFailure(Call<Cliente> call, Throwable t) {
//
//            }
//        });

//
//        ListView lista = (ListView) view.findViewById(R.id.lvw_Consumir);
//        lista.setAdapter(new Lista_Adaptador(getContext(), R.layout.item_mensaje, mensajes) {
//
//            @Override
//            public void onEntrada(Object entrada, View view) {
//                TextView txt_Fila_Lista_Fecha = (TextView) view.findViewById(R.id.txt_Fila_Lista_Fecha);
//                txt_Fila_Lista_Fecha.setText(((Lista_Entrada_Mensaje) entrada).getFecha());
//
//                TextView txt_Fila_Lista_Descripcion = (TextView) view.findViewById(R.id.txt_Fila_Lista_Descripcion);
//                txt_Fila_Lista_Descripcion.setText(((Lista_Entrada_Mensaje) entrada).getDescripcion());
////
////                TextView txt_Fila_Lista_Monto = (TextView) view.findViewById(R.id.txt_Fila_Lista_Monto);
////                txt_Fila_Lista_Monto.setText(String.valueOf(((Lista_Entrada_Movimiento) entrada).getMonto()));
//
////                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.txt_Fila_Lista_Monto);
////                imagen_entrada.setImageResource(((Lista_Entrada_Movimiento) entrada).getMonto());
//            }
//        });
//
//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
//                Lista_Entrada_Mensaje elegido = (Lista_Entrada_Mensaje) pariente.getItemAtPosition(posicion);
//
//                CharSequence texto = "Seleccionado: " + elegido.getDescripcion();
//                Toast toast = Toast.makeText(getContext(), texto, Toast.LENGTH_LONG);
//                toast.show();
//            }
//        });

    }

    @Override
    protected void onRestoreView(Bundle savedInstanceState) {

    }
}
