public class Post {
    private int id;
    private String usuarioId;
    private String conteudo;

    public Post(int id, String usuarioId, String conteudo){};
    public Post(String usuarioId, String conteudo){};

    // METODOS


    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setUsuarioId(String usuarioId){
        this.usuarioId = usuarioId;
    }
    public String getUsuarioId(){
        return usuarioId;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }

    public String getConteudo(){
        return conteudo;
    }
    public void exibir(){
        System.out.println("ID: " + getId());
        System.out.println("UsuarioID: " + getUsuarioId());
        System.out.println("Conteudo: " + getConteudo());
    }
}
