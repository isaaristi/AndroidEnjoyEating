package com.isaaristi.enjoyeating.adapters;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.databinding.TemplateRestauranteBinding;
import com.isaaristi.enjoyeating.fragments.TodosFragment;
import com.isaaristi.enjoyeating.modelos.Restaurante;

import java.util.List;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodosHolder>{

    public interface onRestauranteListener {
        void onRestauranteClick(int position);
    }

    LayoutInflater inflater;
    List<Restaurante> data;
    onRestauranteListener listener;

    public TodosAdapter(LayoutInflater inflater, List<Restaurante> data, onRestauranteListener listener) {
        this.inflater = inflater;
        this.data = data;
        this.listener = listener;
    }

    @Override
    public TodosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_restaurante, parent, false);
        return new TodosHolder(v);
    }

    @Override
    public void onBindViewHolder(TodosHolder holder, int position) {
        holder.binding.setRestaurantes(data.get(position));
        holder.binding.card.setTag(position);
        holder.binding.setHandler(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void onItemClick (int position) {
        listener.onRestauranteClick(position);
    }

    public void setData(List<Restaurante> data) {
        this.data = data;
        notifyDataSetChanged();
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
