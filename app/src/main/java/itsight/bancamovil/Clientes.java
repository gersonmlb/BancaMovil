package itsight.bancamovil;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Clientes extends Fragment {

    private EditText edt_Buscar;
    private Button btn_Buscar;
    private ListView lvw_Clientes;

    public Clientes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_clientes, container, false);

        edt_Buscar = (EditText) view.findViewById(R.id.edt_Buscar);
        btn_Buscar = (Button) view.findViewById(R.id.btn_Buscar);
        lvw_Clientes = (ListView) view.findViewById(R.id.lvw_Clientes);


        btn_Buscar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                String mensaje = edt_Buscar.getText().toString();
                Snackbar.make(view, mensaje, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }

        });

        return view;
    }

}
