package br.com.api.dao;

import br.com.api.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.*;

public class ClienteMapDAO implements IClienteDAO {

    private Map<Long, Cliente> map;

    public ClienteMapDAO() {
        map = new TreeMap<>();
    }
    @Override
    public boolean cadastrar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())) {
            return false;
        }
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = map.get(cpf);

        if (clienteCadastrado != null) {
            map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = map.get(cliente.getCpf());

        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setEstado(cliente.getEstado());
            clienteCadastrado.setNumero(cliente.getNumero());
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return map.values();
    }
}
