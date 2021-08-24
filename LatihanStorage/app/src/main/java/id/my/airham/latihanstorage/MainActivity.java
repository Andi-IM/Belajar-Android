package id.my.airham.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button internalButton, externalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internalButton = (Button) findViewById(R.id.internalButton);
        externalButton = (Button) findViewById(R.id.externalButton);

        internalButton.setOnClickListener(this);
        externalButton.setOnClickListener(this);
    }

    @Override
    public boolean onNavigateUp() {
        return super.onNavigateUp();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.internalButton:
                startActivity(new Intent(this, InternalActivity.class));
                break;
            case R.id.externalButton:
                startActivity(new Intent(this, ExternalActivity.class));
                break;
        }
    }
}