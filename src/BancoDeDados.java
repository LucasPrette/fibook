import java.sql.*;
import java.util.ArrayList;

public class BancoDeDados {
        private String url = "jdbc:sqlserver://localhost:1433;databaseName=fib;encrypt=false;";
        private String usuario = "aluno";
        private String senha = "Senha123+";

    public Connection getConexao() {

        try {
            Connection connection = DriverManager.getConnection(url,usuario, senha);
            System.out.println("Conexao Bem sucedida");
            return connection;
        } catch (SQLException e) {
            System.err.println("Erro de conexao");
            e.printStackTrace();
            return null;
        }
    }

    public void inserirUsuario(Usuario usuario) {
        try {
            String sql = "INSERT INTO fibook.usuario (username, nome, senha) VALUES (?, ?, ?);";

            PreparedStatement statement = this.getConexao().prepareStatement(sql);

            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getNome());
            statement.setString(3, usuario.getSenha());

            int linhasAdicionadas = statement.executeUpdate();

            if (linhasAdicionadas == 0) {
                throw new Exception("Não foi possível criar o usuário");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserirPost(Post post) {
        try {
            String sql = "INSERT INTO fibook.post (conteudo, usuario_id) VALUES (?, ?);";

            PreparedStatement statement = this.getConexao().prepareStatement(sql);

            statement.setString(1, post.getConteudo());
            statement.setInt(2, post.getUsuarioId());

            int linhasAdicionadas = statement.executeUpdate();

            if (linhasAdicionadas == 0) {
                throw new Exception("Não foi possível criar o post");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserirComentario(Comentario comentario) {
        try {
            String sql = "INSERT INTO fibook.comentario (conteudo, usuario_id, post_id) VALUES (?, ?, ?);";

            PreparedStatement statement = this.getConexao().prepareStatement(sql);

            statement.setString(1, comentario.getConteudo());
            statement.setInt(2, comentario.getUsuarioId());
            statement.setInt(3, comentario.getPostId());

            int linhasAdicionadas = statement.executeUpdate();

            if (linhasAdicionadas == 0) {
                throw new Exception("Não foi possível criar o comentario");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> carregarUsuarios() {
        ArrayList<Usuario> resultado = new ArrayList<>();

        try {
            String sql = "SELECT id, username, nome FROM fibook.usuario;";

            ResultSet linhas = this.getConexao().prepareStatement(sql).executeQuery();

            while (linhas.next()) {
                int id = linhas.getInt("id");
                String username = linhas.getString("username");
                String nome = linhas.getString("nome");

                Usuario usuario = new Usuario(id, username, nome);

                resultado.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }

    public ArrayList<Post> carregarPosts() {
        ArrayList<Post> resultado = new ArrayList<>();

        try {
            String sql = "SELECT id, conteudo, usuario_id FROM fibook.post;";

            ResultSet linhas = this.getConexao().prepareStatement(sql).executeQuery();

            while (linhas.next()) {
                int id = linhas.getInt("id");
                String username = linhas.getString("conteudo");
                String usuarioId = linhas.getString("usuario_id");

                Post post = new Post(id, username, usuarioId);

                resultado.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }

    public ArrayList<Comentario> carregarComentarios() {
        ArrayList<Comentario> resultado = new ArrayList<>();

        try {
            String sql = "SELECT id, conteudo, usuario_id, post_id FROM fibook.comentario;";

            ResultSet linhas = this.getConexao().prepareStatement(sql).executeQuery();

            while (linhas.next()) {
                int id = linhas.getInt("id");
                String conteudo = linhas.getString("conteudo");
                int usuarioId = linhas.getInt("usuario_id");
                int postId = linhas.getInt("post_id");

                Comentario comentario = new Comentario(id, usuarioId, postId, conteudo);

                resultado.add(comentario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }

}
