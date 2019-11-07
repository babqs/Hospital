
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Animal implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnimal;
    
    @Column (length=30)
    private String nomeAnimal;
    
    @Column (length=30)
    private String classe;
    
    @Column (length = 30)
    private String raca;
    
    @Column
    private Integer idadeAnimal;
    
    @ManyToOne
    @JoinColumn(name= "tutor")
    private Tutor tutor;
    
    public Animal(){
        this.classe = "";
        this.raca = "";
        this.nomeAnimal = "";
        this.idadeAnimal = 0;
        this.tutor = new Tutor();
    }
    
    public Animal(String classe, String raca, String nome, Integer idade, Tutor tutor){
        this.classe = classe;
        this.raca = raca;
        this.nomeAnimal = nomeAnimal;
        this.idadeAnimal = idadeAnimal;
        this.tutor = tutor;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idAnimal);
        hash = 67 * hash + Objects.hashCode(this.nomeAnimal);
        hash = 67 * hash + Objects.hashCode(this.classe);
        hash = 67 * hash + Objects.hashCode(this.raca);
        hash = 67 * hash + Objects.hashCode(this.idadeAnimal);
        hash = 67 * hash + Objects.hashCode(this.tutor);
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
        if (!Objects.equals(this.nomeAnimal, other.nomeAnimal)) {
            return false;
        }
        if (!Objects.equals(this.classe, other.classe)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        if (!Objects.equals(this.idAnimal, other.idAnimal)) {
            return false;
        }
        if (!Objects.equals(this.idadeAnimal, other.idadeAnimal)) {
            return false;
        }
        if (!Objects.equals(this.tutor, other.tutor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "idAnimal=" + idAnimal + ", nomeAnimal=" + nomeAnimal + ", classe=" + classe + ", raca=" + raca + ", idadeAnimal=" + idadeAnimal + ", tutor=" + tutor + '}';
    }
    
    
}
