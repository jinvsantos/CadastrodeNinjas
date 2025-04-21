package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //Mostrar todos os ninjas
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar ninjas";
    }

    //Mostrar ninjas por ID
    @GetMapping("/todosID")
    public String mostrarNinjaPorId(){
        return "Mostrar Ninja por Id";
    }

    //Alterar dados do ninja
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Ninja alterado por ID";
    }

    //Deletar Ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }



}
