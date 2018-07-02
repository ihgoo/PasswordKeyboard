package project.com.password_keyboard.view;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import project.com.password_keyboard.R;
import project.com.password_keyboard.adapter.AdapterPasswordKeybord;

/**
 * Created by ihgoo
 */
public class PasswordKeyboardView extends RelativeLayout {

    private final int ROW = 3;
    private RecyclerView keybordView;
    private RelativeLayout layoutBack;
    private AdapterPasswordKeybord adapterPasswordKeybord;

    public PasswordKeyboardView(Context context) {
        super(context);
    }

    public PasswordKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.layout_password_keyboard, null);
        layoutBack = view.findViewById(R.id.layoutBack);
        keybordView = view.findViewById(R.id.rv_keybord);
        adapterPasswordKeybord = new AdapterPasswordKeybord();
        keybordView.setAdapter(adapterPasswordKeybord);
        keybordView.setLayoutManager(new GridLayoutManager(context, ROW));
        addView(view);
    }

    public AdapterPasswordKeybord getPasswordKeybord() {
        return adapterPasswordKeybord;
    }
}
