package com.dev.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView label;
    private EditText ageEdt, nameEdt;
    private SharedPrefsManager sharedPrefsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        String usernameFromPref = sharedPrefsManager.getUserFromPrefData();
        if (usernameFromPref != null)
            label.setText("Bonjour " + usernameFromPref);
    }

    private void init() {
        label = findViewById(R.id.label);
        ageEdt = findViewById(R.id.ageEdt);
        nameEdt = findViewById(R.id.nameEdt);

        Button saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(this);
        Button clearBtn = findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(this);

        sharedPrefsManager = new SharedPrefsManager(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveBtn:
                sharedPrefsManager.saveUserInfo(Integer.parseInt(ageEdt.getText().toString()),
                        nameEdt.getText().toString());
                label.setText("Données sauvegardées");
                break;
            case R.id.clearBtn:
                sharedPrefsManager.clearUserData();
                label.setText("Données effacées");
                break;
            default: {

            }
        }
    }
}
