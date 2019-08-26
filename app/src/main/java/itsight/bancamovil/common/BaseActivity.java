package itsight.bancamovil.common;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

//import butterknife.ButterKnife;
//import butterknife.Unbinder;
import itsight.bancamovil.R;
import itsight.bancamovil.ui.view.LoaderDialog;
import itsight.bancamovil.ui.view.MessageDialog;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    protected Toolbar mToolbar;
    protected Dialog mProgress;

//    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
//        injectViews();
        if (savedInstanceState != null) {
            onRestoreView(savedInstanceState);
        } else {
            setupView();
        }
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (getPresenter() != null) {
//            getPresenter().onStart();
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (getPresenter() != null)
//            getPresenter().onStop();
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mProgress != null) {
            mProgress.dismiss();
            mProgress = null;
        }
    }

    @Override
    public void startLoading() {
        if (mProgress != null) {
            mProgress.show();
        }
    }

    @Override
    public void stopLoading() {
        if (mProgress != null) {
            mProgress.dismiss();
        }
    }

    @Override
    public void showErrorDialog(String messsage) {
        MessageDialog.showMessageDialog(this, messsage);
    }

    @Override
    public void startActivity(Intent intent) {
        //NetcashApp.setPreviousActivity(this);
        super.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        //NetcashApp.setPreviousActivity(this);
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        //NetcashApp.setPreviousActivity(this);
        super.startActivityForResult(intent, requestCode, options);
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public void replaceFragment(int res, BaseFragment fragment, boolean backStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (backStack) {
            transaction.addToBackStack(null);
        }
        transaction.replace(res, fragment).commit();
    }

    public void replaceContentFragment(BaseFragment fragment, boolean backStack) {
        replaceFragment(R.id.content, fragment, backStack);
    }

    public void setTitleBar(String Titulo) {
        getSupportActionBar().setTitle(Titulo);

    }

    public void setupLoader() {
        mProgress = new LoaderDialog(this);
    }

//    private void injectViews() {
//        unbinder = ButterKnife.bind(this);
//    }
//
//    private void unbindViews() {
////        ButterKnife.unbind(this);
//        unbinder.unbind();
//    }

    public void lockOrientation(Boolean flag) {
        if (flag) {
            //  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
            Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            int rotation = display.getRotation();
            int currentOrientation = getResources().getConfiguration().orientation;
            int orientation = 0;
            switch (currentOrientation) {
                case Configuration.ORIENTATION_LANDSCAPE:
                    if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_90)
                        orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                    else
                        orientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                    break;
                case Configuration.ORIENTATION_PORTRAIT:
                    if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_270)
                        orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                    else
                        orientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                    break;
                default:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                    break;
            }
            setRequestedOrientation(orientation);

/*
            if(getString(R.string.orientation).compareTo("1") == 0){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }*/
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
        }
    }

//    protected abstract BasePresenter getPresenter();

    protected abstract int getLayout();

    protected abstract void setupView();

    protected abstract void onRestoreView(Bundle savedInstanceState);

    protected abstract void onTraslucentBackgroundUpdated(boolean backgroundEnable);
}
