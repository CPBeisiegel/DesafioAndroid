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
import com.example.fooddh.interfaces.RecycleViewOnClickRestaurante;
import com.example.fooddh.model.Restaurante;

import java.util.List;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {

    private List<Restaurante> listaRestaurante;
    private RecycleViewOnClickRestaurante listener;

    public RestauranteAdapter(List<Restaurante> listaRestaurante, RecycleViewOnClickRestaurante listener) {
        this.listaRestaurante = listaRestaurante;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RestauranteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestauranteAdapter.ViewHolder viewHolder, int position) {
        final Restaurante novoRestaurante = listaRestaurante.get(position);
        viewHolder.bind(novoRestaurante);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(novoRestaurante);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaRestaurante.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagemRestaurante;
        private TextView nomeRestaurante;
        private TextView enderecoRestaurante;
        private TextView horarioDeFechamento;


        public ViewHolder(View itemView) {
            super(itemView);

            imagemRestaurante = itemView.findViewById(R.id.imagemRestaurante);
            nomeRestaurante = itemView.findViewById(R.id.nomeRestaurante);
            enderecoRestaurante = itemView.findViewById(R.id.enderecoRestaurante);
            horarioDeFechamento = itemView.findViewById(R.id.horarioFuncionamento);
        }

        public void bind(Restaurante novoRestaurante) {

            Drawable drawable = itemView.getResources().getDrawable(novoRestaurante.getImagemRestaurante());
            imagemRestaurante.setImageDrawable(drawable);
            nomeRestaurante.setText(novoRestaurante.getNomeRestaurante());
            enderecoRestaurante.setText(novoRestaurante.getEnderecoRestaurante());
            horarioDeFechamento.setText(novoRestaurante.getHorarioDeFechamento());

        }
    }
}
