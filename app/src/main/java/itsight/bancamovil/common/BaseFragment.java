package itsight.bancamovil.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import butterknife.ButterKnife;
//import butterknife.Unbinder;
import itsight.bancamovil.io.service.local.BancaMovilLocalApiService;

public abstract class BaseFragment extends Fragment implements IBaseView {

    protected Context CONTEXT;

    BancaMovilLocalApiService bancaMovilLocalApiService;

//    private Unbinder unbinder;

    private BancaMovilLocalApiService getLocalApiService() {
        if (bancaMovilLocalApiService == null) {
            bancaMovilLocalApiService = new BancaMovilLocalApiService(getContext());
        }
        return bancaMovilLocalApiService;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CONTEXT = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(hasOptionsMenuEnable());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        bindViews(view);
        if (savedInstanceState != null) {
            onRestoreView(savedInstanceState);
        } else {
            setupView(view);
        }
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        if (getPresenter() != null) {
//            getPresenter().onStart();
//        }
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (getPresenter() != null) {
//            getPresenter().onStop();
//        }
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbindViews();
    }

    @Override
    public void startLoading() {
        ((BaseActivity) CONTEXT).startLoading();
    }

    @Override
    public void stopLoading() {
        ((BaseActivity) CONTEXT).stopLoading();
    }

    @Override
    public void showErrorDialog(String message) {
        ((BaseActivity) CONTEXT).showErrorDialog(message);
    }

    @Override
    public void startActivity(Intent intent) {
        //NetcashApp.setPreviousActivity((BaseActivity) CONTEXT);
        super.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        //NetcashApp.setPreviousActivity((BaseActivity) CONTEXT);
        super.startActivityForResult(intent, requestCode);
    }

//    private void bindViews(View view) {
////        ButterKnife.bind(this, view);
//        unbinder = ButterKnife.bind(this, view);
//    }
//
//    private void unbindViews() {
////        ButterKnife.unbind(this);
//        unbinder.unbind();
//    }

    protected abstract int getFragmentLayout();

    public abstract boolean hasOptionsMenuEnable();

//    protected abstract BasePresenter getPresenter();

    protected abstract void setupView(View view);

    protected abstract void onRestoreView(Bundle savedInstanceState);
}
