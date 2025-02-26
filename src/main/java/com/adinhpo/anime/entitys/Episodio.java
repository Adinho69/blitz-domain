package com.adinhpo.anime.entitys;

import com.adinhpo.anime.enums.StatusEpisodio;

import java.util.Objects;
import java.util.UUID;

public class Episodio {
    private final String id;
    private Long idReferencia;
    private boolean filler;
    private Double nota;
    private StatusEpisodio status;
    private String link;

    private Episodio(final String id, Long idReferencia, boolean filler, Double nota, StatusEpisodio status, String link) {
        this.id = Objects.requireNonNull(id);
        this.idReferencia = idReferencia;
        this.filler = filler;
        this.nota = Objects.requireNonNull(nota);
        this.link = link;
        this.alterarStatus(status);
    }


    public static Episodio criar(Long idReferencia, Boolean filler, Double nota, String link) {
        return new Episodio(
                UUID.randomUUID().toString(),
                idReferencia,
                filler == null ? false : filler,
                nota,
                StatusEpisodio.AGUARDANDO,
                link);
    }

    public static Episodio pegar(String id, Long idReferencia, Boolean filler, Double nota, StatusEpisodio status, String link) {
        return new Episodio(
                id,
                idReferencia,
                filler,
                nota,
                status,
                link);
    }


    public String id() {
        return id;
    }

    public Long idReferencia() {
        return idReferencia;
    }

    public boolean filler() {
        return filler;
    }

    public Double nota() {
        return nota;
    }

    public StatusEpisodio status() {
        return status;
    }

    public String link() {
        return link;
    }

    private void alterarStatus(StatusEpisodio status) {
        this.status = Objects.requireNonNull(status);
    }

    public void setLink(String link) {
        this.link = link;
    }
}
