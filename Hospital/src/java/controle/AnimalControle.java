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
import modelo.Consulta;
import modelo.Tutor;

@ManagedBean
@ViewScoped
public class AnimalControle implements Serializable {

    private List<Animal> listaAnimal;
    private Animal animal;
    private DAO<Animal> daoAnimal;
    private List<Tutor> listaTutor;
    private Tutor tutor;
    private DAO<Tutor> daoTutor;
    private boolean popupNovo;
    private boolean popupAltera;
    private boolean popupHistorico;

    public AnimalControle() {
        animal = new Animal();
        daoAnimal = new DAO(Animal.class);
        listaAnimal = daoAnimal.listarTodos();
        tutor = new Tutor();
        daoTutor = new DAO(Tutor.class);
        listaTutor = daoTutor.listarTodos();
        popupNovo = false;
        popupAltera = false;
        popupHistorico = false;
    }

    public DAO<Animal> getDaoAnimal() {
        return daoAnimal;
    }

    public void setDaoAnimal(DAO<Animal> daoAnimal) {
        this.daoAnimal = daoAnimal;
    }

    public void salvar() throws ExcecaoObjetoNaoEncontrado {
        Tutor tutorEscolhido = daoTutor.buscarPorNome(this.animal.getTutor().getNome());
        animal.setTutor(tutorEscolhido);
        daoAnimal.inserir(animal);
        listaAnimal = daoAnimal.listarTodos();
        fecharPopupNovo();
    }

    public void alterar() {
//        daoAnimal.alterar(animal);
//        listaAnimal = daoAnimal.listarTodos(); 
//        animal = new Animal(); 
//        fecharPopupAltera();
        abrePopupAltera();
    }

    public void alterarAnimal() {
      
        daoAnimal.alterar(animal);
        listaAnimal = daoAnimal.listarTodos();
        fecharPopupAltera();
    }

    public void excluir(Animal animal) {
        daoAnimal.excluir(animal.getId());
        listaAnimal.remove(animal);
    }
    
    public void mostraHistorico(Animal animal){
//        abrePopupHistorico();
//        DAO<Consulta> daoConsulta = new DAO(Consulta.class);
//        List<Consulta> listaConsulta = daoConsulta.listarTodos();
//        List<Consulta> listaConsultaAux = daoConsulta.listarTodos();
//        for (Consulta c : listaConsulta){
//            if(c.getAnimalConsultado().getId()==animal.getId())
//            {
//                System.out.println(c.getData());
//            }
//        }
        

        
    }

    public void abrePopupNovo() {
        this.popupNovo = true;
        animal = new Animal();

    }

    public void fecharPopupNovo() {
        this.popupNovo = false;
    }

    public void abrePopupAltera() {
        this.popupAltera = true;
    }

    public void fecharPopupAltera() {
        this.popupAltera = false;
    }
        public void fecharPopupConsulta() {
        this.popupHistorico = false;
    }

    public void abrePopupHistorico() {
        this.popupHistorico = true;
    }

    public boolean isPopupHistorico() {
        return popupHistorico;
    }

    public void setPopupHistorico(boolean popupHistorico) {
        this.popupHistorico = popupHistorico;
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