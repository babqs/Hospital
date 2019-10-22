
package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Tutor;

@ManagedBean (name = "novoTutor")
@ViewScoped

public class NovoTutor implements Serializable {
    
    private Tutor tutor;
    private DAO<Tutor> dao;
    private Animal animal;
    private List<Tutor> listaTutor;
    private List<Animal> listaAnimal;
    private DAO<Animal> dao2;
    
     public NovoTutor(){
        tutor = new Tutor();
        dao = new DAO(Tutor.class);
        listaTutor = dao.listarTodos();
        dao2 = new DAO(Animal.class);
        listaAnimal = dao2.listarTodos();
        
    }

    public List<Tutor> getListaTutor() {
        return listaTutor;
    }

    public void setListaTutor(List<Tutor> listaTutor) {
        this.listaTutor = listaTutor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public DAO<Tutor> getDao() {
        return dao;
    }

    public void setDao(DAO<Tutor> dao) {
        this.dao = dao;
    }
    
    public void salvar(){
        dao.inserir(tutor);
    }  

    public void salvarAnimal(){
        dao2.inserir(animal);
    }
    
}
