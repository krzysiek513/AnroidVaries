package pl.studia.various;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentB extends Fragment {


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
        return view;
    }
}