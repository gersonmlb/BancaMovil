package itsight.bancamovil.ui.fragment;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import itsight.bancamovil.R;
import itsight.bancamovil.common.BaseFragment;
import itsight.bancamovil.io.model.Cliente;

public class Ex_RecyclerViewFragment extends BaseFragment {

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_ex__recycler_view;
    }

    @Override
    public boolean hasOptionsMenuEnable() {
        return false;
    }

    @Override
    protected void setupView(View view) {

        List<Cliente> lista_Cliente = new ArrayList<Cliente>();

        lista_Cliente.add(new Cliente(1));
        lista_Cliente.add(new Cliente(2));
        lista_Cliente.add(new Cliente(3));
        lista_Cliente.add(new Cliente(4));
        lista_Cliente.add(new Cliente(5));
        lista_Cliente.add(new Cliente(6));
        lista_Cliente.add(new Cliente(7));
        lista_Cliente.add(new Cliente(8));
        lista_Cliente.add(new Cliente(9));
        lista_Cliente.add(new Cliente(10));







    }

    @Override
    protected void onRestoreView(Bundle savedInstanceState) {

    }
}
