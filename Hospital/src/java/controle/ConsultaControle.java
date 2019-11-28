package controle;

import dao.DAO;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Consulta;
import modelo.Veterinario;

@ManagedBean (name = "consultaControle")
@ViewScoped

public class ConsultaControle implements Serializable {

    private Veterinario veterinario;
    private Animal animal;
    private DAO<Consulta> daoConsultas;
    private DAO<Animal> daoanimalConsulta;
    private DAO<Veterinario> daoveterinarioConsulta;
    private List<Consulta> listaConsulta;
    private List<Veterinario> listaconsultaVeterinario;
    private List<Animal> listaconsultaAnimal;
    private Consulta consulta;
    private boolean popupNovo;
    private boolean popupAltera;

    public ConsultaControle() {
        veterinario = new Veterinario();
        animal = new Animal();
        daoanimalConsulta = new DAO(Animal.class);
        daoveterinarioConsulta = new DAO(Veterinario.class);
        daoConsultas = new DAO(Consulta.class);
        listaConsulta = daoConsultas.listarTodos();
        listaconsultaVeterinario = daoveterinarioConsulta.listarTodos();
        listaconsultaAnimal = daoanimalConsulta.listarTodos();
        popupNovo = false;
        popupAltera = false;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public DAO<Consulta> getDaoConsultas() {
        return daoConsultas;
    }

    public void setDaoConsultas(DAO<Consulta> daoConsultas) {
        this.daoConsultas = daoConsultas;
    }

    public DAO<Animal> getDaoanimalConsulta() {
        return daoanimalConsulta;
    }

    public void setDaoanimalConsulta(DAO<Animal> daoanimalConsulta) {
        this.daoanimalConsulta = daoanimalConsulta;
    }

    public DAO<Veterinario> getDaoveterinarioConsulta() {
        return daoveterinarioConsulta;
    }

    public void setDaoveterinarioConsulta(DAO<Veterinario> daoveterinarioConsulta) {
        this.daoveterinarioConsulta = daoveterinarioConsulta;
    }

    public List<Consulta> getListaConsulta() {
        return listaConsulta;
    }

    public void setListaConsulta(List<Consulta> listaConsulta) {
        this.listaConsulta = listaConsulta;
    }

    public List<Veterinario> getListaconsultaVeterinario() {
        return listaconsultaVeterinario;
    }

    public void setListaconsultaVeterinario(List<Veterinario> listaconsultaVeterinario) {
        this.listaconsultaVeterinario = listaconsultaVeterinario;
    }

    public List<Animal> getListaconsultaAnimal() {
        return listaconsultaAnimal;
    }

    public void setListaconsultaAnimal(List<Animal> listaconsultaAnimal) {
        this.listaconsultaAnimal = listaconsultaAnimal;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
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

   public void abrePopupNovo(){
        this.popupNovo = true;
        consulta = new Consulta();
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

    
    public void alterarConsulta() { 
        daoConsultas.alterar(consulta);
        listaConsulta = daoConsultas.listarTodos(); 
        consulta = new Consulta(); 
        fecharPopupAltera();
    }
    
    public void excluir(Consulta consulta){
        daoConsultas.excluir(consulta.getId());
        listaConsulta.remove(consulta);
    }


    public void salvar() throws ExcecaoObjetoNaoEncontrado {
        Veterinario veterinarioEscolhido = daoveterinarioConsulta.buscarPorNome(consulta.getVeterinario().getNome());
        consulta.setVeterinario(veterinarioEscolhido);
        Animal animal = daoanimalConsulta.buscarPorNome(consulta.getAnimal().getNome());
        consulta.setAnimal(animal);
        daoConsultas.inserir(consulta);
        listaConsulta = daoConsultas.listarTodos();
        
        fecharPopupNovo();
    }
    


 
}
