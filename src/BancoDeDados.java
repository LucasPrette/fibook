import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

}
