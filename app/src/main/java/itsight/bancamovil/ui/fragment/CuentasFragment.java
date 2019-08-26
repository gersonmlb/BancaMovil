package itsight.bancamovil.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import itsight.bancamovil.Movimiento;
import itsight.bancamovil.R;
import itsight.bancamovil.common.BaseFragment;
import itsight.bancamovil.common.BasePresenter;

public class CuentasFragment extends BaseFragment {

    private RelativeLayout rly_Cuenta_01;
    private RelativeLayout rly_Cuenta_02;
    private RelativeLayout rly_Cuenta_03;

    public static CuentasFragment newInstance() {
        CuentasFragment cuentasFragment = new CuentasFragment();
        return cuentasFragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_cuentas;
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

        rly_Cuenta_01 = (RelativeLayout) view.findViewById(R.id.rly_Cuenta_01);
        rly_Cuenta_02 = (RelativeLayout) view.findViewById(R.id.rly_Cuenta_02);
        rly_Cuenta_03 = (RelativeLayout) view.findViewById(R.id.rly_Cuenta_03);

        rly_Cuenta_01.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Fragment firstFragment = new Movimiento();

                final FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.content, firstFragment).commit();

                return true;
            }
        });

        rly_Cuenta_02.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Fragment firstFragment = new Movimiento();

                final FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.content, firstFragment).commit();

                return true;
            }
        });


        rly_Cuenta_03.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Fragment firstFragment = new Movimiento();

                final FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.content, firstFragment).commit();

                return true;
            }
        });

    }

    @Override
    protected void onRestoreView(Bundle savedInstanceState) {

    }
}
