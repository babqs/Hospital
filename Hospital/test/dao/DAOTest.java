/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Tutor;
import java.util.List;
import modelo.Administrador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
//        dao.inserir(adm);
//    }
    
//     @Test
//    public void testInserir() {
//        Tutor tutor = new Tutor();
//        DAO<Tutor> dao = new DAO(Tutor.class);
//        dao.inserir(tutor);
//    }
//    
//    @Test
//    public void testListar(){
//        List<Administrador> lista = new DAO(Administrador.class).listarTodos();
//        for(Administrador adm : lista){
//            System.out.println(adm);
//        }
    @Test
    public void testListar(){
        List<Tutor> lista = new DAO(Tutor.class).listarTodos();
        for(Tutor tutor : lista){
            System.out.println(tutor);
        }
    
    }
}
