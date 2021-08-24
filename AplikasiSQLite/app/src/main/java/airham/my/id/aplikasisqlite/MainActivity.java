package airham.my.id.aplikasisqlite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import airham.my.id.aplikasisqlite.adapter.Adapter;
import airham.my.id.aplikasisqlite.helper.DbHelper;
import airham.my.id.aplikasisqlite.model.Data;

public class MainActivity extends AppCompatActivity {
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_ADDRESS = "address";
    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> itemList = new ArrayList<>();
    Adapter adapter;
    DbHelper SQLite = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLite = new DbHelper(getApplicationContext());
        FloatingActionButton fab = findViewById(R.id.fab);
        listView = findViewById(R.id.list_item);

        fab.setOnClickListener(v -> {
            startActivity(new Intent(this, AddEditActivity.class));
        });

        adapter = new Adapter(this, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            final String idx = itemList.get(position).getId();
            final String name = itemList.get(position).getName();
            final String address = itemList.get(position).getAddress();

            final CharSequence[] dialogItem = {"Edit", "Delete"};
            dialog = new AlertDialog.Builder(this);
            dialog.setCancelable(true);
            dialog.setItems(dialogItem, (dialog, which) -> {
                switch (which) {
                    case 0:
                        Intent intent = new Intent(this, AddEditActivity.class);
                        intent.putExtra(TAG_ID, idx);
                        intent.putExtra(TAG_NAME, name);
                        intent.putExtra(TAG_ADDRESS, address);
                        startActivity(intent);
                        break;
                    case 1:
                        SQLite.delete((int) id);
                        itemList.clear();
                        getAllData();
                        break;
                }
            }).show();
            return false;
        });
        getAllData();
    }

    public void getAllData() {
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();

        for (int i = 0; i < row.size(); i++) {
            String id = row.get(i).get(TAG_ID);
            String poster = row.get(i).get(TAG_NAME);
            String title = row.get(i).get(TAG_NAME);

            Data data = new Data();

            data.setId(id);
            data.setName(poster);
            data.setAddress(title);

            itemList.add(data);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemList.clear();
        getAllData();
    }
}