package dev.java10x.CadastroDeNinja.Missoes;

import dev.java10x.CadastroDeNinja.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }


    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);

    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
        return missoesService.atualizarMissao(id, missaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }
}
