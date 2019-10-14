package com.example.fooddh.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fooddh.R;
import com.example.fooddh.adapters.PratoAdapter;
import com.example.fooddh.interfaces.RecycleViewOnClickPrato;
import com.example.fooddh.model.Prato;
import com.example.fooddh.model.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class RestauranteMenuActivity extends AppCompatActivity implements RecycleViewOnClickPrato {

    private static final String CHAVE_PRATO = "prato";
    private ImageView imagemRestaurante;
    private TextView nomeRestaurante;
    private List<Prato> listPrato = new ArrayList<>();
    private RecyclerView recyclerViewPratos;
    private PratoAdapter pratoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantemenu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {

//            Restaurante restaurante = getIntent().getExtras().getParcelable();
//
//            Drawable drawable = getResources().getDrawable(restaurante.getImagemRestaurante());
//            imagemRestaurante.setImageDrawable(drawable);
//            nomeRestaurante.setText(restaurante.getNomeRestaurante());
//            listPrato = restaurante.getListPratos();
//            pratoAdapter = new PratoAdapter(listPrato,this);
//
//            recyclerViewPratos.setAdapter(pratoAdapter);
//            recyclerViewPratos.setLayoutManager(new LinearLayout);


        }

    }

    private void initViews() {
    }

    @Override
    public void onClick(Prato prato) {

    }
}


