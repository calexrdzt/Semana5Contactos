package com.example.estudiante.listasavanzadas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv_noticias;
    NoticiaAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_noticias = findViewById(R.id.lv_noticias);
        customAdapter = new NoticiaAdapter(this);
        lv_noticias.setAdapter(customAdapter);

        Noticia noticia1= new Noticia("Logo nuevo de hoy es diseño","va a haber un cambio en el logo de hoy es diseño", "30 de agosto/2018");
        customAdapter.agregarNoticia(noticia1);
        lv_noticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Noticia noticia_click=(Noticia) customAdapter.getItem(position);
                Toast.makeText(MainActivity.this , noticia_click.getTitulo(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
