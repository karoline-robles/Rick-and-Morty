package consumo.api.rickandmorty.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import consumo.api.rickandmorty.R;

import retrofit2.adapter.rxjava2.Result;

public class AdapterCharacters extends RecyclerView.Adapter<AdapterCharacters.ViewHolder> {
    private List<Result> resultList;

    public AdapterCharacters(List<Result> resultList) {
        this.resultList = resultList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rick_and_morty, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result result = resultList.get(position);
        holder.bind(result);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setUpdate(List<Result> results) {
        if (this.resultList.isEmpty()){
            this.resultList = results;
        }else {
            this.resultList.addAll(results);
        }
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txt_card);
            imageView = itemView.findViewById(R.id.imgCharacter_card);
        }
        public void bind(Result result){

        }
    }
}
