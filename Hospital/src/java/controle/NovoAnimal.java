/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Tutor;

@ManagedBean (name = "novoAnimal")
@ViewScoped

public class NovoAnimal implements Serializable {
    
    private Animal animalSelecionado;
    private DAO<Animal> dao;
    private List<Animal> animal;
    private List<Tutor> tutor;

    public List<Tutor> getTutor() {
        return tutor;
    }

    public void setTutor(List<Tutor> tutor) {
        this.tutor = tutor;
    }
    
    public NovoAnimal(){
        animalSelecionado = new Animal();
        dao = new DAO(Animal.class);
        animal = dao.listarTodos();
    }

    public Animal getAnimalSelecionado() {
        return animalSelecionado;
    }

    public void setAnimalSelecionado(Animal animalSelecionado) {
        this.animalSelecionado = animalSelecionado;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }
    
    
}

