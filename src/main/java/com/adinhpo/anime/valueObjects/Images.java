package com.adinhpo.anime.valueObjects;


public class Images {
    private String larga;
    private String pequena;
    private String media;

    public Images() {
    }

    public Images(String larga, String media, String pequena) {
        this.larga = larga;
        this.pequena = pequena;
        this.media = media;
    }

    public String larga() {
        return larga;
    }

    public void setLarga(String larga) {
        this.larga = larga;
    }

    public String pequena() {
        return pequena;
    }

    public void setPequena(String pequena) {
        this.pequena = pequena;
    }

    public String media() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
}
