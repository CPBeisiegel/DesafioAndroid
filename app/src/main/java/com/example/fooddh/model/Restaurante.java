package com.example.fooddh.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Restaurante implements Parcelable {

    private int imagemRestaurante;
    private String nomeRestaurante;
    private String enderecoRestaurante;
    private String horarioDeFechamento;
    private List<Prato> listPratos;


    public Restaurante() {
    }


    public Restaurante(String nomeRestaurante, String enderecoRestaurante, int imagemRestaurante, String horarioDeFechamento, List<Prato> listPratos) {
        this.nomeRestaurante = nomeRestaurante;
        this.enderecoRestaurante = enderecoRestaurante;
        this.imagemRestaurante = imagemRestaurante;
        this.horarioDeFechamento = horarioDeFechamento;
        this.listPratos = listPratos;
    }


    protected Restaurante(Parcel in) {
        nomeRestaurante= in.readString();
        enderecoRestaurante = in.readString();
        imagemRestaurante = in.readInt();
        horarioDeFechamento = in.readString();
        listPratos = in.createTypedArrayList(Prato.CREATOR);
    }

    public static final Creator<Restaurante> CREATOR = new Creator<Restaurante>() {
        @Override
        public Restaurante createFromParcel(Parcel in) {
            return new Restaurante(in);
        }

        @Override
        public Restaurante[] newArray(int size) {
            return new Restaurante[size];
        }
    };

    public Restaurante(int imgrest, String enderecoRestaurante, String nomeRestaurante, String horarioDeFechamento, List<Prato> pratos) {
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getEnderecoRestaurante() {
        return enderecoRestaurante;
    }

    public void setEnderecoRestaurante(String enderecoRestaurante) {
        this.enderecoRestaurante = enderecoRestaurante;
    }

    public int getImagemRestaurante() {
        return imagemRestaurante;
    }

    public void setImagemRestaurante(int imagemRestaurante) {
        this.imagemRestaurante = imagemRestaurante;
    }

    public String getHorarioDeFechamento() {
        return horarioDeFechamento;
    }

    public void setHorarioDeFechamento(String horarioDeFechamento) {
        this.horarioDeFechamento = horarioDeFechamento;
    }

    public List<Prato> getListPratos() {
        return listPratos;
    }

    public void setCardapio(List<Prato> listPratos) {
        this.listPratos = listPratos;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {

        dest.writeString(nomeRestaurante);
        dest.writeString(enderecoRestaurante);
        dest.writeInt(imagemRestaurante);
        dest.writeString(horarioDeFechamento);
        dest.writeTypedList(listPratos);

    }
}
