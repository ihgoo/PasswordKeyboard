package project.com.passwordkeyboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import java.lang.reflect.Method;

import project.com.password_keyboard.linstener.OnKeybordClickListener;
import project.com.password_keyboard.linstener.OnPasswordCallBack;
import project.com.password_keyboard.view.PasswordKeyboardView;

/**
 * Created by ihgoo
 */
public class PasswordKeybordActivity extends AppCompatActivity implements OnPasswordCallBack, OnKeybordClickListener {

    private EditText textAmount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_keybord);

        textAmount = findViewById(R.id.et);
        PasswordKeyboardView keyboardView = findViewById(R.id.keyboardView);
        //if you dont want to use custom attributes :
//        keyboardView.setPwdLength(6);
//        keyboardView.setShuffle(true);

        keyboardView.getPasswordKeybord().setOnKeybordClickListener(this);
        keyboardView.getPasswordKeybord().setOnPasswordCallBack(this);


        if (android.os.Build.VERSION.SDK_INT <= 10) {
            textAmount.setInputType(InputType.TYPE_NULL);
        } else {
            this.getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus",
                        boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(textAmount, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void wholePassword(String password) {

    }

    @Override
    public void onNumberClick(int number) {
        textAmount.setText(String.valueOf(number));
    }

    @Override
    public void onDeleteClick() {
        textAmount.setText("-");
    }
}
