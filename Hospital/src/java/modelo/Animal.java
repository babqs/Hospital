package modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String nome;

    @Column(length = 30)
    private String classe;

    @Column(length = 30)
    private String raca;

    @Column
    private Integer idadeAnimal;

    @ManyToOne
    @JoinColumn(name = "tutor")
    private Tutor tutor;
    
    @OneToMany(mappedBy = "animal", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> listaConsulta;

    public Animal() {
        this.classe = "";
        this.raca = "";
        this.nome = "";
        this.idadeAnimal = 0;
        this.tutor = new Tutor();
        this.listaConsulta = new ArrayList();
        
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdadeAnimal() {
        return idadeAnimal;
    }

    public void setIdadeAnimal(Integer idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<Consulta> getListaConsulta() {
        return listaConsulta;
    }

    public void setListaConsulta(List<Consulta> listaConsulta) {
        this.listaConsulta = listaConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.classe);
        hash = 47 * hash + Objects.hashCode(this.raca);
        hash = 47 * hash + Objects.hashCode(this.idadeAnimal);
        hash = 47 * hash + Objects.hashCode(this.tutor);
        hash = 47 * hash + Objects.hashCode(this.listaConsulta);
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
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.classe, other.classe)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idadeAnimal, other.idadeAnimal)) {
            return false;
        }
        if (!Objects.equals(this.tutor, other.tutor)) {
            return false;
        }
        if (!Objects.equals(this.listaConsulta, other.listaConsulta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nome=" + nome + ", classe=" + classe + ", raca=" + raca + ", idadeAnimal=" + idadeAnimal + ", tutor=" + tutor + ", listaConsulta=" + listaConsulta + '}';
    }

    
 

}
