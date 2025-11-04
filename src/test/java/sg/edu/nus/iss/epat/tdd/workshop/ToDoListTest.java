package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ToDoListTest  {
    // Define Test Fixtures
    private ToDoList todo;
    private Task t1, t2;

    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        todo = new ToDoList();
        t1 = new Task("Test 1");
        t2 = new Task("Test 2");
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
        todo = null;
        t1 = null;
        t2 = null;
    }

    @Test
    public void testAddTask() {
        todo.addTask(t1);
        assertEquals(t1, todo.getTask("Test 1"));
    }

    @Test
    public void testGetStatus() {
        todo.addTask(t1);
        // Initially false
        assertFalse(todo.getStatus("Test 1"));
        // After marking complete
        todo.completeTask("Test 1");
        assertTrue(todo.getStatus("Test 1"));
    }

    @Test
    public void testRemoveTask() {
        todo.addTask(t2);
        Task removed = todo.removeTask("Test 2");
        assertEquals(t2, removed);
        assertNull(todo.getTask("Test 2"));
    }

    @Test
    public void testGetCompletedTasks() {
        todo.addTask(t1);
        todo.addTask(t2);
        todo.completeTask("Test 1");
        assertEquals(1, todo.getCompletedTasks().size());
        assertTrue(todo.getCompletedTasks().contains(t1));
    }
}