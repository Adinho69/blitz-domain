package com.adinhpo.anime.entitys;

import java.util.Objects;
import java.util.UUID;

public class Episodio {
    private final String id;
    private Long idReferencia;
    private boolean filler;
    private Double nota;

    private Episodio(final String id, Long idReferencia, boolean filler, Double nota) {
        this.id = Objects.requireNonNull(id);
        this.idReferencia = idReferencia;
        this.filler = filler;
        this.nota = Objects.requireNonNull(nota);
    }

    public static Episodio criar(Long idReferencia, Boolean filler, Double nota) {
        return new Episodio(
                UUID.randomUUID().toString(),
                idReferencia,
                filler == null ? false : filler,
                nota
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
}
