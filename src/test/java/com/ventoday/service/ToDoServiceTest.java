package com.ventoday.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ventoday.model.ToDo;
import com.ventoday.repository.ToDoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ToDoServiceTest {
	
	@Mock
	private ToDoRepository toDoRepository;
	
	@InjectMocks
	private ToDoServiceImpl toDoService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllToDo(){
		List<ToDo> toDoList = new ArrayList<ToDo>();
		toDoList.add(new ToDo(1,"Todo Sample 1",true));
		toDoList.add(new ToDo(2,"Todo Sample 2",true));
		toDoList.add(new ToDo(3,"Todo Sample 3",false));
		when(toDoRepository.findAll()).thenReturn(toDoList);
		
		List<ToDo> result = toDoService.getAllToDo();
		Assertions.assertThat(3).isEqualTo(result.size());
	}
	
	@Test
	public void testGetToDoById(){
		ToDo toDo = new ToDo(1,"Todo Sample 1",true);
		when(toDoRepository.findOne(1L)).thenReturn(toDo);
		ToDo result = toDoService.getToDoById(1);
		Assertions.assertThat(1).isEqualTo(result.getId());
		Assertions.assertThat("Todo Sample 1").isEqualTo(result.getText());
		Assertions.assertThat(true).isEqualTo(result.isCompleted());
	}
	
	@Test
	public void saveToDo(){
		ToDo toDo = new ToDo(8,"Todo Sample 8",true);
		when(toDoRepository.save(toDo)).thenReturn(toDo);
		ToDo result = toDoService.saveToDo(toDo);
		Assertions.assertThat(8).isEqualTo(result.getId());
		Assertions.assertThat("Todo Sample 8").isEqualTo(result.getText());
		Assertions.assertThat(true).isEqualTo(result.isCompleted());
	}
	
	@Test
	public void removeToDo(){
		ToDo toDo = new ToDo(8,"Todo Sample 8",true);
		toDoService.removeToDo(toDo);
        verify(toDoRepository, times(1)).delete(toDo);
	}
	
	

}

