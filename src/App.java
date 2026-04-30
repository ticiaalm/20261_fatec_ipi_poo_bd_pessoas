// ORM - Object Relation Mapping: Mapeamento Objeto Relacional
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
                        
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Tente novamente mais tarde.");
            }
        } while(opcao != 0);
    }
}
