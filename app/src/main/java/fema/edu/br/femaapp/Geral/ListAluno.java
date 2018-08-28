package fema.edu.br.femaapp.Geral;

public class ListAluno {

    private String nome;
    private String ra;
    private String rg;
    private String cpf;
    private String email;
    private String imageUrl;

    public ListAluno(String nome, String ra, String rg, String cpf, String email, String imageUrl) {
        this.nome = nome;
        this.ra = ra;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public String getNome() {
        return nome;
    }

    public String getRa() {
        return ra;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
