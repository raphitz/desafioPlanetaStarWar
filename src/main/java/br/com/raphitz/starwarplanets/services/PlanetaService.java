package br.com.raphitz.starwarplanets.services;

import br.com.raphitz.starwarplanets.exceptions.NomeDuplicadoException;
import br.com.raphitz.starwarplanets.exceptions.PlanetaNaoLocalizadoException;
import br.com.raphitz.starwarplanets.exceptions.PlanetaNaoLocalizadoSwapiException;
import br.com.raphitz.starwarplanets.models.Planeta;
import br.com.raphitz.starwarplanets.models.SwapiRetornoApi;
import br.com.raphitz.starwarplanets.repositorios.PlanetaRepositorio;
import br.com.raphitz.starwarplanets.util.Mensagens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Service
public class PlanetaService implements IPlanetaService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Mensagens mensagens;


    @Autowired
    private PlanetaRepositorio repository;

    @Autowired
    private SwapiApiService swapiService;



    public Iterable<Planeta> todosPlanetas(){

        return repository.buscarTodosPlanetas();

    }


    public Planeta planetaById(String id) {

        return repository.buscarPorIdPlaneta(id);
    }

    @Override
    public String novoPlaneta(Planeta planeta) throws RestClientException, PlanetaNaoLocalizadoException, PlanetaNaoLocalizadoSwapiException {

        String mensagem = "";

        SwapiRetornoApi swapiPlaneta = swapiService.getPlanetaSwapi(planeta.getNome());

        List<Planeta> planetas = repository.buscaPorNomePlaneta(planeta.getNome());

        //jogar num validator
        if(planetas.size() > 0){
            Planeta p = planetas.get(0);
            throw new NomeDuplicadoException(mensagens.nomeDuplicado(p.getNome(),p.get_id()));
        }


        planeta.setQtdAparicoes(swapiPlaneta.numeroDeAparicoes());

        try{
            if(swapiPlaneta != null){

                Planeta p = new Planeta();
                p.setNome(swapiPlaneta.getNome());
                p.setClima(swapiPlaneta.getClima());
                p.setTerreno(swapiPlaneta.getTerreno());
                p.setQtdAparicoes(swapiPlaneta.getQtdAparicoes());

                repository.adicionar(p);
            }else{
                repository.adicionar(planeta);
            }

            mensagem = "Criado com sucesso";
        }catch (Exception e) {
            mensagem = e + "Erro ao Salvar";
        }finally {
            return mensagem;
        }
    }

    @Override
    public String updatePlaneta(String id, Planeta planeta) {

        final Planeta planetaOriginal = planetaById(id);

        //jogar num validator
        if (planeta.getNome() != null) {
            planetaOriginal.setNome(planeta.getNome());

            //verifica se planeta existe no swapi.co
            //caso sim... pegar a quantidade de vezes que o mesmo aparece nos filmes

        }

        if (planeta.getClima() != null) {
            planetaOriginal.setClima(planeta.getClima());
        }

        if (planeta.getTerreno() != null) {
            planetaOriginal.setTerreno(planeta.getTerreno());
        }

        return repository.alterarPlaneta(id, planetaOriginal);

    }

    @Override
    public String deletarPlaneta(String id) {
        return repository.removerPlaneta(id);
    }


}
