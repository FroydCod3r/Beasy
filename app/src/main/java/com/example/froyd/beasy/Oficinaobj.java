package com.example.froyd.beasy;

public class Oficinaobj {
    public String id;
    public String nome;
    public String descricao;
    public String distancia;
    public String horario;
    public String urlimg;
    public String imgrating;

    public float lat;
    public float lon;


    public Oficinaobj(String id, String nome, String descricao, String horario, float rating, float lat, float lon){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.horario = horario;
        this.urlimg = id;


        if (rating<=1)
            this.imgrating = "onestar";
        else if (rating >= 1 || rating <=2)
            this.imgrating= "twostar";

        else if (rating >= 2 || rating <=3)
            this.imgrating= "threestar";

        else if (rating >= 3 || rating <=4)
            this.imgrating= "fourstar";

        else if (rating >= 4 || rating <=5)
            this.imgrating= "fivestar";

        else
            this.imgrating= "erro_img_rating";




        this.distancia = "10 km";

        this.lat = lat;
        this.lon = lon;

    }

    public float getLat() {
        return lat;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getLon() {
        return lon;
    }

    public String getDistancia() {
        return distancia;
    }

    public String getHorario() {
        return horario;
    }

    public String getId() {
        return id;
    }

    public String getImgrating() {
        return imgrating;
    }

    public String getNome() {
        return nome;
    }

    public String getUrlimg() {
        return urlimg;
    }

}
