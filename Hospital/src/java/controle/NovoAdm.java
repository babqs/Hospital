
package controle;

import dao.DAO;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import modelo.Administrador;
import javax.faces.bean.ManagedBean;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;

@ManagedBean (name = "novoAdm")
@ViewScoped

public class NovoAdm implements Serializable{
    
    private Administrador adm;
    private DAO<Administrador> dao;
    
    public NovoAdm(){
        adm = new Administrador();
        dao = new DAO(Administrador.class);
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public DAO<Administrador> getDao() {
        return dao;
    }

    public void setDao(DAO<Administrador> dao) {
        this.dao = dao;
    }
    
    public void salvar(){
        dao.inserir(adm);
    }
    
}
