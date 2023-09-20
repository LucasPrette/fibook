import java.util.ArrayList;
import java.util.Scanner;

public class Fibook {
    Scanner scanner = new Scanner(System.in);

    private ArrayList<Usuario> usuarios;
    private ArrayList<Post> posts;
    private ArrayList<Comentario> comentarios;

    private Usuario usuarioLogado;
    private BancoDeDados bancoDeDados;

    public Fibook()
    {
        bancoDeDados = new BancoDeDados();
        usuarios = bancoDeDados.carregarUsuarios();
        posts = bancoDeDados.carregarPosts();
        comentarios = bancoDeDados.carregarComentarios();

    };

    public void logar() {
        System.out.println("LOGAR: ");

        System.out.println("Usuario-> ");
        String username = scanner.nextLine();

        System.out.println("Senha-> ");
        String senha = scanner.nextLine();

        for(Usuario usuario : usuarios) {
            if (username.equals(usuario.getUsername())) {
                if (senha.equals(usuario.getSenha())) {
                    usuarioLogado = usuario;
                    this.iniciar();
                    return;
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
                case 4: verPerfil();break;
                case 5: comentar();break;
                case 6: postar();break;
            }
        } while(true);
    };

    public void postar() {
        System.out.println("POSTAR: ");

        System.out.print("Conteudo -> ");
        String conteudo = scanner.nextLine();

        Post post = new Post(usuarioLogado.getId(), conteudo);

        bancoDeDados.inserirPost(post);

        this.posts = this.bancoDeDados.carregarPosts();
    };

    public void comentar() {
        System.out.println("COMENTAR:");
        System.out.println("Digite o ID do post");

        int postId = this.scanner.nextInt();
        Post postExiste = null;

        for (Post post : this.posts) {
            if (post.getId() == postId) {
                postExiste = post;
            }
        }

        if (postExiste == null) {
            System.out.println("Post não encontrado");
            return;
        }

        System.out.println("Digite o conteúdo do comentário:");
        String conteudo = this.scanner.nextLine();

        Comentario comentario = new Comentario(this.usuarioLogado.getId(), postExiste.getId(), conteudo);

        this.bancoDeDados.inserirComentario(comentario);
        this.comentarios = this.bancoDeDados.carregarComentarios();
    };

    public void verPerfil() {
        ArrayList<Comentario> comentariosDoUsuario = new ArrayList<>();
        ArrayList<Post> postsDoUsuario = new ArrayList<>();

        for (Comentario comentario : this.comentarios) {
            if (comentario.getUsuarioId() == this.usuarioLogado.getId()) {
                comentariosDoUsuario.add(comentario);
            }
        }

        for (Post post : this.posts) {
            if (post.getUsuarioId() == this.usuarioLogado.getId()) {
                postsDoUsuario.add(post);
            }
        }

        System.out.println("PERFIL:");
        this.usuarioLogado.exibir();

        for (Post post : postsDoUsuario) {
            post.exibir();

            for (Comentario comentario : comentariosDoUsuario) {
                if (comentario.getPostId() == post.getId()) {
                    comentario.exibir();
                }
            }
        }
    };

    public void criarUsuario() {
        System.out.println("Nome -> ");
        String nome = scanner.nextLine();

        System.out.println("Nome de usuario -> ");
        String username = scanner.nextLine();

        System.out.println("Senha -> ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(nome, username, senha);

        this.bancoDeDados.inserirUsuario(usuario);
        usuarios = this.bancoDeDados.carregarUsuarios();
    };

    public void listarUsuarios() {
        System.out.println("LISTAR USUARIOS: ");

        for(int i = 0; i < usuarios.size(); i++) {
            usuarios.get(i).exibir();
        }
    };

}
