package com.example.listenapp.main;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import com.example.listenapp.R;


public class AccPlaceholder extends AppCompatActivity {

    TextView user, pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
        setViews();
    }
    private void findViews() {
        setContentView(R.layout.activity_acc_placeholder);
        user = findViewById(R.id.user_name);
        pass = findViewById(R.id.pw_show);
    }
    private void setViews(){
        user.setText(getIntent().getExtras().getString("USER"));
        pass.setText(getIntent().getExtras().getString("PASS"));
    }
}
