package project.com.passwordkeyboard;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import project.com.password_keyboard.view.PasswordKeyboardView;
import project.com.password_keyboard.adapter.AdapterPasswordKeybord;
import project.com.password_keyboard.linstener.OnKeybordClickListener;
import project.com.password_keyboard.linstener.OnPasswordCallBack;

/**
 * Created by ihgoo
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_show_keybord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PasswordDialog(MainActivity.this).show();
            }
        });

        findViewById(R.id.btn_show_keybord_in_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PasswordKeybordActivity.class));
            }
        });

    }
}
