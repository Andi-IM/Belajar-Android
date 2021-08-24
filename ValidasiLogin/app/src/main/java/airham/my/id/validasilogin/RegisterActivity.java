package airham.my.id.validasilogin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RegisterActivity extends AppCompatActivity {

    EditText editUsername, editPassword, editEmail, editNamaLengkap,
            editAsalSekolah, editAlamat;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Register");

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editEmail = findViewById(R.id.editEmail);
        editNamaLengkap = findViewById(R.id.editNamaLengkap);
        editAsalSekolah = findViewById(R.id.editAsalSekolah);
        editAlamat = findViewById(R.id.editAlamat);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(v -> {
            if (isValidation()) {
                simpanFileData();
            } else {
                Toast.makeText(RegisterActivity.this, "Mohon Lengkapi Seluruh Data", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void simpanFileData() {
        String isiFile = editUsername.getText().toString() + ";" +
                editPassword.getText().toString() + ";" +
                editEmail.getText().toString() + ";" +
                editNamaLengkap.getText().toString() + ";" +
                editAsalSekolah.getText().toString() + ";" +
                editAlamat.getText().toString();
        File file = new File(getFilesDir(), editUsername.getText().toString());

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    private boolean isValidation() {
        if (editUsername.getText().toString().equals("") ||
                editPassword.getText().toString().equals("") ||
                editEmail.getText().toString().equals("") ||
                editNamaLengkap.getText().toString().equals("") ||
                editAsalSekolah.getText().toString().equals("") ||
                editAlamat.getText().toString().equals("")
        ) {
            return false;
        }
        return false;
    }
}