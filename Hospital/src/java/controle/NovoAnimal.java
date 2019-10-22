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
    
    private Animal animal;
    private DAO<Animal> dao;
    private List<Animal> listaAnimal;
    private Tutor tutor;
    
//    private List<Tutor> tutor;
//
//    public List<Tutor> getTutor() {
//        return tutor;
//    }
//
//    public void setTutor(List<Tutor> tutor) {
//        this.tutor = tutor;
//    }
    
    public NovoAnimal(){
        animal = new Animal();
        dao = new DAO(Animal.class);
        listaAnimal = dao.listarTodos();
        
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }

    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

    public void setListaAnimal(List<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    
    public void salvar(){
        dao.inserir(animal);
    }
}

