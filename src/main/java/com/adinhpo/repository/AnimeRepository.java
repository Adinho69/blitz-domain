package com.adinhpo.repository;


import com.adinhpo.anime.entitys.Anime;
import com.adinhpo.anime.entitys.Genero;
import com.adinhpo.anime.entitys.Temporada;

import java.util.List;
import java.util.Set;

public interface AnimeRepository {
    Anime salvar(Anime anime);
    void adicionarGenero(Anime anime, Set<Genero> genero);
    Anime adicionarTemporadas(Anime anime, List<Temporada> temporadas);
    Anime atualizar(Anime anime);
    Anime pegarPorID(String id);
    Anime pegarPorIDTemporada(String idTemporada);
    Anime atualizarAnime(Anime anime);
    Anime animeJaExistePorTemporada(Long temporadaID);
}
