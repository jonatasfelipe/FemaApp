package fema.edu.br.femaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TelaMenualuno extends AppCompatActivity {

    ImageButton btnnota1, btninformacao1, btnboletos1, btnDependencia1,btnhorarios1,btnmonografia1,btncontratos1;
    Button buttonlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu_aluno);

        btnnota1 = findViewById(R.id.btnnota1);
        btninformacao1 = findViewById(R.id.btninformacao1);
        btnboletos1 = findViewById(R.id.btnboletos1);
        btnDependencia1 = findViewById(R.id.btnDependencia1);
        btnhorarios1 = findViewById(R.id.btnhorarios1);
        btnmonografia1 = findViewById(R.id.btnmonografia1);
        btncontratos1 = findViewById(R.id.btncontratos1);
        buttonlogout = findViewById(R.id.buttonlogout);

        btnnota1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreNotas = new Intent(TelaMenualuno.this, TelaNotaseFaltas.class);
                startActivity(abreNotas);
            }
        });

        btninformacao1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreInformacao = new Intent(TelaMenualuno.this, TelaInformacaoAluno.class);
                startActivity(abreInformacao);
            }
        });

        btnboletos1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreBoletos = new Intent(TelaMenualuno.this, TelaBoletos.class);
                startActivity(abreBoletos);
            }
        });

        btnDependencia1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreDependencia = new Intent(TelaMenualuno.this, TelaDependencia.class);
                startActivity(abreDependencia);
            }
        });

        btnhorarios1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreHorarios = new Intent(TelaMenualuno.this, TelaHorarios.class);
                startActivity(abreHorarios);
            }
        });

        btnmonografia1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreMonografia = new Intent(TelaMenualuno.this, TelaMonografia.class);
                startActivity(abreMonografia);
            }
        });

        btncontratos1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreContratos = new Intent(TelaMenualuno.this, TelaContratos.class);
                startActivity(abreContratos);
            }
        });

    }

}
