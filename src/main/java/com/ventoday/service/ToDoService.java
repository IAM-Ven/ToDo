package com.ventoday.service;

import java.util.List;

import com.ventoday.model.ToDo;

public interface ToDoService {
	public List<ToDo> getAllToDo();
	public ToDo getToDoById(long id);
	public ToDo updateToDo(ToDo todo);
	public ToDo saveToDo(ToDo todo);
	public void removeToDo(ToDo todo);
}
