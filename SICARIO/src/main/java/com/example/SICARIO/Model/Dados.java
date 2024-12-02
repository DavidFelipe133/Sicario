package com.example.SICARIO.Model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class Dados {

    private static List<Cliente> listaClientes = new ArrayList<>();
    private static List<Funcionario> listaFunc = new ArrayList<>();
    private static List<Agendamentos> listaAgenda = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public static List<Cliente> listarClientes() {
        return listaClientes;
    }

    public static void excluirCliente(Integer id) {
        listaClientes.removeIf(c -> c.getId().equals(id));
    }

    public static Cliente obtemCliente(Integer id) {
        return listaClientes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public static void adicionarFunc(Funcionario func) {
        listaFunc.add(func);
    }

    public static List<Funcionario> listarFunc() {
        return listaFunc;
    }

    public static void excluirFunc(Integer id) {
        listaFunc.removeIf(f -> f.getId().equals(id));
    }

    public static Funcionario obtemFunc(Integer id) {
        return listaFunc.stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
    }

    public static void adicionarAgendamento(Agendamentos agend) {
        listaAgenda.add(agend);
    }

    public static List<Agendamentos> listarAgenda() {
        return listaAgenda;
    }

    public static void excluirAgenda(Integer id) {
        listaAgenda.removeIf(a -> a.getId().equals(id));
    }

    public static Agendamentos obtemAgenda(Integer id) {
        return listaAgenda.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    public static void atualizarAgendamento(Agendamentos agenda) {
        for (Agendamentos agen : listaAgenda) {
            if (agen.getId().equals(agenda.getId())) {
                agen.setCliente(agenda.getCliente());
                agen.setDescricao(agenda.getDescricao());
                agen.setFunc(agenda.getFunc());
                agen.setStatus(agenda.getStatus());
                agen.setValor(agenda.getValor());
                break;
            }
        }
    }
}
