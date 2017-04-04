package com.yhpark.maskinglistviewex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mlvMessage)
    MaskingListView mlvMessage;
    @BindView(R.id.etMessage)
    EditText etMessage;
    @BindView(R.id.ibDone)
    ImageButton ibDone;
    @BindView(R.id.llInput)
    LinearLayout llInput;

    ChattingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new ChattingAdapter(getApplicationContext(), R.layout.row_message, new ArrayList<String>());
        mlvMessage.getListView().setAdapter(adapter);
    }

    @OnEditorAction(R.id.etMessage)
    public boolean onEditorAction(TextView view, int state, KeyEvent event) {
        if (event.equals(KeyEvent.ACTION_DOWN)) {
            ibDone.performClick();
        }

        return false;
    }

    @OnClick(R.id.ibDone)
    public void onClick() {
        if ("".equals(etMessage.getText().toString())) {
            Toast.makeText(this, "edittext is empty!", Toast.LENGTH_SHORT).show();
        } else {
            adapter.add(etMessage.getText().toString());
            adapter.notifyDataSetChanged();

            etMessage.setText("");
        }
    }
}
