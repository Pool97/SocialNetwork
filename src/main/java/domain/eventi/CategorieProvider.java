package domain.eventi;

import domain.model.Categoria;

import java.util.List;

public interface CategorieProvider {
    List<String> getCategorie();
    Categoria getCategoria(String nome);
}
