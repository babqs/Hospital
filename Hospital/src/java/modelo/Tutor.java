
package modelo;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Tutor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column(length = 30)
    private String nome;
    
    @Column(length = 14)
    private String cpf;
    
    @Column(length=100)
    private String endereco;
    
    @Column(length = 12)
    private Integer telefone;
    
    @OneToMany (mappedBy = "tutor", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Animal> listaAnimal;
    
    public Tutor(){
        this.nome = "";
        this.cpf = "";
        this.endereco = "";
        this.telefone = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

    public void setListaAnimal(List<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.cpf);
        hash = 41 * hash + Objects.hashCode(this.endereco);
        hash = 41 * hash + Objects.hashCode(this.telefone);
        hash = 41 * hash + Objects.hashCode(this.listaAnimal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tutor other = (Tutor) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.listaAnimal, other.listaAnimal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tutor{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone + ", listaAnimal=" + listaAnimal + '}';
    }
}
