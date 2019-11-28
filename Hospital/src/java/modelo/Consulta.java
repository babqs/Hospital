package modelo;

import java.util.Date;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
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
import java.util.Calendar;
import java.time.LocalDate;

@Entity
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (length = 10)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "veterinario")
    private Veterinario veterinario;

    @Column(length = 300)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "animal")
    private Animal animal;

    public Consulta() {
        this.data = new Date();
        this.veterinario = new Veterinario();
        this.observacoes = "";
        this.animal = new Animal();
        this.id = 0;
    }

    public Date getData() {
        return data;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Integer getId() {
        return id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.data);
        hash = 59 * hash + Objects.hashCode(this.veterinario);
        hash = 59 * hash + Objects.hashCode(this.observacoes);
        hash = 59 * hash + Objects.hashCode(this.animal);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.veterinario, other.veterinario)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consulta{" + "data=" + data + ", veterinario=" + veterinario + ", observacoes=" + observacoes + ", id=" + id + ", animalConsultado=" + animal + '}';
    }

}
