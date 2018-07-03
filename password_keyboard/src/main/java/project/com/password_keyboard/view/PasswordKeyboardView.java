package project.com.password_keyboard.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import project.com.password_keyboard.R;
import project.com.password_keyboard.adapter.AdapterPasswordKeybord;
import project.com.password_keyboard.linstener.OnCloseClickListener;

/**
 * Created by ihgoo
 */
public class PasswordKeyboardView extends RelativeLayout {

    private final int ROW = 3;
    private RecyclerView keybordView;
    private RelativeLayout layoutBack;
    private AdapterPasswordKeybord adapterPasswordKeybord;
    private OnCloseClickListener mOnCloseClickListener;

    private int pwdLength;
    private boolean shuffle;

    private View inflateView;
    private Context mContext;

    public PasswordKeyboardView(Context context) {
        super(context);
    }

    public PasswordKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        inflateView = View.inflate(context, R.layout.layout_password_keyboard, null);
        layoutBack = inflateView.findViewById(R.id.layoutBack);
        keybordView = inflateView.findViewById(R.id.rv_keybord);
        layoutBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnCloseClickListener != null) {
                    mOnCloseClickListener.onCloseClick();
                }
            }
        });

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.password_keybord);
        shuffle = typedArray.getBoolean(R.styleable.password_keybord_shuffle, true);
        pwdLength = typedArray.getInteger(R.styleable.password_keybord_pwdLength, 6);
        build();
    }


    private PasswordKeyboardView build(){
        adapterPasswordKeybord = new AdapterPasswordKeybord(shuffle,pwdLength);
        keybordView.setAdapter(adapterPasswordKeybord);
        keybordView.setLayoutManager(new GridLayoutManager(mContext, ROW));
        addView(inflateView);
        return this;
    }


    public PasswordKeyboardView rebuild(){
        adapterPasswordKeybord = new AdapterPasswordKeybord(shuffle,pwdLength);
        keybordView.setAdapter(adapterPasswordKeybord);
        keybordView.setLayoutManager(new GridLayoutManager(mContext, ROW));
        removeAllViews();
        addView(inflateView);
        return this;
    }



    public int getPwdLength() {
        return pwdLength;
    }

    public PasswordKeyboardView setPwdLength(int pwdLength) {
        this.pwdLength = pwdLength;
        return this;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public PasswordKeyboardView setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
        return this;
    }

    public AdapterPasswordKeybord getPasswordKeybord() {
        return adapterPasswordKeybord;
    }


}
