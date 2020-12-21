package com.ventoday.service;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventoday.model.ToDo;
import com.ventoday.repository.ToDoRepository;

@Service("toDoService")
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService{


	private final ToDoRepository toDoRepository;

	@Override
	public List<ToDo> getAllToDo() {
		return toDoRepository.findAll();
	}

	@Override
	public ToDo getToDoById(long id) {
		return toDoRepository.findOne(id);
	}

	@Override
	public ToDo updateToDo(ToDo todo) {
		return toDoRepository.save(todo);
	}

	@Override
	public ToDo saveToDo(ToDo todo) {
		return toDoRepository.save(todo);
	}

	@Override
	public void removeToDo(ToDo todo) {
		toDoRepository.delete(todo);
	}


}
