public class Comentario {
    private int id;
    private int usuarioId;
    private int postId;
    private String conteudo;

    public Comentario
            (
                    int id,
                    int usuarioId,
                    int postId,
                    String conteudo
    ){
        this.id = id;
        this.usuarioId = usuarioId;
        this.postId = postId;
        this.conteudo = conteudo;
    }

    public Comentario
            (
                    int usuarioId,
                    int postId,
                    String conteudo
            ){
        this.usuarioId = usuarioId;
        this.postId = postId;
        this.conteudo = conteudo;
    }
    public int getId() {
        return this.id;
    }
    public int getPostId() {
        return this.postId;
    }
    public int getUsuarioId() {
        return this.usuarioId;
    }
    public String getConteudo() {
        return this.conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void exibir() {
        System.out.println("ID: " + this.usuarioId);
        System.out.println("POST ID: " + this.postId);
        System.out.println("CONTEUDO: " + this.conteudo);
    }
}
