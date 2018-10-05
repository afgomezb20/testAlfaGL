/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safesociety.fingerprint.services;

import com.safesociety.fingerprint.controller.ClientJpaController;
import com.safesociety.fingerprint.entities.Client;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andresgomez
 */
@RestController
public class ClientServicew {

    /*@RequestMapping("/clients")
    public String index() {
        return "<html><body><h1>Server running</h1></body></html";
    }*/
    ClientJpaController clientJpaController;

    private ClientJpaController getJpaController() {
        if (clientJpaController == null) {
            clientJpaController = new ClientJpaController(Persistence.createEntityManagerFactory("com.safesociety_fingerprint_war_1.0.0PU"));
        }
        return clientJpaController;
    }

    @GetMapping("/clients")
    public List<Client> getAllUsers() {
        return getJpaController().findClientEntities();
    }

    @PostMapping("/client")
    public Client createClient(@Valid @RequestBody Client client) {
        try {
            getJpaController().create(client);
        } catch (Exception ex) {
            Logger.getLogger(ClientServicew.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
}
