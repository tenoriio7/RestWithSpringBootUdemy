package br.com.viniciust.controller;

import br.com.viniciust.services.GitUserService;
import br.com.viniciust.services.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
@RestController
@RequestMapping("/git")
public class GitUserController {
    @Autowired
    private GitUserService services;

    @GetMapping(value="/{user}")
    public ResponseEntity getGitUser(@PathVariable("user")String user) throws IOException {
        Map<String,String> map = services.getGitUser(user);
        return ResponseEntity.ok(map);
    }
}
