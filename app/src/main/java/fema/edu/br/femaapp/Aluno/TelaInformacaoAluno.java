package fema.edu.br.femaapp.Aluno;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fema.edu.br.femaapp.Geral.AlunoAdapter;
import fema.edu.br.femaapp.Geral.Conexao;
import fema.edu.br.femaapp.Geral.ListAluno;
import fema.edu.br.femaapp.R;

public class TelaInformacaoAluno extends AppCompatActivity {

    EditText Raresultado;
    Button buttonmostrainfo;
    static final String URL_DATA="http://192.168.1.80/femaapp/dadosinfo.php?ra=";
    String url = "";
    String parametros = "";

    private RecyclerView recyclerView2;
    private RecyclerView.Adapter adapter;

    private List<ListAluno> listAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_informacoes_aluno);

        Intent abreinformacao = getIntent();

        Bundle bundle = abreinformacao.getExtras();

        String passou = bundle.getString("passou");

        EditText edTexto = findViewById(R.id.Raresultado);

        edTexto.setText(passou);

        Raresultado = findViewById(R.id.Raresultado);
        buttonmostrainfo = findViewById(R.id.buttonmostrainfo);

        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        listAlunos = new ArrayList<>();



        buttonmostrainfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {

                    String ra = Raresultado.getText().toString();

                    if (ra.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Nenhuma campo pode estar vazio", Toast.LENGTH_SHORT).show();
                    } else {
                        //url = "http://10.0.119.17/femaapp/logar.php";
                        url = "http://192.168.1.80/femaapp/dadosinfoauth.php?ra=";

                        parametros = "ra=" + ra;

                        new TelaInformacaoAluno.SolicitaDados().execute(url);

                        loadRecyclerViewData();


                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Nenhuma conexão foi detectada", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return Conexao.postDados(urls[0], parametros);
        }

        @Override
        protected void onPostExecute(String resultado) {

            if (resultado.contains("login_ok")) {


            } else {
                Toast.makeText(getApplicationContext(), "Usuário incorreto", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Carregando");
        progressDialog.show();

String raresultado = Raresultado.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA+raresultado,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("aluno");

                            for (int i = 0; i<array.length(); i++){
                                JSONObject o = array.getJSONObject(i);
                                ListAluno aluno = new ListAluno(
                                        o.getString("nome"),
                                        o.getString("ra_aluno"),
                                        o.getString("rg"),
                                        o.getString("cpf"),
                                        o.getString("email"),
                                        o.getString("imagem")
                                );
                                listAlunos.add(aluno);
                            }

                            adapter = new AlunoAdapter(listAlunos, getApplicationContext());
                            recyclerView2.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
