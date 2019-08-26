package itsight.bancamovil.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;

import itsight.bancamovil.R;

public class MessageDialog {
    Context context;

    public static void showMessageDialog(Context context, String message) {
        AlertDialog dialog = new AlertDialog.Builder(new ContextThemeWrapper(
                context, R.style.DialogStyle)).setTitle(context.getString(R.string.app_name))
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.dialog_message_positive), null).create();
        dialog.setCancelable(false);
        dialog.show();
    }
    public static void showMessageDialog(Context context, String message, DialogInterface.OnClickListener listener) {
        AlertDialog dialog = new AlertDialog.Builder(new ContextThemeWrapper(
                context, R.style.DialogStyle)).setTitle(context.getString(R.string.app_name))
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.dialog_message_positive), listener).create();
        dialog.setCancelable(false);
        dialog.show();
    }
}
