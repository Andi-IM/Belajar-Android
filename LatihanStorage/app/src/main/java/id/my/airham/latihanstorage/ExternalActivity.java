package id.my.airham.latihanstorage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ExternalActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FILENAME = "namafile.txt";
    private static final String TAG = ExternalActivity.class.getSimpleName();
    Button buatFile, ubahFile, bacaFile, deleteFile;
    TextView textBaca;
    ActivityResultLauncher<Intent> createInvoiceActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buatFile = findViewById(R.id.buttonBuatFileExt);
        ubahFile = findViewById(R.id.buttonUbahFileExt);
        bacaFile = findViewById(R.id.buttonBacaFileExt);
        deleteFile = findViewById(R.id.buttonHapusFileExt);
        textBaca = findViewById(R.id.textBacaExt);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        deleteFile.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void buatFile() {
        String isiFile = "Coba Isi Data File Text";
        String state = Environment.getExternalStorageState();

        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }

        FileOutputStream outputStream = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), FILENAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void ubahFile() {
        String ubah = "Update Isi Data File Text";
        String state = Environment.getExternalStorageState();

        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(ubah.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bacaFile() {
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard, FILENAME);
        Log.d("FILE_EXISTENCE", "bacaFile: " + file.exists());

        if (file.exists()) {
            Log.d("READ_FILE", "bacaFile: " + file.getAbsolutePath());
            StringBuilder text = new StringBuilder();

            try {
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                String line = buffer.readLine();

                while (line != null) {
                    text.append(line);
                    line = buffer.readLine();
                }
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            textBaca.setText(text.toString());
        }
    }

    private void hapusFile() {
        File file = new File(Environment.getExternalStorageDirectory(), FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public void onClick(View v) {
        jalankanPerintah(v.getId());
    }

    private void jalankanPerintah(int id) {
        switch (id) {
            case R.id.buttonBuatFileExt:
                buatFile();
                break;
            case R.id.buttonUbahFileExt:
                ubahFile();
                break;
            case R.id.buttonBacaFileExt:
                bacaFile();
                break;
            case R.id.buttonHapusFileExt:
                hapusFile();
                break;
            default:
                break;
        }
    }
}