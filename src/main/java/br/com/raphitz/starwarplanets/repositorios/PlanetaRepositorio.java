package br.com.raphitz.starwarplanets.repositorios;

import br.com.raphitz.starwarplanets.models.Planeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanetaRepositorio implements IPlanetaRepositorio {

    @Autowired
    private PlanetaRepositorioSpringData repositorio;


    @Override
    public Planeta buscarPorIdPlaneta(String id) {
        return repositorio.findOne(id);
    }


    @Override
    public List<Planeta> buscarTodosPlanetas() {
        return repositorio.findAll();
    }

    @Override
    public String alterarPlaneta(String id, Planeta planetaAlterado) {

        String mensagem;

        try{
            planetaAlterado.set_id(id);
            repositorio.save(planetaAlterado);
            mensagem = "Planetas alterado com sucesso";

        }catch(Exception e){
            mensagem = "Planetas não alterado! Erro:" + e;
        }

        return mensagem;
    }

    @Override
    public String adicionar(Planeta novoPlaneta) {
        String mensagem;

        try{
            repositorio.insert(novoPlaneta);
            mensagem = "Planetas adicionado com sucesso com sucesso";

        }catch(Exception e){
            mensagem = "Planetas não criado! Erro:" + e;
        }

        return mensagem;
    }


    @Override
    public String removerPlaneta(String id) {
        String mensagem;

        try{
            Planeta planeta = repositorio.findOne(id);

            repositorio.delete(planeta);

            mensagem = "Planetas excluido com sucesso";

        }catch(Exception e){
            mensagem = "Planetas não excluido! Erro:" + e;
        }

        return mensagem;
    }

    @Override
    public List<Planeta> buscaPorNomePlaneta(String nomePlaneta) {
        return repositorio.findByNome(nomePlaneta);
    }

    interface PlanetaRepositorioSpringData extends MongoRepository<Planeta, String>{

        List<Planeta> findByNome(String nomePlaneta);

    }

}
