package com.isaaristi.enjoyeating.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.databinding.TemplateEstuveBinding;
import com.isaaristi.enjoyeating.fragments.EstuveFragment;
import com.isaaristi.enjoyeating.modelos.Estuve;

import java.util.List;

public class EstuveAdapter extends RecyclerView.Adapter<EstuveAdapter.EstuveHolder>{

    LayoutInflater inflater;
    List<Estuve> data;

    public EstuveAdapter(LayoutInflater inflater, List<Estuve> data, EstuveFragment estuveFragment) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public EstuveHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_estuve, parent, false);
        return  new EstuveHolder(v);
    }

    @Override
    public void onBindViewHolder(EstuveHolder holder, int position) {
        holder.binding.setEstuve(data.get(position));
        holder.binding.card.setTag(position);
        holder.binding.setHandler(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Estuve> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    static class EstuveHolder extends RecyclerView.ViewHolder {

        TemplateEstuveBinding binding;

        public EstuveHolder (View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
