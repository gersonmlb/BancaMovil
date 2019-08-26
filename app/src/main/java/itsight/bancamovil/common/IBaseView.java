package itsight.bancamovil.common;

public interface IBaseView {
    void startLoading();

    void stopLoading();

    void showErrorDialog(String message);
}
