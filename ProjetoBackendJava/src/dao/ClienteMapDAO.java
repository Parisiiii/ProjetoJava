package dao;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import domain.Cliente;

public class ClienteMapDAO implements IClienteDAO{
    private Map<Long, Cliente> map;

    public ClienteMapDAO(){map = new TreeMap<>(); }

    @Override
    public Boolean cadastrar(Cliente cli){
        if(map.containsValue(cli.getCpf())){
            return false;
        }

        map.put(cli.getCpf(), cli);
        return true;
    }


    @Override
    public void excluir(Long cpf){
        Cliente cliCadastrado = map.get(cpf);
        map.remove(cliCadastrado.getCpf(), cliCadastrado);
    }

    @Override
    public void alterar(Cliente cliente){
        Cliente clienteCadastrado = map.get(cliente.getCpf());
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setTel(cliente.getTel());
        clienteCadastrado.setNumero(cliente.getNumero());
        clienteCadastrado.setEnd(cliente.getEnd());
        clienteCadastrado.setCpf(cliente.getCpf());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setEstado(cliente.getEstado());
    }

    @Override
    public Cliente consultar(Long cpf){return this.map.get(cpf);}

    @Override
    public Collection<Cliente> buscarTodos(){
        return this.map.values();
    }
}
