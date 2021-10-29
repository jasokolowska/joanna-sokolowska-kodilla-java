package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

        //Then
        assertEquals("ToDo", listName.get(0).getListName());

    }
}
