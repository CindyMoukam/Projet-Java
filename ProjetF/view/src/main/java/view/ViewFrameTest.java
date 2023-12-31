package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IController;
import contract.IModel;

public class ViewFrameTest {

    IController controller;
    IModel model;
    ViewFrame viewFrame;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        viewFrame=new ViewFrame();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetController() {
        assertNull(controller);

    }

    @Test
    public void testSetController() {
        assertNull(controller);
    }

    @Test
    public void testGetCompteur() {
        assertEquals(2,this.viewFrame.getLevel_counter());
    }

    @Test
    public void testSetCompteur() {


    }

    @Test
    public void testGetModel() {
        assertNull(model);
    }

    @SuppressWarnings("static-access")
    @Test
    public void testViewFrame() {

        assertNotNull(viewFrame.panel1);
        assertNotNull(viewFrame.panel2);
        assertNotNull(viewFrame.panel3);
        assertNotNull(viewFrame.panel4);
        assertNotNull(viewFrame.panel5);
    }
}