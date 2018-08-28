package fema.edu.br.femaapp.Professor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import fema.edu.br.femaapp.R;

public class TelaMenuprofessor extends AppCompatActivity {

    ImageButton btnpresenca, btnnotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu_professor);

        btnpresenca = findViewById(R.id.btnpresenca);
        btnnotas = findViewById(R.id.btnnotas);

        btnpresenca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreLancaFaltas = new Intent(TelaMenuprofessor.this, FazerChamada.class);
                startActivity(abreLancaFaltas);
            }
        });

        btnnotas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent abreLancaNotas = new Intent(TelaMenuprofessor.this, LancarNotas.class);
                startActivity(abreLancaNotas);
            }

        });
    }
}
