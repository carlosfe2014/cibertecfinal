package com.example.trabajofinalcibertec.presentation.carrito.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.data.entities.CompraProducto;

import java.util.List;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder> {


    private List<CompraProducto> productoList;

    public CarritoAdapter(List<CompraProducto> productoList) {
        this.productoList = productoList;
    }



    @NonNull
    @Override
    public CarritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carrito, parent, false);
        return new CarritoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoViewHolder holder, int position) {
        CompraProducto producto = productoList.get(position);
        holder.cvCarritoNombre.setText(producto.getNombre());
        holder.cvCarritoCantidad.setText(producto.getDescripcion());


        Glide.with(holder.itemView).load(producto.getImagen()).into(holder.cvCarritoImagen);


    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class CarritoViewHolder extends RecyclerView.ViewHolder{

        private TextView cvCarritoNombre;
        private TextView cvCarritoCantidad;
        private ImageView cvCarritoImagen;

        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);
            cvCarritoNombre = itemView.findViewById(R.id.cvCarritoNombre);
            cvCarritoCantidad = itemView.findViewById(R.id.cvCarritoCantidad);
            cvCarritoImagen = itemView.findViewById(R.id.cvCarritoImagen);
        }
    }
}
