package id.my.airham.tictac;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;
    String[] list = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
    List<String> alphabet = new ArrayList<>(Arrays.asList(list));
    Random rand = new Random();
    final int bound = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);

        acakHuruf();

        button1.setOnClickListener(v -> {
            button1.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button2.setOnClickListener(v -> {
            button2.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button3.setOnClickListener(v -> {
            button3.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button4.setOnClickListener(v -> {
            button4.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button5.setOnClickListener(v -> {
            button5.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button6.setOnClickListener(v -> {
            button6.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button7.setOnClickListener(v -> {
            button7.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button8.setOnClickListener(v -> {
            button8.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button9.setOnClickListener(v -> {
            button9.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button10.setOnClickListener(v -> {
            button10.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button11.setOnClickListener(v -> {
            button11.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button12.setOnClickListener(v -> {
            button12.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button13.setOnClickListener(v -> {
            button13.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button14.setOnClickListener(v -> {
            button14.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button15.setOnClickListener(v -> {
            button15.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });

        button16.setOnClickListener(v -> {
            button16.setText(alphabet.get(rand.nextInt(bound)));
            validasiHuruf();
        });
    }

    private void acakHuruf() {
        button1.setText(alphabet.get(rand.nextInt(bound)));
        button2.setText(alphabet.get(rand.nextInt(bound)));
        button3.setText(alphabet.get(rand.nextInt(bound)));
        button4.setText(alphabet.get(rand.nextInt(bound)));
        button5.setText(alphabet.get(rand.nextInt(bound)));
        button6.setText(alphabet.get(rand.nextInt(bound)));
        button7.setText(alphabet.get(rand.nextInt(bound)));
        button8.setText(alphabet.get(rand.nextInt(bound)));
        button9.setText(alphabet.get(rand.nextInt(bound)));
        button10.setText(alphabet.get(rand.nextInt(bound)));
        button11.setText(alphabet.get(rand.nextInt(bound)));
        button12.setText(alphabet.get(rand.nextInt(bound)));
        button13.setText(alphabet.get(rand.nextInt(bound)));
        button14.setText(alphabet.get(rand.nextInt(bound)));
        button15.setText(alphabet.get(rand.nextInt(bound)));
        button16.setText(alphabet.get(rand.nextInt(bound)));
    }

    private void validasiHuruf() {
        if (button1.getText() == alphabet.get(0) &&
                button2.getText() == alphabet.get(1) &&
                button3.getText() == alphabet.get(2) &&
                button4.getText() == alphabet.get(3) &&
                button5.getText() == alphabet.get(4) &&
                button6.getText() == alphabet.get(5) &&
                button7.getText() == alphabet.get(6) &&
                button8.getText() == alphabet.get(7) &&
                button9.getText() == alphabet.get(8) &&
                button10.getText() == alphabet.get(9) &&
                button11.getText() == alphabet.get(10) &&
                button12.getText() == alphabet.get(11) &&
                button13.getText() == alphabet.get(12) &&
                button14.getText() == alphabet.get(13) &&
                button15.getText() == alphabet.get(14) &&
                button16.getText() == alphabet.get(15)
        ) {
            Toast toast = Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.repeat_item){
            acakHuruf();
        } else if (item.getItemId() == R.id.exit_item){
            this.finish();
        }
        return true;
    }
}
