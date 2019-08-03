package com.example.trabajofinalcibertec.presentation.detalle.view;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.data.entities.Producto;

import java.util.List;

public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.DetalleViewHolder> {

    //private PostClickListener clickListener;
    private List<Producto> productoList;

    public DetalleAdapter(List<Producto> productoList) {
        this.productoList = productoList;
    }

    //public void setOnItemClickListener(PostClickListener clickListener){
    //  this.clickListener = clickListener;
    //}

    @NonNull
    @Override
    public DetalleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_detalle, parent, false);
        return new DetalleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetalleViewHolder holder, int position) {
        Producto producto = productoList.get(position);
        holder.cvDetalleNombre.setText(producto.getNombre());
        holder.cvDetalleCantidad.setText(producto.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class DetalleViewHolder extends RecyclerView.ViewHolder{

        private TextView cvDetalleNombre;
        private TextView cvDetalleCantidad;

        public DetalleViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //if(clickListener != null) {
                    //    clickListener.onClick(getAdapterPosition());
                    //}
                }
            });
            cvDetalleNombre = itemView.findViewById(R.id.cvDetalleNombre);
            cvDetalleCantidad = itemView.findViewById(R.id.cvDetalleCantidad);
        }
    }
}
