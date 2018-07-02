package project.com.password_keyboard;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import project.com.password_keyboard.adapter.AdapterPasswordKeybord;

/**
 * Created by ihgoo
 */
public class PasswordKeyboardView extends RelativeLayout {

    private final int ROW = 3;
    private RecyclerView keybordView;    //用GrideView布局键盘，其实并不是真正的键盘，只是模拟键盘的功能
    private RelativeLayout layoutBack;

    public PasswordKeyboardView(Context context) {
        super(context);
    }

    public PasswordKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.layout_password_keyboard, null);
        layoutBack = view.findViewById(R.id.layoutBack);
        keybordView = view.findViewById(R.id.rv_keybord);
        AdapterPasswordKeybord adapterPasswordKeybord = new AdapterPasswordKeybord();
        keybordView.setAdapter(adapterPasswordKeybord);
        keybordView.setLayoutManager(new GridLayoutManager(context, ROW));
        addView(view);
    }

    public RelativeLayout getLayoutBack() {
        return layoutBack;
    }

    public RecyclerView getRecyclerView() {
        return keybordView;
    }

}
