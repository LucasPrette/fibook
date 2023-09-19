import java.util.ArrayList;
import java.util.Scanner;

public class Fibook {
    Scanner scanner = new Scanner(System.in);

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Arraylist<Post> posts = new ArrayList<>();
    private Arraylist<Comentario> comentarios = new ArrayList<>();

    private Usuario usuarioLogado;
    private BancoDeDados bancoDeDados;

    public void logar() {
        System.out.println("LOGAR: ");
        System.out.println("Usuario-> ");
        String usuario = scanner.nextLine();

        System.out.println("Senha-> ");
        String senha = scanner.nextLine();

        for(Usuario usuario1 : usuarios) {
            if (usuario == usuario1.getUsername()) {
                if (senha == usuario1.getSenha()) {
                    usuarioLogado = usuario1;
                }

            }
            System.out.println("Usuario nao encontrado");

        }

    };

    public void iniciar() {

        do {
            System.out.println("FIBOOK:");
            System.out.println("1 - LOGAR");
            System.out.println("2 - CRIAR USUARIO");
            System.out.println("3 - LISTAR USUARIOS");
            System.out.println("4 - VER PERFIL");
            System.out.println("5 - COMENTAR");
            System.out.println("6 - POSTAR");
            System.out.print(" -> ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: logar();break;
                case 2: criarUsuario(); break;
                case 3: listarUsuarios(); break;
                case 4: break;
                case 5: break;
                case 6: break;
            }
        } while(true);


    };

    public void postar() {

    };

    public void comentar() {

    };

    public void verPerfil() {

    };

    public void criarUsuario() {
        System.out.println("Nome -> ");
        String nome = scanner.nextLine();

        System.out.println("Nome de usuario -> ");
        String username = scanner.nextLine();

        System.out.println("Senha -> ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(nome, username,senha);

    };

    public void listarUsuarios() {
        for(int i = 0; i < usuarios; i++) {
            System.out.println(usuarios[i].getNome());
            System.out.println(usuarios[i].getId());
            System.out.println(usuarios[i].getUsername);
        }
    };

}
