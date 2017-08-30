package com.hermes.training.spring.mvc.web.todos;

import com.hermes.training.spring.mvc.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initializeTodoList(ModelMap model) {
        model.put(
                "name",
                "user");
        model.addAttribute(
                "todos",
                todoRepository.findAllTodos());
        return "home";
    }
}
