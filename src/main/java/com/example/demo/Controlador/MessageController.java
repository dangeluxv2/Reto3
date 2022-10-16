/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Message;
import com.example.demo.Servicio.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author angel
 */

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*")

public class MessageController {
    @Autowired
    private MessageService messageService;
    
    
    /*GET*/
    
    // Lee toda la tabla
    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }
    
    // Recibe un id devuelve los datos del id
    @GetMapping("/{id}")
    public Optional<Message> getClient(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }
    
    /*SAVE*/
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return messageService.save(message);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return messageService.update(message);
    }

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    
    public boolean delete(@PathVariable("id") int messageId){
        return messageService.deleteMessage(messageId);
    }
}
