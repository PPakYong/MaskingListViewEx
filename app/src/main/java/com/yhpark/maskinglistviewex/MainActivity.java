package com.yhpark.maskinglistviewex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
    public boolean onEditorAction(int actionId) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            inputChat();
        }

        return false;
    }

    @OnClick(R.id.ibDone)
    public void onClick() {
        inputChat();
    }

    private void inputChat() {
        if ("".equals(etMessage.getText().toString())) {
            Toast.makeText(this, "edittext is empty!", Toast.LENGTH_SHORT).show();
        } else {
            adapter.add(etMessage.getText().toString());
            adapter.notifyDataSetChanged();

            etMessage.setText("");
            mlvMessage.getListView().setSelection(adapter.getCount() - 1);
        }
    }
}
