package fema.edu.br.femaapp.Aluno;

        import android.content.Context;
        import android.content.Intent;
        import android.net.ConnectivityManager;
        import android.net.NetworkInfo;
        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import fema.edu.br.femaapp.Geral.Conexao;
        import fema.edu.br.femaapp.R;

public class
TelaLoginAluno extends AppCompatActivity {

    EditText editTextraaluno, editTextsenhaaluno;
    Button buttonlogin;

    String url = "";
    String parametros = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_aluno);

        editTextraaluno = findViewById(R.id.editTextraaluno);
        editTextsenhaaluno = findViewById(R.id.editTextsenhaaluno);
        buttonlogin = findViewById(R.id.buttonlogin);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {

                    String ra = editTextraaluno.getText().toString();
                    String senha = editTextsenhaaluno.getText().toString();

                    if (ra.isEmpty() || senha.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Nenhuma campo pode estar vazio", Toast.LENGTH_SHORT).show();
                    } else {
                        //url = "http://10.0.119.17/femaapp/logar.php";
                        url = "http://192.168.1.80/femaapp/logar.php";

                        parametros = "ra=" + ra + "&senha=" + senha;

                        new SolicitaDados().execute(url);
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
                Intent abreMenu = new Intent(TelaLoginAluno.this, TelaMenualuno.class);
                startActivity(abreMenu);
            } else {
                Toast.makeText(getApplicationContext(), "Usuário ou senha estão incorretos", Toast.LENGTH_SHORT).show();
            }

        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}