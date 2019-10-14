package com.example.fooddh.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddh.R;
import com.example.fooddh.interfaces.RecycleViewOnClickPrato;
import com.example.fooddh.model.Prato;

import java.util.List;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.ViewHolder>  {

    private List<Prato> listPratos;
    private RecycleViewOnClickPrato listener;

    public PratoAdapter(List<Prato> listPratos, RecycleViewOnClickPrato listener){
        this.listPratos = listPratos;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prato, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PratoAdapter.ViewHolder holder, int position) {
        final Prato prato = listPratos.get(position);
        holder.bind(prato);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(prato);
            }
        });

    }

    @Override
    public int getItemCount() { return listPratos.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeDoPrato;
        private ImageView imgPrato;


        public ViewHolder(View itemView) {
            super(itemView);

            nomeDoPrato = itemView.findViewById(R.id.nomeDoPrato);
            imgPrato = itemView.findViewById(R.id.imagemPrato);

        }

        public void bind(Prato prato) {

            Drawable drawable = imgPrato.getResources().getDrawable(prato.getImagemPrato());
            imgPrato.setImageDrawable(drawable);
            nomeDoPrato.setText(prato.getNomeDoPrato());

        }
    }
}
