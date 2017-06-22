package com.isaaristi.enjoyeating.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.databinding.TemplateGuardarBinding;
import com.isaaristi.enjoyeating.fragments.GuardarFragment;
import com.isaaristi.enjoyeating.modelos.Guardar;

import java.util.List;

public class GuardarAdapter extends RecyclerView.Adapter<GuardarAdapter.GuardarHolder>{

    LayoutInflater inflater;
    List<Guardar> data;

    public GuardarAdapter(LayoutInflater inflater, List<Guardar> data, GuardarFragment guardarFragment) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public GuardarHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_guardar, parent, false);
        return  new GuardarHolder(v);
    }

    @Override
    public void onBindViewHolder(GuardarHolder holder, int position) {
        holder.binding.setGuardar(data.get(position));
        holder.binding.card.setTag(position);
        holder.binding.setHandler(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Guardar> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    static class GuardarHolder extends RecyclerView.ViewHolder {
        TemplateGuardarBinding binding;

        public GuardarHolder (View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
