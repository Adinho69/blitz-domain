package com.adinhpo.anime.entitys;

import com.adinhpo.anime.enums.StatusTemporada;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Temporada {
    private final String id;
    private Long idReferencia;
    private Temporada temporadaAnterior;
    private Integer indice;
    private final List<Episodio> episodios;
    private StatusTemporada status;

    private Temporada(String id, Long idReferencia, Integer indice, Temporada temporadaAnterior, List<Episodio> episodios, StatusTemporada status) {
        this.id = Objects.requireNonNull(id);
        this.idReferencia = Objects.requireNonNull(idReferencia);
        this.temporadaAnterior = temporadaAnterior;
        this.indice = Objects.requireNonNull(indice);
        this.episodios = Objects.requireNonNull(episodios);
        this.validate();
        this.changeStatus(status);
    }

    public static Temporada criar(Integer indice, Long idReferencia, Temporada temporadaAnterior) {
        return new Temporada(
                UUID.randomUUID().toString(),
                idReferencia, indice,
                temporadaAnterior,
                new ArrayList<>(),
                StatusTemporada.AGUARDANDO
        );
    }

    public static Temporada pegar(
            String id, Integer indice, Long idReferencia, Temporada temporadaAnterior, List<Episodio> episodios, StatusTemporada status
    ) {
        return new Temporada(id, idReferencia, indice, temporadaAnterior, episodios, status);
    }

    private void validate() {
        if (id.isBlank() || id.isEmpty()) {
            throw new IllegalArgumentException("ID não pode ser vazia");
        }
        if (indice.compareTo(0) <= 0) {
            throw new IllegalArgumentException("Temporada deve ser um numero positivo");
        }
        if (this.idReferencia.compareTo(0L) <= 0) {
            throw new IllegalArgumentException("Temporada deve ser um numero positivo");
        }

    }

    public String id() {
        return id;
    }

    public Temporada temporadaAnterior() {
        return temporadaAnterior;
    }

    public Long idReferencia() {
        return idReferencia;
    }

    public Integer indice() {
        return indice;
    }

    public StatusTemporada status() {
        return status;
    }

    public void adicionarEpisodio(final Episodio episodio) {
        this.episodios.add(Objects.requireNonNull(episodio));
    }

    public void changeStatus(StatusTemporada status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Temporada{" +
                "id='" + id + '\'' +
                ", idReferencia=" + idReferencia +
                ", temporadaAnterior=" + temporadaAnterior +
                ", indice=" + indice +
                ", episodios=" + episodios +
                '}';
    }
}
