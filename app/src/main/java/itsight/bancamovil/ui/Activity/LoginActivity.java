package itsight.bancamovil.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import butterknife.BindView;
//import butterknife.OnClick;
import itsight.bancamovil.R;
import itsight.bancamovil.common.BaseActivity;
import itsight.bancamovil.common.BasePresenter;


public class LoginActivity extends BaseActivity {

    //    @BindView(R.id.edt_login_NumeroCuenta)
    EditText edt_login_NumeroCuenta;
    //    @BindView(R.id.edt_login_Password)
    EditText edt_login_Password;
    //    @BindView(R.id.btn_Login)
    Button btn_Login;

//    BancaMovilApiService bancaMovilApiService;

//    @Override
//    protected BasePresenter getPresenter() {
//        return null;
//    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setupView() {
//        setupLoader();

        btn_Login = (Button) findViewById(R.id.btn_Login);
        edt_login_NumeroCuenta = (EditText) findViewById(R.id.edt_login_NumeroCuenta);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String mensaje = edt_login_NumeroCuenta.getText().toString();
//
//                Snackbar.make(v, "Bienvenido " + mensaje, Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

//        replaceContentFragment(LoginFragment.newInstance(), false);
    }

    @Override
    protected void onRestoreView(Bundle savedInstanceState) {
        setupLoader();
    }

    @Override
    protected void onTraslucentBackgroundUpdated(boolean backgroundEnable) {

    }

////    @OnClick(R.id.btn_Login)
//    public void submit(View view) {
//
////        Toast.makeText(this, edt_login_NumeroCuenta.getText(), LENGTH_SHORT).show();
//        String mensaje = edt_login_NumeroCuenta.getText().toString();
//
//        Snackbar.make(view, "Bienvenido " + mensaje, Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
//
//    }

    /*private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    private Button btn_Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        btn_Login = (Button) findViewById(R.id.btn_Login);

        btn_Login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

//                String mensaje = mEmailView.getText().toString();
//                Snackbar.make(view, "Bienvenido " + mensaje, Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);

//                Fragment firstFragment = new CuentasFragment();
//
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.detalle, firstFragment)
//                        .commit();
//
//                getSupportActionBar().setTitle("CUENTAS");

            }

        });


    }*/


}

