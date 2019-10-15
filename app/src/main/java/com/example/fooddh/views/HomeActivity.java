package com.example.fooddh.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.fooddh.R;
import com.example.fooddh.adapters.RestauranteAdapter;
import com.example.fooddh.interfaces.RecycleViewOnClickRestaurante;
import com.example.fooddh.model.Prato;
import com.example.fooddh.model.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements RecycleViewOnClickRestaurante {

    private RecyclerView recyclerViewRestaurante;
    private RestauranteAdapter restauranteAdapter;
    public static final String CHAVE_RESTAURANTE = "restaurante";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        initViews();

        restauranteAdapter = new RestauranteAdapter(restaurantes(),this);
        recyclerViewRestaurante.setAdapter(restauranteAdapter);

        recyclerViewRestaurante.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initViews() {
        recyclerViewRestaurante = findViewById(R.id.recyclerView);

    }

    private List<Restaurante> restaurantes() {
        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante(R.drawable.imgrest,"Moema","Tony's","22:00",pratos()));
        restaurantes.add(new Restaurante(R.drawable.imgrest2,"Campo Belo","Ayoma","23:00",pratos()));
        restaurantes.add(new Restaurante(R.drawable.imgrest3,"Moema","Outback","00:00",pratos()));
        restaurantes.add(new Restaurante(R.drawable.imgrest4,"Moema","Frank and Charles","22:00",pratos()));

        return restaurantes;
    }

    private List<Prato> pratos(){
        List<Prato> pratoList = new ArrayList<>();
        pratoList.add(new Prato("Camarão salteados com molho de ervas",R.drawable.imgrest,"Camarôes rosas feitos no molho de ervas com manteiga glaceada acompanhado de legumes grelhados"));
        pratoList.add(new Prato("Sushis variados com peixe branco e salmão",R.drawable.imgrest2,"Sushi com salmão in natura e maçaricado"));
        pratoList.add(new Prato("Salada ranchito",R.drawable.imgrest3,"Mix de folhas com file de frango grelhado, queijo e tortilhas"));
        pratoList.add(new Prato("Panquecas",R.drawable.imgrest4,"Panquecas com calda de mel, mirtilos, framboesas e morangos"));

        return pratoList;
    }

    @Override
    public void onClick(Restaurante novoRestaurante) {
        Intent intent = new Intent(HomeActivity.this, RestauranteMenuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE_RESTAURANTE,novoRestaurante);
        intent.putExtra(CHAVE_RESTAURANTE, novoRestaurante);
        startActivity(intent);

    }

}
