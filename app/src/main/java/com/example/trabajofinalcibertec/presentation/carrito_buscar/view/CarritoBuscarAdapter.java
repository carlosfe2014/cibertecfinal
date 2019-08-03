package com.example.trabajofinalcibertec.presentation.carrito_buscar.view;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.data.entities.Producto;

import java.util.List;

public class CarritoBuscarAdapter extends RecyclerView.Adapter<CarritoBuscarAdapter.CarritoBuscarViewHolder> {

    private CarritoBuscarClickListener clickListener;
    private List<Producto> productoList;

    public CarritoBuscarAdapter(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public void setOnItemClickListener(CarritoBuscarClickListener clickListener){
      this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CarritoBuscarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carrito_buscar, parent, false);
        return new CarritoBuscarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoBuscarViewHolder holder, int position) {
        Producto producto = productoList.get(position);
        holder.tvCarritoBuscarNombre.setText(producto.getNombre());
        holder.tvCarritoBuscarDescripcion.setText(producto.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class CarritoBuscarViewHolder extends RecyclerView.ViewHolder{

        private TextView tvCarritoBuscarNombre;
        private TextView tvCarritoBuscarDescripcion;
        private ImageView btnCarritoBuscarAgregar;

        public CarritoBuscarViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clickListener != null) {
                        clickListener.onClick(getAdapterPosition());
                    }
                }
            });
            tvCarritoBuscarNombre = itemView.findViewById(R.id.tvCarritoBuscarNombre);
            tvCarritoBuscarDescripcion = itemView.findViewById(R.id.tvCarritoBuscarDescripcion);
            btnCarritoBuscarAgregar = itemView.findViewById(R.id.btnCarritoBuscarAgregar);
        }
    }
}
