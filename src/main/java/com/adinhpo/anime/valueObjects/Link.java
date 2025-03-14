package com.adinhpo.anime.valueObjects;

import com.adinhpo.anime.enums.Linguagem;

import java.util.Objects;

public class Link {

    private String url;
    private Linguagem linguagem;

    public Link(String url, Linguagem linguagem) {
        this.setUrl(url);
        this.setLinguagem(linguagem);
    }

    public String url() {
        return url;
    }

    public void setUrl(String url) {
        this.url = Objects.requireNonNull(url);
        if (this.url.isBlank() || this.url.isEmpty()) {
            throw new IllegalArgumentException("url não pode ser nula");
        }
    }

    public Linguagem linguagem() {
        return linguagem;
    }

    public void setLinguagem(Linguagem linguagem) {
        this.linguagem = Objects.requireNonNull(linguagem);
    }
}
