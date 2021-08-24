package airham.my.id.aplikasisqlite;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import airham.my.id.aplikasisqlite.helper.DbHelper;

public class AddEditActivity extends AppCompatActivity {
    EditText txt_id, txt_name, txt_address;
    Button btn_submit, btn_cancel;
    DbHelper SQLite = new DbHelper(this);
    String id, name, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_id = findViewById(R.id.txt_id);
        txt_name = findViewById(R.id.txt_name);
        txt_address = findViewById(R.id.txt_address);
        btn_submit = findViewById(R.id.btn_submit);
        btn_cancel = findViewById(R.id.btn_cancel);

        id = getIntent().getStringExtra(MainActivity.TAG_ID);
        name = getIntent().getStringExtra(MainActivity.TAG_NAME);
        address = getIntent().getStringExtra(MainActivity.TAG_ADDRESS);

        if (id == null || id.isEmpty()) {
            setTitle("Add Data");
        } else {
            setTitle("Edit Data");
            txt_id.setText(id);
            txt_name.setText(name);
            txt_address.setText(address);
        }

        btn_submit.setOnClickListener(v -> {
            try {
                if (txt_id.getText().toString().equals("")) {
                    save();
                } else {
                    edit();
                }
            } catch (Exception e) {
                Log.e("SUBMIT", "onCreate: " + e.toString());
            }
        });

        btn_cancel.setOnClickListener(v -> {
            blank();
            finish();
        });
    }

    private void blank() {
        txt_id.setText(null);
        txt_name.setText(null);
        txt_address.setText(null);
        txt_name.requestFocus();
    }

    private void save() {
        if (txt_name.getText().toString().isEmpty() ||
                txt_address.getText().toString().isEmpty()
        ) {
            Toast.makeText(getApplicationContext(), "Please input name or address ...",
                    Toast.LENGTH_SHORT).show();
        } else {
            SQLite.insert(txt_name.getText().toString().trim(), txt_address.getText().toString().trim());
            blank();
            finish();
        }
    }

    private void edit() {
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}