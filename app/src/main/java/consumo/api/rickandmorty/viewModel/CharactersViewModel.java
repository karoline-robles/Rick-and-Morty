package consumo.api.rickandmorty.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import consumo.api.rickandmorty.model.Result;
import consumo.api.rickandmorty.repository.CharacterRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CharactersViewModel extends ViewModel {
    private MutableLiveData<List<Result>> listMutableLiveData = new MutableLiveData<>();
    public LiveData<List<Result>> listLiveData = listMutableLiveData;
    private CompositeDisposable disposable = new CompositeDisposable();
    private CharacterRepository respository = new CharacterRepository();
    private MutableLiveData<String> mutableLiveDataErro = new MutableLiveData<>();
    public LiveData<String> liveDataErro = mutableLiveDataErro;

    public void getListCharacters() {
        disposable.add(
                respository.charactersObservable()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(sportsResult ->
                                listMutableLiveData.setValue(sportsResult.getResults()), throwable -> {
                            mutableLiveDataErro.setValue(throwable.getMessage());
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}