package pl.studia.various;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaTrzyAdapter extends ArrayAdapter<Lista> {

    private ArrayList<Lista> data;
    private Context context;

    public ListaTrzyAdapter(Context context, ArrayList<Lista> data) {
        super(context, R.layout.list);
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ListHolder holder = null;

        if(row == null) {
            LayoutInflater inflater =((Activity) context).getLayoutInflater();
            row = inflater.inflate(R.layout.list, null);

            holder = new ListHolder();
            holder.image = row.findViewById(R.id.listIv);
            holder.name = row.findViewById(R.id.listTv1);
            holder.opis = row.findViewById(R.id.listTv2);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        Lista list = data.get(position);
        holder.image.setImageResource(list.getListNameId());
        holder.name.setText(list.getNameId());
        holder.opis.setText(list.getOpisId());

        return row;
    }

    static class ListHolder {
        ImageView image;
        TextView name;
        TextView opis;
    }
}
