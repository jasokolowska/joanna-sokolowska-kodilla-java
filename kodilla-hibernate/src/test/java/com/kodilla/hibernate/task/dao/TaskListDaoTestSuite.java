package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.TaskList;
import static org.junit.jupiter.api.Assertions.*;

import com.kodilla.hibernate.task.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    public TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: Hibernate Exercise";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("ToDo", "List of tasks to do");
        taskListDao.save(taskList);
        String name = taskList.getListName();

        //When
        List<TaskList> listName = taskListDao.findByListName(name);
        int id = taskList.getId();

        //Then
        assertEquals("ToDo", listName.get(0).getListName());

        //CleanUp
        taskListDao.deleteById(id);

    }

    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList("ToDo", "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        assertNotEquals(0, id);

//        CleanUp
        taskListDao.deleteById(id);
    }
}
