package com.adinhpo.anime.entitys;

import com.adinhpo.anime.enums.StatusEpisodio;
import com.adinhpo.anime.valueObjects.Link;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Episodio {
    private final String id;
    private Long idReferencia;
    private boolean filler;
    private Double nota;
    private StatusEpisodio status;
    private List<Link> links;

    private Episodio(final String id, Long idReferencia, boolean filler, Double nota, StatusEpisodio status, List<Link> link) {
        this.id = Objects.requireNonNull(id);
        this.idReferencia = idReferencia;
        this.filler = filler;
        this.nota = Objects.requireNonNull(nota);
        this.links = link;
        this.alterarStatus(status);
    }


    public static Episodio criar(Long idReferencia, Boolean filler, Double nota) {
        return new Episodio(
                UUID.randomUUID().toString(),
                idReferencia,
                filler == null ? false : filler,
                nota,
                StatusEpisodio.AGUARDANDO,
                new ArrayList<>()
        );
    }

    public static Episodio pegar(String id, Long idReferencia, Boolean filler, Double nota, StatusEpisodio status, List<Link> link) {
        return new Episodio(
                id,
                idReferencia,
                filler,
                nota,
                status,
                link
        );
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

    public List<Link> link() {
        return links;
    }

    private void alterarStatus(StatusEpisodio status) {
        this.status = Objects.requireNonNull(status);
    }

    public void setLink(List<Link> link) {
        this.links = link;
    }

    public Episodio adicionar(final Link link) {
        this.links.add(Objects.requireNonNull(link));
        return this;
    }
}
