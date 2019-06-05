package br.com.raphitz.starwarplanets.services;

import br.com.raphitz.starwarplanets.exceptions.PlanetaNaoLocalizadoSwapiException;
import br.com.raphitz.starwarplanets.models.SwapiEnvioApi;
import br.com.raphitz.starwarplanets.models.SwapiRetornoApi;
import br.com.raphitz.starwarplanets.util.Mensagens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class SwapiApiService implements ISwapiApiService {

        private final Logger log = LoggerFactory.getLogger(this.getClass());

        @Autowired
        private Mensagens mensagens;

        @Autowired
        private RestTemplate restTemplate;


        public SwapiRetornoApi getPlanetaSwapi(String planeta) throws  RestClientException, PlanetaNaoLocalizadoSwapiException {

                String url = "https://swapi.co/api/planets?search=" + planeta;

                SwapiEnvioApi swapiEnvioApi = restTemplate.getForObject(url, SwapiEnvioApi.class);

                if(swapiEnvioApi.getContagem() == 0){
                        throw new PlanetaNaoLocalizadoSwapiException(mensagens.nomeNaoExisteSwapi(planeta));
                }



                for(SwapiRetornoApi splanet: swapiEnvioApi.getResultados()){
                        if(splanet.getNome().equals(planeta)){
                                return splanet;
                        }
                }

                throw new PlanetaNaoLocalizadoSwapiException(mensagens.nomeNaoExisteSwapi(planeta));




        }




}
