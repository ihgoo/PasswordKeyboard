package project.com.password_keyboard.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;

import project.com.password_keyboard.R;
import project.com.password_keyboard.linstener.OnKeybordClickListener;
import project.com.password_keyboard.linstener.OnPasswordCallBack;

/**
 * Created by ihgoo
 */
public class AdapterPasswordKeybord extends RecyclerView.Adapter<AdapterPasswordKeybord.ViewHolder> {

    private final int KEYBORD_SIZE = 12;
    private OnKeybordClickListener mOnKeybordClickListener;
    private OnPasswordCallBack mOnPasswordCallBack;
    private int passwordLength;
    private StringBuffer password;
    private int nowPasswordLength;

    public AdapterPasswordKeybord() {
        init();
    }

    private void init() {
        password = new StringBuffer();
        passwordLength = 6;
    }


    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public void setOnKeybordClickListener(OnKeybordClickListener onKeybordClickListener) {
        this.mOnKeybordClickListener = onKeybordClickListener;
    }

    public OnPasswordCallBack getOnPasswordCallBack() {
        return mOnPasswordCallBack;
    }

    public void setOnPasswordCallBack(OnPasswordCallBack onPasswordCallBack) {
        this.mOnPasswordCallBack = onPasswordCallBack;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_keybord, parent, false);
        AdapterPasswordKeybord.ViewHolder viewHolder = new AdapterPasswordKeybord.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterPasswordKeybord.ViewHolder holder, final int position) {
        int key = position + 1;


        if (position < 9) {
            holder.tvKey.setText(String.valueOf(key));
        } else if (position == 9) {
            holder.tvKey.setText("");
        } else if (position == 10) {
            holder.tvKey.setText("0");
        }

        if (position < 11 && position != 9) {
            holder.viewStub.setVisibility(View.GONE);
            holder.tvKey.setVisibility(View.VISIBLE);
        } else if (position == 9) {
            holder.viewStub.setVisibility(View.GONE);
            holder.tvKey.setVisibility(View.GONE);
        } else {
            holder.tvKey.setVisibility(View.GONE);
            holder.viewStub.setVisibility(View.VISIBLE);
        }


        holder.itemKeybord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position < 9) {
                    mOnKeybordClickListener.onNumberClick(key);
                    passwordApped(key);
                } else if (position == 9) {

                } else if (position == 10) {
                    mOnKeybordClickListener.onNumberClick(0);
                    passwordApped(key);
                } else if (position == 11) {
                    passwordSub();
                    mOnKeybordClickListener.onDeleteClick();
                }

                if (nowPasswordLength == passwordLength) {
                    mOnPasswordCallBack.wholePassword(password.toString());
                }

            }
        });

    }

    private void passwordSub() {
        if (nowPasswordLength > 0) {
            nowPasswordLength--;
            password.delete(password.length() - 1, password.length());
        }
    }

    private void passwordApped(int key) {
        if (password.length() < passwordLength) {
            password.append(String.valueOf(key));
            nowPasswordLength++;
        }
    }

    @Override
    public int getItemCount() {
        return KEYBORD_SIZE;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvKey;
        ViewStub viewStub;
        RelativeLayout itemKeybord;

        ViewHolder(View itemView) {
            super(itemView);
            tvKey = itemView.findViewById(R.id.tv_keys);
            itemKeybord = itemView.findViewById(R.id.item_keybord);
            viewStub = itemView.findViewById(R.id.view_stub);
        }
    }

}
