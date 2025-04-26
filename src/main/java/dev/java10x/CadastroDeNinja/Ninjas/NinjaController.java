package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar ninja
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostrar ninjas por ID
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados do ninja
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }

}
