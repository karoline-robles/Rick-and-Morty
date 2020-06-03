package consumo.api.rickandmorty.repository;

import consumo.api.rickandmorty.model.Characters;
import io.reactivex.Observable;

import static consumo.api.rickandmorty.network.ServiceRetrofit.getApiService;

public class CharacterRepository {
    public Observable <Characters> charactersObservable(){
        return getApiService().getCharactersResponse();
    }
}
