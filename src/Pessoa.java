package src;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pessoa)) return false;
        Pessoa other = (Pessoa) obj;
        return this.email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", E-mail: " + email;
    }
}
