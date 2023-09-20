public class Post {
    private int id;
    private int usuarioId;
    private String conteudo;

    public Post(int id, String usuarioId, String conteudo){};
    public Post(int usuarioId, String conteudo){};

    // METODOS


    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setUsuarioId(int usuarioId){
        this.usuarioId = usuarioId;
    }
    public int getUsuarioId(){
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
