/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import modelo.Tutor;
import java.util.List;
import modelo.Administrador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import modelo.Animal;
import modelo.Consulta;
import modelo.Veterinario;

/**
 *
 * @author CC11619405962
 */
public class DAOTest {

    public DAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void testInserir() {
//        Administrador adm = new Administrador();
//        DAO<Administrador> dao = new DAO(Administrador.class);
//        adm.setNome("baq");
//        adm.setLogin("baq");
//        adm.setSenha("1234");
//        adm.setId(1);
//        dao.inserir(adm);
//    }
//    
//     @Test
//    public void testInserir() {
//        Tutor tutor = new Tutor();
//        tutor.setNome("Ana");
//        DAO<Tutor> dao = new DAO(Tutor.class);
//        dao.inserir(tutor);
//    }
//     
//    @Test
//    public void testInserir() {
//        Veterinario vet = new Veterinario();
//        vet.setNome("Claudio");
//        DAO<Veterinario> dao = new DAO(Veterinario.class);
//        dao.inserir(vet);
//    }
//        @Test
//    public void testInserir() throws ExcecaoObjetoNaoEncontrado {
//       DAO<Veterinario> dao = new DAO(Veterinario.class);       
//       DAO<Animal> daoAnimal = new DAO(Animal.class); 
//       Consulta consulta = new Consulta();
//        consulta.setVeterinario(dao.buscarPorCodigo(4));
//        consulta.setAnimalConsultado(daoAnimal.buscarPorCodigo(3));
//        DAO<Consulta> daoConsulta = new DAO(Consulta.class);
//        daoConsulta.inserir(consulta);
//    }
////    
//    @Test
//    public void testListar(){ 
//        List<Veterinario> lista = new DAO(Veterinario.class).listarTodos();
//        for(Veterinario vet : lista){
//            System.out.println(vet);
//        }
//    }    
//    
//    @Test
//    public void testListar(){ 
//        List<Administrador> lista = new DAO(Administrador.class).listarTodos();
//        for(Administrador adm : lista){
//            System.out.println(adm);
//        }
//    }
//    @Test
//    public void testListar(){
//        List<Tutor> lista = new DAO(Tutor.class).listarTodos();
//        for(Tutor tutor : lista){
//            System.out.println(""+tutor.getNome()+"|Id = "+tutor.getId());
//            for (Animal a:tutor.getListaAnimal())
//            {
//                System.out.println(a.getNomeAnimal());
//            }
//        }
//    }
//
//    @Test
//    public void testListar(){
//        List<Animal> lista = new DAO(Animal.class).listarTodos();
//        for(Animal animal : lista){
//            System.out.println(animal);
//        }
//    }
//    
//         @Test
//    public void testInserir() {
//        Tutor t = (Tutor)new DAO(Tutor.class).buscarPorCodigo(1);
//        Animal animal = new Animal();
//        animal.setTutor(t);
//        animal.setNomeAnimal("Rogério");
//        DAO<Animal> dao = new DAO(Animal.class);
//        dao.inserir(animal);
//    }
}
