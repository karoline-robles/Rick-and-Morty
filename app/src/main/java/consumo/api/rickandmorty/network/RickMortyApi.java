package consumo.api.rickandmorty.network;

import consumo.api.rickandmorty.model.Characters;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RickMortyApi {
    @GET("character")
    Observable<Characters> getCharactersResponse();
}
