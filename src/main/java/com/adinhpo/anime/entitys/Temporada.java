package com.adinhpo.anime.entitys;

import com.adinhpo.anime.enums.StatusTemporada;
import com.adinhpo.anime.valueObjects.Images;

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
    private List<String> titulos;
    private Images imagens;

    private Temporada(String id, Long idReferencia, Integer indice, List<String> titulos, Temporada temporadaAnterior, List<Episodio> episodios, StatusTemporada status, Images imagens) {
        this.id = Objects.requireNonNull(id);
        this.idReferencia = Objects.requireNonNull(idReferencia);
        this.temporadaAnterior = temporadaAnterior;
        this.indice = Objects.requireNonNull(indice);
        this.episodios = Objects.requireNonNull(episodios);
        this.titulos = titulos;
        this.imagens = imagens;
        this.validate();
        this.changeStatus(status);
    }

    public static Temporada criar(Integer indice, Long idReferencia, Temporada temporadaAnterior, Images imagens) {
        return new Temporada(
                UUID.randomUUID().toString(),
                idReferencia, indice,
                new ArrayList<>(),
                temporadaAnterior,
                new ArrayList<>(),
                StatusTemporada.AGUARDANDO,
                imagens);
    }

    public static Temporada pegar(
            String id,
            Integer indice,
            Long idReferencia,
            List<String> titulos,
            Temporada temporadaAnterior,
            List<Episodio> episodios,
            StatusTemporada status,
            Images imagens
    ) {
        return new Temporada(id, idReferencia, indice, titulos, temporadaAnterior, episodios, status, imagens);
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

    public List<String> titulos() {
        return titulos;
    }

    public Images imagens() {
        return imagens;
    }

    public void adicionarEpisodio(final Episodio episodio) {
        this.episodios.add(Objects.requireNonNull(episodio));
    }

    public void changeStatus(StatusTemporada status) {
        this.status = status;
    }

    public Temporada adicionarTitulo(String titulo) {
        this.titulos.add(Objects.requireNonNull(titulo));
        return this;
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
