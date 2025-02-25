package com.adinhpo.repository;


import com.adinhpo.anime.entitys.Genero;

public interface GeneroRepository {
    Genero salvar(Genero genero);
    Genero pegarGenero(String id, Long malID);
//    Genero pegarGenero(Long malID);
    Boolean isExist(Long malID);
    Boolean existeAlgumGenero();
}
