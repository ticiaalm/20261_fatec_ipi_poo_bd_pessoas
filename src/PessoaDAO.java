// DAO - Data Access Object: Objeto de Acesso a Dados
// JDBC: Java DataBase Connectivity
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class PessoaDAO {
    public void cadastrar(Pessoa p) throws Exception {
        // 1. Definir o comando SQL
        var sql = 
        "INSERT INTO tb_pessoa(nome, fone, email) VALUES(?, ?, ?)";

        // 2. Estabelecer uma conexão com o SGBD
        var conexao = ConnectionFactory.obterConexao();

        // 3. Preparar o comando
        PreparedStatement ps = conexao.prepareStatement(sql);

        // 4. Substituir os eventuais placeholders
        ps.setString(1, p.getNome());
        ps.setString(2, p.getFone());
        ps.setString(3, p.getEmail());

        // 5. Executar o comando
        ps.execute();
        ps.close();
        conexao.close();   
    }
    public List <Pessoa> listar() throws Exception {
        // 1. Construir uma lista de pessoas
        List<Pessoa> pessoas = new ArrayList<>();

        // 2. Definir o comando SQL
        var sql = "SELECT * FROM tb_pessoa";

        // 3. Estabelecer uma conexão com o banco
        // 4. Preparar o comando
        // 5. Substituir os eventuais placeholders
        // 6. Executar o comando
        try (
            var conexao = ConnectionFactory.obterConexao();
            var ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            // 7. Tratar o resultado
            rs.next();
            var codigo = rs.getInt("cod_pessoa");
            var nome = rs.getString("nome");
            var fone = rs.getString("fone");
            var email = rs.getString("email");
            var pessoa = 
                Pessoa.builder()
                .codigo(codigo)
                .nome(nome)
                .fone(fone)
                .email(email)
                .build();
            pessoas.add(pessoa);
        }
    }
}