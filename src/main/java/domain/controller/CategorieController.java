package domain.controller;

import domain.model.Categoria;
import integration.CategoriePersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategorieController {
    private List<Categoria> categorie;
    private CategoriePersistence repository;

    public CategorieController(){
        repository = new CategoriePersistence();
        categorie = repository.deserializza();
    }

    public List<String> getCategorie() {
        return categorie.stream().map(Categoria::getNome)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Categoria getCategoria(String nome){
        return categorie.stream().filter(categoria -> categoria.getNome().equals(nome)).findFirst().get();
    }
}

