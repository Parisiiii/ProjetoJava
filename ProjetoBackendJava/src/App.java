import javax.swing.JOptionPane;

import dao.ClienteSetDAO;
import dao.IClienteDAO;
import domain.Cliente;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteSetDAO();


        String opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair", "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        
        while( !isOpcaoValida(opcao)) {
            if("".equals(opcao)){
                sair();
            }

            opcao = JOptionPane.showInputDialog(null, "Opção inválida digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair", "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while(isOpcaoValida(opcao)){
            if(isOpcaoSair(opcao)){
                sair();
            }else if(isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separado por virgula. Ex: Nome, cpf, telefone, endereço, numero, cidade, estado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            }else if(isConsulta(opcao)){
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF do cliente:","Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            }else if(isExclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF do cliente: ", "Exclusão cliente", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            }else{
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separado por virgula. Ex: Nome, cpf, telefone, endereço, numero, cidade, estado", "Atualização", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }


            opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair", "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private static void atualizar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3],
                dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
        iClienteDAO.alterar(cliente);
    }

    private static void excluir(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            iClienteDAO.excluir(Long.parseLong(dados));
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!","ERRO", JOptionPane.INFORMATION_MESSAGE);
        }


    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado com sucesso: "  + cliente.getNome()+ " / " + cliente.getCpf() + " / " + cliente.getTel() + " / " + cliente.getEnd(), "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3],
                dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado!", "Falha",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private static boolean isConsulta(String opcao){
        if("2".equals(opcao)){
            return true;
        }

        return false;
    }


    private static boolean isExclusao(String opcao){
        if("3".equals(opcao)){
            return true;
        }

        return false;
    }


    private static boolean isCadastro(String opcao){
        if("1".equals(opcao)){
            return true;
        }

        return false;
    }


    private static void sair(){
        String clientesCadastrados = "";
        for(Cliente cli : iClienteDAO.buscarTodos()){
            clientesCadastrados += cli.toString() + "\n";
        }
        System.exit(0);
    }

    private static boolean isOpcaoSair(String opcao){
        if("5".equals(opcao)){
            return true;
        }

        return false;
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao)
                || "3".equals(opcao) || "4".equals(opcao)
                || "5".equals(opcao)) {
            return true;
        }

        return false;
    }
}
