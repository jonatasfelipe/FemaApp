package fema.edu.br.femaapp.Geral;

public class ListAluno {

    private String head;
    private String desc;
    private String imageUrl;

    public ListAluno(String head, String desc, String imageUrl) {
        this.head = head;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
