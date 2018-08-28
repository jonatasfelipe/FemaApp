package fema.edu.br.femaapp.Geral;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import fema.edu.br.femaapp.R;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.ViewHolder>{

    private List<ListAluno> listAlunos;
    private Context context;

    public AlunoAdapter(List<ListAluno> listAlunos, Context context){
        this.listAlunos = listAlunos;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_aluno, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListAluno listAluno = listAlunos.get(position);

        holder.textViewHead.setText(listAluno.getNome());
        holder.textViewDesc.setText(listAluno.getRa());
        holder.texViewRg.setText(listAluno.getRg());
        holder.textViewCpf.setText(listAluno.getCpf());
        holder.textViewEmail.setText(listAluno.getEmail());


        Glide.with(context)
                .load(listAluno.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listAlunos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            //aqui vai os itens que estão na lista
        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView texViewRg;
        public TextView textViewCpf;
        public TextView textViewEmail;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = itemView.findViewById(R.id.textViewHead);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            texViewRg = itemView.findViewById(R.id.textViewRg);
            textViewCpf = itemView.findViewById(R.id.textViewCpf);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
