package com.yhpark.maskinglistviewex;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ppyh0 on 2017-04-04.
 */

public class ChattingAdapter extends ArrayAdapter<String> {
    public ChattingAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_message, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvMessage.setText(getItem(position));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tvMessage)
        TextView tvMessage;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
