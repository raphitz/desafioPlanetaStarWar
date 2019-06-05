package br.com.raphitz.starwarplanets.controllers;

import br.com.raphitz.starwarplanets.exceptions.PlanetaNaoLocalizadoSwapiException;
import br.com.raphitz.starwarplanets.models.Planeta;
import br.com.raphitz.starwarplanets.services.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @RequestMapping(value = "/planetas", method = RequestMethod.GET)
    public Iterable<Planeta>getTodosPlanetas() {
        return planetaService.todosPlanetas();
    }

    @ResponseBody
    @RequestMapping(value = "/planetas/{id}", method = RequestMethod.GET)
    public Planeta getPlanetaById(@PathVariable("id") final String id) {
        final Planeta planetaPorId = planetaService.planetaById(id);
        return planetaPorId;
    }

    @RequestMapping(value = "/planetas/adicionarPlaneta", method = RequestMethod.POST)
    public String addPlaneta(@Valid  @RequestBody Planeta planeta) throws PlanetaNaoLocalizadoSwapiException {
        return planetaService.novoPlaneta(planeta);
    }

    @RequestMapping(value = "/planetas/alterarPlaneta/{id}", method = RequestMethod.PUT)
    public String updatePlaneta(@PathVariable String id, @RequestBody Planeta planeta){

        return planetaService.updatePlaneta(id, planeta);
    }

    @RequestMapping(value = "/planetas/deletarPlaneta/{id}", method = RequestMethod.DELETE)
    public String deletarPlaneta(@PathVariable String id){
        return planetaService.deletarPlaneta(id);
    }





}

