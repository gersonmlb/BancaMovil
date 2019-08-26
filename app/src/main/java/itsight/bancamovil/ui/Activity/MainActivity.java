package itsight.bancamovil.ui.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import itsight.bancamovil.ui.fragment.ConsumirFragment;
import itsight.bancamovil.ui.fragment.EntradaFragment;
import itsight.bancamovil.R;
import itsight.bancamovil.ui.fragment.EstaditicaFragment;
import itsight.bancamovil.ui.fragment.SaldoFragment;
import itsight.bancamovil.common.BaseActivity;
import itsight.bancamovil.common.BaseFragment;
import itsight.bancamovil.ui.fragment.CuentasFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imv_nav_Perfil;
    private TextView tvw_nav_Nombre;
    private TextView tvw_nav_Fecha;
//    @Override
//    protected BasePresenter getPresenter() {
//        return null;
//    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupView() {
        setupLoader();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //----------------------------------------------------------

        View v = navigationView.getHeaderView(0);

        tvw_nav_Nombre = (TextView) v.findViewById(R.id.tvw_nav_Nombre);

        tvw_nav_Nombre.setText("Orry Nays Cruzado Morey");

        String urlImagen = "https://image.freepik.com/iconos-gratis/herramienta-de-configuracion-de-trabajo_318-85925.png";

        imv_nav_Perfil = (ImageView) v.findViewById(R.id.imv_nav_Perfil);

        Picasso.with(MainActivity.this).load(urlImagen).into(imv_nav_Perfil);


//        imv_nav_Perfil =  (ImageView) navigationView.findViewById(R.id.imv_nav_Perfil);


//        imv_nav_Perfil = (ImageView) findViewById(R.id.imv_nav_Perfil);
//        tvw_nav_Nombre = (TextView) findViewById(R.id.tvw_nav_Nombre);
//        tvw_nav_Fecha = (TextView) findViewById(R.id.tvw_nav_Fecha);


//        tvw_nav_Nombre.setText("BIENVENIDO Orry Nays Cruzado Morey");
//
//
//        SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
//        String date = df.format(Calendar.getInstance().getTime());
//
//        tvw_nav_Fecha.setText(date);

//        new CargarImagen().execute("http://www.codota.com/img/android-logo.png");
        //----------------------------------------------------------

        replaceContentFragment(CuentasFragment.newInstance(), false);

    }

    @Override
    protected void onRestoreView(Bundle savedInstanceState) {
        setupLoader();
    }

    @Override
    protected void onTraslucentBackgroundUpdated(boolean backgroundEnable) {

    }

    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String Titulo = "";
        int id = item.getItemId();

        boolean fragmentTransaction = false;
        BaseFragment firstFragment = null;

        if (id == R.id.nav_camera) {
            firstFragment = new CuentasFragment();
            Titulo = "CONSULTAS";
            fragmentTransaction = true;

        } else if (id == R.id.nav_gallery) {
            firstFragment = new SaldoFragment();
            Titulo = "SALDOS";
            fragmentTransaction = true;

        } else if (id == R.id.nav_slideshow) {
            firstFragment = new EntradaFragment();
            Titulo = "MENSAJES";
            fragmentTransaction = true;

        } else if (id == R.id.nav_manage) {
//            firstFragment = new EstaditicaFragment();
            firstFragment = new ConsumirFragment();
            Titulo = "SERVICIO";
            fragmentTransaction = true;

        } else if (id == R.id.nav_send) {

            firstFragment = new EstaditicaFragment();
//            firstFragment = new ConsumirFragment();
            Titulo = "GRAFICO";
            fragmentTransaction = true;
        }


        if (fragmentTransaction) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.content, firstFragment)
//                    .commit();
//
//            getSupportActionBar().setTitle(Titulo);
            replaceContentFragment(firstFragment, false);
        }


        setTitleBar(Titulo);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


   /* private class CargarImagen extends AsyncTask<String, Void, Bitmap> {

        protected Bitmap doInBackground(String... urls) {
            Bitmap bmp = null;
            try {

                URL url = new URL("http://www.codota.com/img/android-logo.png");

                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return bmp;
        }

        protected void onPostExecute(Bitmap result) {
            imv_nav_Perfil.setImageBitmap(result);
        }
    }*/

}
