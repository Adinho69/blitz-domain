package com.adinhpo.anime.entitys;


import com.adinhpo.IDGenerator;
import com.adinhpo.anime.valueObjects.Images;
import com.adinhpo.execptions.NegocioExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Anime {
    private String id;
    private String descricao;
    private String descricaoAlternativa;
    private Double nota;
    private String sinopse;
    private Boolean pronto;
    private Boolean temporadasCompletas;
    private Boolean emLancamento;
    private Boolean processado;
    private Images imagens;
    private List<Genero> generos;
    private List<Temporada> temporadas = new ArrayList<>();

    private Anime(String id, String descricao, String descricaoAlternativa, Double nota, String sinopse) {
        this.id = Objects.requireNonNull(id);
        this.descricao = Objects.requireNonNull(descricao);
        this.descricaoAlternativa = Objects.requireNonNull(descricaoAlternativa);
        this.nota = Objects.requireNonNull(nota);
        this.sinopse = Objects.requireNonNull(sinopse);
        this.pronto = Boolean.FALSE;
        this.temporadasCompletas = Boolean.FALSE;
        this.emLancamento = Boolean.FALSE;
        this.processado = Boolean.FALSE;
        this.validate();
    }


    public Anime(String id, String descricao, String descricaoAlternativa, Double nota, String sinopse, Boolean pronto, Boolean temporadasCompletas, Boolean emLancamento, Boolean processado) {
        this.id = Objects.requireNonNull(id);
        this.descricao = Objects.requireNonNull(descricao);
        this.descricaoAlternativa = Objects.requireNonNull(descricaoAlternativa);
        this.nota = Objects.requireNonNull(nota);
        this.sinopse = Objects.requireNonNull(sinopse);
        this.pronto = Objects.requireNonNull(pronto);
        this.temporadasCompletas = Objects.requireNonNull(temporadasCompletas);
        this.emLancamento = Objects.requireNonNull(emLancamento);
        this.processado = Objects.requireNonNull(processado);
        this.validate();
    }

    public static Anime criar(
            String descricao, String descricaoAlternativa, Double nota, String sinopse
    ) {
        return new Anime(
                IDGenerator.gerarProximoId(),
                descricao,
                descricaoAlternativa,
                nota,
                sinopse
        );
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDescricaoAlternativa() {
        return descricaoAlternativa;
    }

    public Double getNota() {
        return nota;
    }

    public String getSinopse() {
        return sinopse;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public Boolean getPronto() {
        return pronto;
    }

    public Boolean getTemporadasCompletas() {
        return temporadasCompletas;
    }

    public Boolean getEmLancamento() {
        return emLancamento;
    }

    public Boolean getProcessado() {
        return processado;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public Images getImagens() {
        return imagens;
    }

    public void alterarGenero(List<Genero> genero) {
        this.generos = Objects.requireNonNull(genero);
        if (this.generos.isEmpty()) {
            throw new IllegalArgumentException("A lista de generos não pode ser vazia");
        }
    }

    public void despacharParaCatalogo() {
        if (generos.isEmpty()) {
            throw new NegocioExeption("Anime não pode ser despachado para o catalogo sem generos");
        }
        this.pronto = Boolean.TRUE;
    }

    public Anime adicionarTemporada(final Temporada temporada) {
        this.temporadas.add(Objects.requireNonNull(temporada));
        return this;
    }

    public void completarAnime() {
        this.temporadasCompletas = Boolean.TRUE;
    }

    public void concluirProcessamento() {
        this.processado = Boolean.TRUE;
    }

    public void setImagens(final Images imagens) {
        this.imagens = Objects.requireNonNull(imagens);
    }

    private void validate() {
        if (this.id.isEmpty() || this.id.isBlank()) {
            throw new IllegalArgumentException("Id não pode ser vazio");
        }
        if (this.nota.compareTo(Double.valueOf(0)) <= 0) {
            throw new IllegalArgumentException("Nota deve ser maior que zero");
        }
//        if(this.temporadas != null){
//            throw new IllegalArgumentException("Nota deve ser maior que zero");
//        }

    }

    @Override
    public String toString() {
        return "Anime{" +
                "id='" + id + '\'' +
                ", descricao='" + descricao + '\'' +
                ", descricaoAlternativa='" + descricaoAlternativa + '\'' +
                ", nota=" + nota +
                ", sinopse='" + sinopse + '\'' +
                ", pronto=" + pronto +
                ", temporadasCompletas=" + temporadasCompletas +
                ", emLancamento=" + emLancamento +
                ", processado=" + processado +
                ", generos=" + generos +
                ", temporadas=" + temporadas.toString() +
                '}';
    }
}