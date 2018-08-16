package fema.edu.br.femaapp.Geral;

public class Aluno {

    private int ra_aluno;
    private String nome;
    private String imagem;

    public Aluno(int ra_aluno, String nome, String imagem) {
        this.ra_aluno = ra_aluno;
        this.nome = nome;
        this.imagem = imagem;
    }

    public int getRa_aluno() {
        return ra_aluno;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }
}