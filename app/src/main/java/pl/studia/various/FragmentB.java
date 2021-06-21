package pl.studia.various;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;


public class FragmentB extends Fragment implements RecyclerAdapter.OnListener {

    RecyclerView recyclerView;
    ArrayList<Lista> data = new ArrayList<>();
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    View view;
    Button fragmentBtn;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_b, container, false);
        fragmentBtn  = view.findViewById(R.id.fragmentBBtn);
        editText = view.findViewById(R.id.fragmentBEt);
        fragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("fragment B clicked");
            }
        });

        recyclerView = view.findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        data.add(new Lista(R.drawable.cos, "cos", "dafdsfdf"));

        adapter = new RecyclerAdapter(data, this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onListener(int position) {
        data.get(position);
        Toast.makeText(getContext(), "cicked fragment", Toast.LENGTH_LONG).show();
    }
}