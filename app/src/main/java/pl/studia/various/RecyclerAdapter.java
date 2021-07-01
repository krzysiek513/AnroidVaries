package pl.studia.various;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{


    Context context;
    List<Lista> itemList;

    public RecyclerAdapter(Context context, List<Lista> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        Lista itemModel = itemList.get(position);
        holder.name.setText("name" + itemModel.getNameId());
        holder.opis.setText("description" + itemModel.getOpisId());

        String imageUrl = null;
        imageUrl = itemModel.getListNameId();
        Picasso.get().load(imageUrl).into(holder.image);

//        holder.image.setImageResource(data.get(position).getListNameId());
//        holder.name.setText(data.get(position).getNameId());
//        holder.opis.setText(data.get(position).getOpisId());

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "cicked " + data.get(position).getNameId(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView opis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.recIv);
            name = itemView.findViewById(R.id.recTv1);
            opis = itemView.findViewById(R.id.recTv2);
        }

    }

}
