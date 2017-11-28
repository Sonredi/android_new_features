package com.jacp.a11102017multiwinsample;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.a_main_split);

        button.setOnClickListener(v -> splitScreen());

    }

    private void splitScreen() {
        Intent intent = new Intent(this, SecondActivity.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            if (this.isInMultiWindowMode())
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_MULTIPLE_TASK
                        | Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT);
        }
        startActivity(intent);

    }
}
