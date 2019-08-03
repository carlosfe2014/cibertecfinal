package com.example.trabajofinalcibertec.presentation.carrito.view;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.data.entities.Producto;

import java.util.List;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder> {

    //private PostClickListener clickListener;
    private List<Producto> productoList;

    public CarritoAdapter(List<Producto> productoList) {
        this.productoList = productoList;
    }

    //public void setOnItemClickListener(PostClickListener clickListener){
    //  this.clickListener = clickListener;
    //}

    @NonNull
    @Override
    public CarritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carrito, parent, false);
        return new CarritoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoViewHolder holder, int position) {
        Producto producto = productoList.get(position);
        holder.cvCarritoNombre.setText(producto.getNombre());
        holder.cvCarritoCantidad.setText(producto.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class CarritoViewHolder extends RecyclerView.ViewHolder{

        private TextView cvCarritoNombre;
        private TextView cvCarritoCantidad;

        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //if(clickListener != null) {
                    //    clickListener.onClick(getAdapterPosition());
                    //}
                }
            });
            cvCarritoNombre = itemView.findViewById(R.id.cvCarritoNombre);
            cvCarritoCantidad = itemView.findViewById(R.id.cvCarritoCantidad);
        }
    }
}
