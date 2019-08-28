package com.example.trabajofinalcibertec.presentation.carrito_agregar.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.data.entities.Comentario;

import java.util.List;

public class CarritoAgregarAdapter extends RecyclerView.Adapter<CarritoAgregarAdapter.CarritoAgregarViewHolder> {

    //private CarritoBuscarClickListener clickListener;
    private List<Comentario> comentarioList;

    public CarritoAgregarAdapter(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    //public void setOnItemClickListener(CarritoBuscarClickListener clickListener){
    //    this.clickListener = clickListener;
    //}

    @NonNull
    @Override
    public CarritoAgregarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comentario, parent, false);
        return new CarritoAgregarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoAgregarViewHolder holder, int position) {
        Comentario comentario = comentarioList.get(position);
        holder.tvCarritoAgregarComentarioAutor.setText(comentario.getAutor());
        holder.tvCarritoAgregarComentarioFecha.setText(comentario.getFecha());
        holder.tvCarritoAgregarComentarioBody.setText(comentario.getMensaje());
    }

    @Override
    public int getItemCount() {
        return comentarioList.size();
    }

    public class CarritoAgregarViewHolder extends RecyclerView.ViewHolder{

        private TextView tvCarritoAgregarComentarioAutor;
        private TextView tvCarritoAgregarComentarioFecha;
        private TextView tvCarritoAgregarComentarioBody;

        public CarritoAgregarViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //if(clickListener != null) {
                    //    clickListener.onClick(getAdapterPosition());
                    //}
                }
            });
            tvCarritoAgregarComentarioAutor = itemView.findViewById(R.id.tvCarritoAgregarComentarioAutor);
            tvCarritoAgregarComentarioFecha = itemView.findViewById(R.id.tvCarritoAgregarComentarioFecha);
            tvCarritoAgregarComentarioBody = itemView.findViewById(R.id.tvCarritoAgregarComentarioBody);
        }
    }
}
