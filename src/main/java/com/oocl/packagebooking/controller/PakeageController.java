package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Pakeage;
import com.oocl.packagebooking.exception.ReapplyException;
import com.oocl.packagebooking.service.PakeageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/pakeages")
public class PakeageController {

    @Autowired
    private PakeageService pakeageService;

    @GetMapping()
    public ResponseEntity findAll(HttpServletResponse response) {
        return ResponseEntity.ok().body(pakeageService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findByState(@PathVariable String state) {
       return pakeageService.findPakeageByState(state);
    }

    @PostMapping()
    public ResponseEntity creatPakeage(Pakeage pakeage) {
        pakeageService.addPageage(pakeage);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity applyPakeage(@RequestBody Pakeage pakeage,@PathVariable Integer id,String appointment) throws ReapplyException {
        return pakeageService.applyPakeage(pakeage,id,appointment);
    }




//    @PostMapping
//    public ResponseEntity createTodoMvc(@RequestBody ToDoMvc toDoMvc) throws ItemNotNniqueException {
//        toDoMvcService.addTodoMvc(toDoMvc);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

}
