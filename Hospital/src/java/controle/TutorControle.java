
package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Tutor;

@ManagedBean (name = "tutorControle")
@ViewScoped

public class TutorControle implements Serializable {
    
    private Tutor tutor;
    private DAO<Tutor> daoTutor;
    private Animal animal;
    private List<Tutor> listaTutor;
    private List<Animal> listaAnimal;
    private DAO<Animal> daoAnimal;
    private boolean popupNovo;
    private boolean popupAltera;
    
     public TutorControle(){
        tutor = new Tutor();
        daoTutor= new DAO(Tutor.class);
        listaTutor = daoTutor.listarTodos();
        daoAnimal = new DAO(Animal.class);
        listaAnimal = daoAnimal.listarTodos();
        popupNovo = false;
        popupAltera = false;
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
        return daoTutor;
    }

    public void setDao(DAO<Tutor> dao) {
        this.daoTutor= dao;
    }
    
    public void salvar(){
        if (tutor.getNome()!=""){
        daoTutor.inserir(tutor);
        listaTutor = daoTutor.listarTodos();
        fecharPopupNovo();
        }
    }

//    public void salvarAnimal(){
//        daoAnimal.inserir(animal);
//    }
    
    public void abrePopupNovo(){
        tutor = new Tutor();
        this.popupNovo = true;
    }
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
     public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }
    
    public void alterar(){
        abrePopupAltera();
    }
    
    public void alterarTutor() {
        daoTutor.alterar(tutor);
        listaTutor = daoTutor.listarTodos();
        tutor = new Tutor(); 
        fecharPopupAltera();
    }
    
    public void excluir(Tutor tutor){
        daoTutor.excluir(tutor.getId());
        listaTutor.remove(tutor);
    }
    
    public boolean isPopupNovo() {
        return popupNovo;
    }

    public DAO<Tutor> getDaoTutor() {
        return daoTutor;
    }

    public void setDaoTutor(DAO<Tutor> daoTutor) {
        this.daoTutor = daoTutor;
    }

    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

    public void setListaAnimal(List<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }

    public DAO<Animal> getDaoAnimal() {
        return daoAnimal;
    }

    public void setDaoAnimal(DAO<Animal> daoAnimal) {
        this.daoAnimal = daoAnimal;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }
    
    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
    }
}
