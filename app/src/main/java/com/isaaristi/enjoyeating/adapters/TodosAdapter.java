package com.isaaristi.enjoyeating.adapters;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.databinding.TemplateRestauranteBinding;
import com.isaaristi.enjoyeating.modelos.Restaurante;

import java.util.List;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodosHolder>{

    LayoutInflater inflater;
    List<Restaurante> data;

    public TodosAdapter(LayoutInflater inflater, List<Restaurante> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public TodosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_restaurante, parent, false);
        return new TodosHolder(v);
    }

    @Override
    public void onBindViewHolder(TodosHolder holder, int position) {
        holder.binding.setRestaurantes(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    //region viewHolders
    static class TodosHolder extends RecyclerView.ViewHolder {

        TemplateRestauranteBinding binding;

        public TodosHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
    //endregion

}
