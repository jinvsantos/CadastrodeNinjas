package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;


    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Listar ninjas por ID
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Deletar um ninja
    public void deletarNinjaPorId(Long id){
         ninjaRepository.deleteById(id);
    }

    //Atualizar Ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return  ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }
}
