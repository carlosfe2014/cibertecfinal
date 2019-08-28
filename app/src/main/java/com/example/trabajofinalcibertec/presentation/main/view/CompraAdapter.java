package com.example.trabajofinalcibertec.presentation.main.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.data.entities.Compra;

import java.util.List;



public class CompraAdapter extends RecyclerView.Adapter<CompraAdapter.CompraViewHolder> {

    //private PostClickListener clickListener;
    private List<Compra> compraList;

    public CompraAdapter(List<Compra> compraList) {
        this.compraList = compraList;
    }

    //public void setOnItemClickListener(PostClickListener clickListener){
      //  this.clickListener = clickListener;
    //}

    @NonNull
    @Override
    public CompraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_compra, parent, false);
        return new CompraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompraViewHolder holder, int position) {
        Compra compra = compraList.get(position);
        holder.cvComprasTitulo.setText(compra.getTitulo());
        holder.cvComprasDescripcion.setText(compra.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return compraList.size();
    }

    public class CompraViewHolder extends RecyclerView.ViewHolder{

        private TextView cvComprasTitulo;
        private TextView cvComprasDescripcion;

        public CompraViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //if(clickListener != null) {
                    //    clickListener.onClick(getAdapterPosition());
                    //}
                }
            });
            cvComprasTitulo = itemView.findViewById(R.id.cvComprasTitulo);
            cvComprasDescripcion = itemView.findViewById(R.id.cvComprasDescripcion);
        }
    }
}
