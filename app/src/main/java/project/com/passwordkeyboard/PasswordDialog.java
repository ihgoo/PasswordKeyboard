package project.com.passwordkeyboard;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import project.com.password_keyboard.adapter.AdapterPasswordKeybord;
import project.com.password_keyboard.linstener.OnKeybordClickListener;
import project.com.password_keyboard.linstener.OnPasswordCallBack;
import project.com.password_keyboard.view.PasswordKeyboardView;

/**
 * Created by ihgoo
 */
public class PasswordDialog extends Dialog {

    private final String TAG = "PasswordDialog";


    public PasswordDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_password_keybord);

        PasswordKeyboardView keyboardView = this.findViewById(R.id.view_password_keyboard);
        keyboardView.setPwdLength(6);
        keyboardView.setShuffle(false);
        keyboardView.rebuild();
        AdapterPasswordKeybord adapterPasswordKeybord = keyboardView.getPasswordKeybord();
        adapterPasswordKeybord.setOnKeybordClickListener(new OnKeybordClickListener() {
            @Override
            public void onNumberClick(int number) {
                Log.e(TAG,"number :" +number);
            }

            @Override
            public void onDeleteClick() {
                Log.e(TAG,"onDeleteClick");
            }
        });


        adapterPasswordKeybord.setOnPasswordCallBack(new OnPasswordCallBack() {
            @Override
            public void wholePassword(String password) {
                Log.e(TAG,"wholePassword: "+password);
            }
        });
    }

    public PasswordDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }




}
