package com.jacp.a11082017multiwindowsample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAg_";
    private Button adjacentActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adjacentActivity = findViewById(R.id.a_main_intent);

        adjacentActivity.setOnClickListener(view -> launchIntent());
    }

    private void launchIntent() {

        Intent intent = new Intent(this, DetailActivity.class);

        Log.d(TAG, "launchIntent: " + checkFreeform());
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (this.isInMultiWindowMode())
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_MULTIPLE_TASK
                            | Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT);
        }
        startActivity(intent);
    }

    public Boolean checkFreeform() {//check the device
        return getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_FREEFORM_WINDOW_MANAGEMENT);
    }
}
