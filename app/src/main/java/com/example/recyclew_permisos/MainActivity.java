package com.example.recyclew_permisos;

import static androidx.core.app.ActivityCompat.requestPermissions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE=200;
    private ArrayList<Permisos> btnlist;
    PermisosAdaptador botonesAdaptador;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        btnlist = new ArrayList<>();
        setUserInfo();
        setAdapter();
    }




    private void setAdapter()
    {
        PermisosAdaptador adaptador = new PermisosAdaptador(btnlist);
        RecyclerView.LayoutManager LayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptador);
        recyclerView.setHasFixedSize(true);
    }
    private void setUserInfo()
    {
        btnlist.add(new Permisos("SMS",Manifest.permission.SEND_SMS));
        btnlist.add(new Permisos("LLAMAR",Manifest.permission.CALL_PHONE));
        btnlist.add(new Permisos("BLUETOOH",Manifest.permission.BLUETOOTH));
        btnlist.add(new Permisos("CAMARA",Manifest.permission.CAMERA));
        btnlist.add(new Permisos("ALMACENAMIENTO",Manifest.permission.WRITE_EXTERNAL_STORAGE));

        //


    }
}