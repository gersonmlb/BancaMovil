package itsight.bancamovil.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import itsight.bancamovil.Movimiento;
import itsight.bancamovil.R;
import itsight.bancamovil.common.BaseFragment;
import itsight.bancamovil.common.BasePresenter;

public class SaldoFragment extends BaseFragment {

    private Button btn_Movimientos_go;

    public static SaldoFragment newInstance() {
        SaldoFragment saldosFragment = new SaldoFragment();
        return saldosFragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_saldo;
    }

    @Override
    public boolean hasOptionsMenuEnable() {
        return false;
    }

//    @Override
//    protected BasePresenter getPresenter() {
//        return null;
//    }

    @Override
    protected void setupView(View view) {

        btn_Movimientos_go = (Button) view.findViewById(R.id.btn_Movimientos_go);

        btn_Movimientos_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment firstFragment = new Movimiento();

                final FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.content, firstFragment).commit();


            }
        });
    }

    @Override
    protected void onRestoreView(Bundle savedInstanceState) {

    }
}
