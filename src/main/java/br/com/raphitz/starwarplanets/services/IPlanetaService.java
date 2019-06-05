package br.com.raphitz.starwarplanets.services;

import br.com.raphitz.starwarplanets.exceptions.PlanetaNaoLocalizadoSwapiException;
import br.com.raphitz.starwarplanets.models.Planeta;

public interface IPlanetaService {

     Iterable<Planeta> todosPlanetas();

     Planeta planetaById(String id);

     String novoPlaneta(Planeta planeta) throws PlanetaNaoLocalizadoSwapiException;

     String updatePlaneta(String id, Planeta planeta);

     String deletarPlaneta(String id);
}


