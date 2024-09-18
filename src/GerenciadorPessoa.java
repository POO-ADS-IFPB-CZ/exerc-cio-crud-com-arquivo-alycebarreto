package src;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class GerenciadorPessoa {
    private Set<Pessoa> pessoas;
    private final String arquivo = "pessoas.dat";

    public GerenciadorPessoa() {
        pessoas = carregarPessoas();
    }

    private Set<Pessoa> carregarPessoas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            // Aqui estamos utilizando uma verificação de tipo
            @SuppressWarnings("unchecked") // Suprimir o aviso
            Set<Pessoa> pessoasCarregadas = (Set<Pessoa>) ois.readObject();
            return pessoasCarregadas;
        } catch (FileNotFoundException e) {
            return new HashSet<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }    

    public void salvarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        salvarPessoas();
    }

    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            pessoas.forEach(System.out::println);
        }
    }

    public void deletarPessoa(String email) {
        if (pessoas.removeIf(p -> p.getEmail().equals(email))) {
            System.out.println("Pessoa deletada com sucesso.");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
        salvarPessoas();
    }

    private void salvarPessoas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(pessoas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
