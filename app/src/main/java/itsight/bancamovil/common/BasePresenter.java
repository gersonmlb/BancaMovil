package itsight.bancamovil.common;
 
public abstract class BasePresenter {

    public abstract void onStart();

    public abstract void onStop();

    public abstract IBaseView getBaseView();
}