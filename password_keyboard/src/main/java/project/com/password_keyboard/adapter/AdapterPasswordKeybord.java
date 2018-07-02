package project.com.password_keyboard.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import project.com.password_keyboard.R;

/**
 * Created by ihgoo
 */
public class AdapterPasswordKeybord extends RecyclerView.Adapter<AdapterPasswordKeybord.ViewHolder> {

    private final int KEYBORD_SIZE = 12;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_keybord, parent, false);
        AdapterPasswordKeybord.ViewHolder viewHolder = new AdapterPasswordKeybord.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterPasswordKeybord.ViewHolder holder, int position) {
        int key = position+1;

        if (position < 9) {
            holder.tvKey.setText(String.valueOf(key));
        } else if (position == 9) {
            holder.tvKey.setText(".");
        } else if (position == 10) {
            holder.tvKey.setText("0");
        }

        if (position < 11) {
            holder.viewStub.setVisibility(View.GONE);
            holder.tvKey.setVisibility(View.VISIBLE);
        } else {
            holder.tvKey.setVisibility(View.GONE);
            holder.viewStub.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return KEYBORD_SIZE;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvKey;
        ViewStub viewStub;

        ViewHolder(View itemView) {
            super(itemView);
            tvKey = itemView.findViewById(R.id.tv_keys);
            viewStub = itemView.findViewById(R.id.view_stub);
        }
    }

}
