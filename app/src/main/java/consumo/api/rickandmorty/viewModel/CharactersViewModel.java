package consumo.api.rickandmorty.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import consumo.api.rickandmorty.model.Result;
import consumo.api.rickandmorty.repository.CharacterRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CharactersViewModel  extends AndroidViewModel {
    private MutableLiveData<List<Result>> listMutableLiveData = new MutableLiveData<>();
    public LiveData<List<Result>> listLiveData = listMutableLiveData;
    private CompositeDisposable disposable = new CompositeDisposable();
    private CharacterRepository respository = new CharacterRepository();

    public CharactersViewModel(@NonNull Application application) {
        super(application);
    }

    public void getListCharacters() {
        disposable.add(
                respository.charactersObservable()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(charactersResponse -> listMutableLiveData.setValue(charactersResponse.getResults()),
                                throwable -> Log.i("LOG", "MESSAGE -> " + throwable.getMessage()))
        );
    }
}