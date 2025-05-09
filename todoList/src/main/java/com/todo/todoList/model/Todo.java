package com.todo.todoList.model;

public class Todo {
    private Long id;
    private String task;
    private boolean completed;

    public Todo(){}

    public Todo(Long id, String task, boolean completed){
        this.id=id;
        this.task=task;
        this.completed=completed;
    }


    //getters and setters
    //getters
    public Long getId(){
        return id;                   
    }
    public String getTask() {
        return task;
    }
    public boolean isCompleted() {
        return completed;
    }

    //setters
    public void setId(Long id) {
        this.id=id;
    }
    public void setTask(String task) {
        this.task=task;
    }
    public void setCompleted(boolean completed) {
        this.completed=completed;
    }
}
    

