package com.example.Controller;

import io.micronaut.http.annotation.*;

import java.util.ArrayList;

import com.example.Class.User;

// Controller "seta" o prefixo das rotas que estão na classe
@Controller("/user")
public class UserController {
    
    // GET, POST, PUT, DELETE são "indicadores" do que aquelas funções irão realizar
    
    private ArrayList<User> list = new ArrayList<>();

    // GET: retorna dados
    @Get("/list")
    public String getUser(){
        if(list.size() <= 0) return "Sem usuários";
        String aux = "";
        for (User user : list) {
            aux+= user;
        }
        return aux;
    }

    // POST: insere dados
    // @Body exige que os dados sejam passados por meio do body
    @Post("/insert")
    public String insertUser(@Body User user){
        if(user == null) return "Erro de Inserção";
        System.out.println(user);
        list.add(user);
        return "Inserção realizada com sucesso";
    }


    // DELETE: apaga dados
    // @QueryValue exige que os dados sejam passados por querry, exemplo -> user/delete?id=X
    @Delete("/delete")
    public String deleteUser(@QueryValue int id){
        if(id > list.size()) return "Erro ao deletar";
        User aux = list.remove(id);
        return "Removido com sucesso - " + aux;
    }

    // PUT: altera os dados, realiza update
    // @PathVariable exige que os dados sejam passados pela url, exemplo -> user/update/{id}
    @Put("/update/{id}")
    public String updateUser(@PathVariable int id, @Body User user){
        if (id > list.size() || user == null) return "Erro ao realizar update";
        list.remove(id);
        list.add(user);
        return "Sucesso ao alterar";
    }
    
}