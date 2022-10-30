package com.example.recyclew_permisos;

import static androidx.core.app.ActivityCompat.requestPermissions;
import static androidx.core.content.ContextCompat.startActivities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PermisosAdaptador extends RecyclerView.Adapter<PermisosAdaptador.MyViewHolder> {

    private ArrayList<Permisos> btnlist;


    public PermisosAdaptador(ArrayList<Permisos> btnlist)
    {
        this.btnlist=btnlist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView btntxt;

        public MyViewHolder(final View view)
        {
            super(view);
            btntxt=view.findViewById(R.id.btnuno);
        }
    }
    @NonNull
    @Override
    public PermisosAdaptador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_permisos,parent,false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisosAdaptador.MyViewHolder holder, int position) {
        String name=btnlist.get(position).getBtn();
        holder.btntxt.setText(name);
      //  int posicion= Integer.parseInt(btnlist.get(position).getBtn());

        String permiso=btnlist.get(position).getPermisos();
        holder.btntxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int REQUEST_CODE=200;
            int checkpermiso= ContextCompat.checkSelfPermission(view.getContext(),permiso);
                if (checkpermiso == PackageManager.PERMISSION_GRANTED)
                {
                    //METODO
                  //  Toast.makeText(this, "Permiso SMS y escritura en ALMACENAMIENTO Concedido", Toast.LENGTH_SHORT).show();
                    Toast.makeText(view.getContext(),"Los Permisos ya estan Aceptados",Toast.LENGTH_SHORT).show();
                }
                else
                {
                   // Toast.makeText(view.getContext(),"se aceptaron",Toast.LENGTH_SHORT).show();
                   //requestPermissions(new Activity(),new String[]{permiso},REQUEST_CODE);
                    ActivityCompat.requestPermissions((Activity) view.getContext(),new String[]{permiso},REQUEST_CODE);
                }

            }
        });



    }


    @Override
    public int getItemCount() {
        return btnlist.size();
    }
}
