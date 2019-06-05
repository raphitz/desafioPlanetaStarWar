package br.com.raphitz.starwarplanets.repositorios;

import br.com.raphitz.starwarplanets.models.Planeta;

import java.util.List;

public interface IPlanetaRepositorio{

    Planeta buscarPorIdPlaneta(String id);

    List<Planeta> buscarTodosPlanetas();

    String alterarPlaneta(String id, Planeta planetaAlterado);

    String adicionar(Planeta novoPlaneta);

    String removerPlaneta(String id);

    List<Planeta> buscaPorNomePlaneta(String nome);

}
