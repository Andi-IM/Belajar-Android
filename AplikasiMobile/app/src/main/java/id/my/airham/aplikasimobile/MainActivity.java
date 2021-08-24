package id.my.airham.aplikasimobile;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText TxtNama;
    TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TxtNama = (EditText) findViewById(R.id.TxtNama);
        Hasil = (TextView) findViewById(R.id.Lbl_Nama);
    }

    public void TampilNama(View view) {
        Hasil.setText("Nama Anda: " + TxtNama.getText());
    }
}