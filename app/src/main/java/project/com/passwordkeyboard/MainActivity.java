package project.com.passwordkeyboard;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import project.com.password_keyboard.view.PasswordKeyboardView;
import project.com.password_keyboard.adapter.AdapterPasswordKeybord;
import project.com.password_keyboard.linstener.OnKeybordClickListener;
import project.com.password_keyboard.linstener.OnPasswordCallBack;

/**
 * Created by ihgoo
 */
public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PasswordKeyboardView keyboardView = findViewById(R.id.view_password_keyboard);
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
}
