package com.santos_caroline.userDept.controllers;

import com.santos_caroline.userDept.entities.User;
import com.santos_caroline.userDept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
@Controller → indica que a classe recebe requisições HTTP

@ResponseBody → faz o retorno dos métodos ser convertido automaticamente em JSON
Ou seja, tudo que você retornar vira JSON na resposta.

@RequestBody → dizer ao framework que o corpo da requisição HTTP (JSON, XML, etc.) deve ser convertido em um objeto Java e injetado
como parâmetro do método.
    Lê o corpo da requisição.
    Converte automaticamente o JSON para um objeto User
    (isso é feito pelo HttpMessageConverter, normalmente usando Jackson).
    Injeta o objeto já populado no parâmetro do método.


 */

@RestController
@RequestMapping(value = "/users")  //define um endpoint para requisição
public class UserController {

    @Autowired //ao invés de ficar instanciando o objeto vamos fazer injeção de dependência
    private UserRepository repository; // = new… >> não precisa instânciar

    @GetMapping //requisição GET HTTP
    public List<User> findAll(){
        List<User> result = repository.findAll(); //retorna TODOS os usuários
        return result;
    }

    @GetMapping(value = "/{id}") //define um endpoint para requisição GET de id
    public User findById(@PathVariable Long id){ //@PathVariable indica que o valor do parâmetro da URL (um
                    // trecho do caminho) deve ser mapeado para o parâmetro do método (no caso id).
        User result = repository.findById(id).get(); //boa prática: colocar tratativa de exceção
        return result;
    }
    @PostMapping() //
    public User insert (@RequestBody User user){ // Corpo da requisição (JSON, XML, etc.)
        User result = repository.save(user);
        return result;
    }
}
