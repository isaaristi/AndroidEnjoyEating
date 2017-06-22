package com.isaaristi.enjoyeating.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaaristi.enjoyeating.R;
import com.isaaristi.enjoyeating.databinding.TemplatePlatosBinding;
import com.isaaristi.enjoyeating.fragments.PlatosFragment;
import com.isaaristi.enjoyeating.modelos.Menu;

import java.util.ArrayList;
import java.util.List;

public class PlatosAdapter extends RecyclerView.Adapter<PlatosAdapter.PlatosHolder>{

    LayoutInflater inflater;
    List<Menu> data;

    public PlatosAdapter(LayoutInflater inflater, List<Menu> data, PlatosFragment platosFragment) {
        this.inflater = inflater;
        this.data = data;
    }


    @Override
    public PlatosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_platos, parent, false);
        return new PlatosHolder(v);
    }

    @Override
    public void onBindViewHolder(PlatosHolder holder, int position) {
        holder.binding.setMenu(data.get(position));
        holder.binding.card.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Menu> data){
        this.data = data;
        notifyDataSetChanged();
    }




    static class PlatosHolder extends RecyclerView.ViewHolder {
        TemplatePlatosBinding binding;

        public PlatosHolder (View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
