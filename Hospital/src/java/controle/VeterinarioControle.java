package controle;

import dao.DAO;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Consulta;
import modelo.Veterinario;

@ManagedBean(name="veterinarioControle")
@ViewScoped
public class VeterinarioControle implements Serializable{
    
    private Veterinario veterinario;
    private Consulta consulta;
    private List<Consulta> listaConsulta;
    private List<Veterinario> listaVeterinario;
    private DAO<Veterinario> daoVeterinario;
    private DAO<Consulta> daoConsulta;
    private DAO<Animal> daoAnimal;
    private boolean popupNovo;
    private boolean popupAltera;
    
    public VeterinarioControle() {
        veterinario = new Veterinario();
        consulta = new Consulta();
        daoConsulta = new DAO(Consulta.class);
        listaConsulta = daoConsulta.listarTodos();
        daoVeterinario = new DAO(Veterinario.class);
        listaVeterinario = daoVeterinario.listarTodos();
        popupNovo = false;
        popupAltera = false;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Consulta> getListaConsulta() {
        return listaConsulta;
    }

    public void setListaConsulta(List<Consulta> listaConsulta) {
        this.listaConsulta = listaConsulta;
    }

    public List<Veterinario> getListaVeterinario() {
        return listaVeterinario;
    }

    public void setListaVeterinario(List<Veterinario> listaVeterinario) {
        this.listaVeterinario = listaVeterinario;
    }

    public DAO<Veterinario> getDaoVeterinario() {
        return daoVeterinario;
    }

    public void setDaoVeterinario(DAO<Veterinario> daoVeterinario) {
        this.daoVeterinario = daoVeterinario;
    }

    public DAO<Consulta> getDaoConsulta() {
        return daoConsulta;
    }

    public void setDaoConsulta(DAO<Consulta> daoConsulta) {
        this.daoConsulta = daoConsulta;
    }

    public DAO<Animal> getDaoAnimal() {
        return daoAnimal;
    }

    public void setDaoAnimal(DAO<Animal> daoAnimal) {
        this.daoAnimal = daoAnimal;
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
    
    public void fecharPopupNovo() {
        this.popupNovo = false;
    }

    public void abrePopupNovo() {
        this.popupNovo = true;
        veterinario = new Veterinario();
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
    
    public void salvar() throws ExcecaoObjetoNaoEncontrado {
        daoVeterinario.inserir(veterinario);
        listaVeterinario = daoVeterinario.listarTodos();
        fecharPopupNovo();
    }
    
    public void alterarVeterinario() { 
        daoVeterinario.alterar(veterinario);
        listaVeterinario = daoVeterinario.listarTodos(); 
        veterinario = new Veterinario(); 
        fecharPopupAltera();
    }
    
    public void excluir(Veterinario veterinario ){
        daoVeterinario.excluir(veterinario.getId());
        listaVeterinario.remove(veterinario);
    } 
}
