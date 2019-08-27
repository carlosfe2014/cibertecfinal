package com.example.trabajofinalcibertec.network;

import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.data.entities.responses.BusquedaResponse;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    //@GET("posts")
    //Observable<List<Post>> getPostsRx(); // el va a hacer el onNext

    @GET("api/producto/{id}/comentarios")
    Observable<ProductoResponse> getProducto(@Path("id") int postId);


    @GET("api/productos") //i.e https://api.test.com/Search?
    Observable<BusquedaResponse> searchProductos(@Query("query") String query);

    //@GET("post/{id}/comments")
    //Observable<List<Comment>> getComments(@Path("id") int postId);
}