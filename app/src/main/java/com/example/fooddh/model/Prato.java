package com.example.fooddh.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Prato implements Parcelable {

    private String nomeDoPrato;
    private int imagemPrato;
    private String descricaoPrato;

    public Prato() {
    }

    public Prato(String nomeDoPrato, int imagemPrato, String descricaoPrato) {
        this.nomeDoPrato= nomeDoPrato;
        this.imagemPrato = imagemPrato;
        this.descricaoPrato = descricaoPrato;
    }

    protected Prato(Parcel in) {
        nomeDoPrato = in.readString();
        imagemPrato = in.readInt();
        descricaoPrato = in.readString();
    }

    public static final Creator<Prato> CREATOR = new Creator<Prato>() {
        @Override
        public Prato createFromParcel(Parcel in) {
            return new Prato(in);
        }

        @Override
        public Prato[] newArray(int size) {
            return new Prato[size];
        }
    };

    public String getNomeDoPrato() {
        return nomeDoPrato;
    }

    public void setNomeDoPrato(String nomeDoPrato) {
        this.nomeDoPrato = nomeDoPrato;
    }

    public int getImagemPrato() {
        return imagemPrato;
    }

    public void setImagemPrato(int imagemPrato) {
        this.imagemPrato = imagemPrato;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricao) {
        this.descricaoPrato = descricaoPrato;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(nomeDoPrato);
        dest.writeInt(imagemPrato);
        dest.writeString(descricaoPrato);
    }
}
