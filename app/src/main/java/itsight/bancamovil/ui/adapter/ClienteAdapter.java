package itsight.bancamovil.ui.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import itsight.bancamovil.R;
import itsight.bancamovil.io.model.Cliente;

public class ClienteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Cliente> clientes;
    //    private int rowLayout;
    private Context context;

    public static class ClienteViewHolder extends RecyclerView.ViewHolder {
        TextView txt_Nombre;
        TextView txt_Mail;
        TextView txt_Telefono;
        CheckBox chb_Favorito;
        ImageView ivw_Imagen;


        public ClienteViewHolder(View v) {
            super(v);
            txt_Nombre = (TextView) v.findViewById(R.id.txt_Nombre);
            txt_Mail = (TextView) v.findViewById(R.id.txt_Mail);
            txt_Telefono = (TextView) v.findViewById(R.id.txt_Telefono);
            chb_Favorito = (CheckBox) v.findViewById(R.id.chb_Favorito);
            ivw_Imagen = (ImageView) v.findViewById(R.id.ivw_Imagen);
        }
    }

    //    public ClienteAdapter(List<Cliente> clientes, int rowLayout, Context context) {
    public ClienteAdapter(List<Cliente> clientes, Context context) {

        this.clientes = clientes;
//        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliente, parent, false);
        ClienteViewHolder viewHolder = new ClienteViewHolder(v);
        return viewHolder;

//        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
//        return new MovieViewHolder(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ClienteViewHolder viewHolder = (ClienteViewHolder) holder;

        Cliente c = clientes.get(position);

        viewHolder.txt_Nombre.setText(c.getNombre());
        viewHolder.txt_Mail.setText(c.getMail());
        viewHolder.txt_Telefono.setText(c.getTelefono());

        Picasso.with(context).load(c.getUrlImagen()).into(viewHolder.ivw_Imagen);

//        viewHolder.chb_Favorito;

//        holder.movieTitle.setText(movies.get(position).getTitle());
//        holder.data.setText(movies.get(position).getReleaseDate());
//        holder.movieDescription.setText(movies.get(position).getOverview());
//        holder.rating.setText(movies.get(position).getVoteAverage().toString());

    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }
}
