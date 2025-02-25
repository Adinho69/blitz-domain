package com.adinhpo.anime.entitys;


import com.adinhpo.IDGenerator;

import java.util.Objects;

public class Genero {
    private final String id;
    private final Long malID;
    private String descricao;

    private Genero(String id, Long malID, String descricao) {
        this.id = Objects.requireNonNull(id);
        this.malID = Objects.requireNonNull(malID);
        this.descricao = Objects.requireNonNull(descricao);
        this.validate();
    }

    public static Genero criar(
            final Long idReferencia, String descricao
    ){
        return new Genero(
                IDGenerator.gerarProximoId(),
                idReferencia,
                descricao
        );
    }

    public static Genero pegar(
            final String id, Long idReferencia, String descricao
    ){
        return new Genero(
                id,
                idReferencia,
                descricao
        );
    }

    public String id() {
        return id;
    }

    public Long malID() {
        return malID;
    }

    public String descricao() {
        return descricao;
    }

    private void validate() {
        if(this.id.isEmpty() || this.id.isBlank()){
            throw new IllegalArgumentException("");
        }
        if(this.malID.compareTo(Long.valueOf(0))<=0){
            throw new IllegalArgumentException("ID de referencia deve ser maior que zero");
        }
        if(this.descricao.isEmpty() || this.descricao.isBlank()){
            throw new IllegalArgumentException("");
        }
    }
}
