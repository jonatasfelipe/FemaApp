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

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.ProductViewHolder>{

    private Context mCtx;
    private List<Aluno> alunoList;

    public AlunoAdapter(Context mCtx, List<Aluno> alunoList) {
        this.mCtx = mCtx;
        this.alunoList = alunoList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_aluno_lista, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Aluno product = alunoList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(product.getImagem())
                .into(holder.imageView);

        holder.textViewTitle.setText(product.getRa_aluno());
        holder.textViewShortDesc.setText(product.getNome());
    }

    @Override
    public int getItemCount() {
        return alunoList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
