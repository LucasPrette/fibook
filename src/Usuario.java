public class Usuario {
    private int id;
    private String username;
    private String nome;
    private String senha;



    public Usuario(int id, String username, String nome, String senha){
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.senha = senha;
    }
    public Usuario (int id, String username, String nome) {
        this.id = id;
        this.username = username;
        this.nome = nome;
    }
    public Usuario ( String username, String nome, String senha) {
        this.username = username;
        this.nome = nome;
        this.senha = senha;
    }

    //METODOS

    public void exibir(){
        System.out.println("\nUSUARIO: ");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Username: " + getUsername());
        System.out.println("Senha: " + getSenha());
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return senha;
    }



}
