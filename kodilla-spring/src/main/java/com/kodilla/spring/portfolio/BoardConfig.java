package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class BoardConfig {

    @Autowired
    Board board;

    @Bean
    public Board getBoard() {
        return new Board(getTodoList(), getInProgressList(), getDoneList());
    }

    @Bean(name = "toDoList")
    @Scope("prototype")
    TaskList getTodoList() {

        return new TaskList("1todo");
    }

    @Bean("inProgress")
    @Scope("prototype")
    TaskList getInProgressList() {
        return new TaskList("1inProgress", "2inProgress");

    }

    @Bean("doneList")
    @Scope("prototype")
    TaskList getDoneList() {

        return new TaskList("1done", "2done", "3done");

    }


}
