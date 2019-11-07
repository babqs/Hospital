/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Tutor;



@ManagedBean
@ViewScoped
public class AnimalControle implements Serializable{
    
    private List<Animal> listaAnimal;
    private Animal animal;
    private DAO<Animal> daoAnimal;
    private List<Tutor> listaTutor;
    private Tutor tutor;
    private DAO<Tutor> daoTutor;
    private boolean popupNovo;
    private boolean popupAltera;
    
    public AnimalControle(){
    animal = new Animal();
    daoAnimal = new DAO(Animal.class);
    listaAnimal = daoAnimal.listarTodos();
    tutor = new Tutor();
    daoTutor = new DAO(Tutor.class);
    listaTutor = daoTutor.listarTodos();
    popupNovo = false;
    popupAltera = false;
    }

    public DAO<Animal> getDaoAnimal() {
        return daoAnimal;
    }

    public void setDaoAnimal(DAO<Animal> daoAnimal) {
        this.daoAnimal = daoAnimal;
    }

    public void salvar() throws ExcecaoObjetoNaoEncontrado{
        this.animal.getTutor().getNome();
        Tutor tutorEscolhido = daoTutor.buscarPorNome(this.animal.getTutor().getNome());
        animal.setTutor(tutorEscolhido);
        daoAnimal.inserir(animal);
        listaAnimal = daoAnimal.listarTodos();
        fecharPopupNovo();
    }
    
    public void alterarAnimal() { 
        daoAnimal.alterar(animal);
        listaAnimal = daoAnimal.listarTodos(); 
        animal = new Animal(); 
        fecharPopupAltera();
    }
    
    public void excluir(Animal animal){
        daoAnimal.excluir(animal.getIdAnimal());
        listaAnimal.remove(animal);
    }
    
    public void abrePopupNovo(){
        this.popupNovo = true;
        animal = new Animal();
        
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

    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

    public void setListaAnimal(List<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public DAO<Animal> getDao() {
        return daoAnimal;
    }

    public void setDao(DAO<Animal> dao) {
        this.daoAnimal = daoAnimal;
    }

    public List<Tutor> getListaTutor() {
        return listaTutor;
    }

    public void setListaTutor(List<Tutor> listaTutor) {
        this.listaTutor = listaTutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public DAO<Tutor> getDaoTutor() {
        return daoTutor;
    }

    public void setDaoTutor(DAO<Tutor> daoTutor) {
        this.daoTutor = daoTutor;
    }
    
    public boolean isPopupNovo() {
        return popupNovo;
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
