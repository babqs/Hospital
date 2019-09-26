/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Tutor;
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
public class DAOTutorTest {

    public DAOTutorTest() {
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

    @Test
    public void testInserir() {
        Tutor tutor = new Tutor();
        DAO<Tutor> dao = new DAO(Tutor.class);
        dao.inserir(tutor);
    }

    @Test
    public void testListar() {
        List<Tutor> lista = new DAO(Tutor.class).listarTodos();
        for (Tutor tutor : lista) {
            System.out.println(tutor);
        }

    }
}
