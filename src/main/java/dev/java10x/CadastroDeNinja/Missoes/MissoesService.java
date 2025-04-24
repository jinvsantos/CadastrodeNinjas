package dev.java10x.CadastroDeNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    //Injeção de dependencia
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Criar Missão
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Listar Missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //Listar Missão por ID
    public MissoesModel listarMissaoPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    //Alterar Missão
    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada){
        if (missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }


    //Deletar Missão
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }
}
