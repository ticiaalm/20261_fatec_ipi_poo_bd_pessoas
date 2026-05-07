// ORM - Object Relation Mapping: Mapeamento Objeto Relacional
import java.util.List;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        var menu = 
        "1 - Cadastrar\n2 - Visualizar\n3 - Atualizar\n4 - Remover\n0 - Sair";
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            try {
                switch(opcao) {
                    case 1: {
                    var nome = JOptionPane.showInputDialog("Nome?");
                        var fone = JOptionPane.showInputDialog("Fone?");
                        var email = JOptionPane.showInputDialog("E-mail?");
                        var pessoa = 
                            Pessoa.builder()
                            .nome(nome)
                            .fone(fone)
                            .email(email)
                            .build();
                        var dao = new PessoaDAO();
                        dao.cadastrar(pessoa);
                        JOptionPane.showMessageDialog(null, "Cadastro ok!");
                        break; 
                    }
                    case 2: {
                        List <Pessoa> pessoas = PessoaDAO.listar();
                        var sb = new StringBuilder("");
                        for (Pessoa pessoa : pessoas) { // for each ou enhanced for
                            sb.append(pessoa).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                        break;
                    }
                    case 3: {
                        var codigo = Integer.parseInt(JOptionPane.showInputDialog("Código?"));
                        var nome = JOptionPane.showInputDialog("Nome?");
                        var fone = JOptionPane.showInputDialog("Fone?");
                        var email = JOptionPane.showInputDialog("E-mail?");
                        var p =
                            Pessoa.builder()
                            .codigo(codigo)
                            .nome(nome)
                            .fone(fone)
                            .email(email)
                            .build();
                        var dao = new PessoaDAO();
                        dao.atualizar(p);
                        JOptionPane.showMessageDialog(null, "Atualização ok!");
                        break;
                    }
                    case 4: {
                        var codigo = Integer.parseInt(JOptionPane.showInputDialog("Código?"));
                        var p =
                            Pessoa.builder()
                            .codigo(codigo)
                            .build();
                        var dao = new PessoaDAO();
                        dao.apagar(p);
                        JOptionPane.showMessageDialog(null, "Apagou!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Tente novamente mais tarde.");
            }
        } while (opcao != 0);
    }
}
