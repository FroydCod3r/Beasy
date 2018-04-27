package com.example.froyd.beasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Oficinaadapter extends ArrayAdapter<Oficinaobj> {
    private final Context context;
    private final ArrayList<Oficinaobj> elementos;


    public Oficinaadapter(Context context, ArrayList<Oficinaobj> elementos){
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.nome);
        TextView descricao = (TextView) rowView.findViewById(R.id.descricao);
        TextView distancia = (TextView) rowView.findViewById(R.id.distancia);
        TextView horario = (TextView) rowView.findViewById(R.id.horario);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);
        ImageView imgavaliacao = (ImageView) rowView.findViewById(R.id.imgavaliacao);
        return  rowView;



    }
}
