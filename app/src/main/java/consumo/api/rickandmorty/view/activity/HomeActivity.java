package consumo.api.rickandmorty.view.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import consumo.api.rickandmorty.R;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
    }

    private void initViews() {
        titulo = findViewById(R.id.titulo);
        recyclerView = findViewById(R.id.recyclerView);
    }
}
