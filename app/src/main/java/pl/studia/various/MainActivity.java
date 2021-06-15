package pl.studia.various;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private ArrayList<Lista> data;
    private ArrayAdapter<Lista> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ////////////////////////////////////////////////

        //recyclerView
        listView = findViewById(R.id.listView);
        data = new ArrayList<>();
        data.add(new Lista(R.drawable.ic_back_key, getString(R.string.app_name), "Jakiś opis!"));

        adapter = new ListaTrzyAdapter(this, data);
        listView.setAdapter(adapter);
        /////////////////////////////////////////////////
    }
}