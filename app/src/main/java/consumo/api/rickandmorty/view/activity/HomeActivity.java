package consumo.api.rickandmorty.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import consumo.api.rickandmorty.R;
import consumo.api.rickandmorty.model.Result;
import consumo.api.rickandmorty.view.adapter.AdapterCharacters;
import consumo.api.rickandmorty.viewModel.CharactersViewModel;

public class HomeActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private CharactersViewModel charactersViewModel;
    private List<Result> results = new ArrayList<>();
    private AdapterCharacters  adapterCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapterCharacters);

        charactersViewModel.getListCharacters();

        charactersViewModel.listLiveData.observe(this, results1 -> adapterCharacters.setUpdate(results1));


    }

    public void initViews(){
        recyclerView = findViewById(R.id.recyclerView);
        charactersViewModel = ViewModelProviders.of(this).get(CharactersViewModel.class);
        adapterCharacters = new AdapterCharacters(results);
    }
}

