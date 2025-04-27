package dev.java10x.CadastroDeNinja.Missoes;

import dev.java10x.CadastroDeNinja.Ninjas.NinjaMapper;
import dev.java10x.CadastroDeNinja.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    //Injeção de dependencia
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Criar Missão
    public MissoesDTO criarMissao(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    //Listar Missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream().map(missoesMapper::map).collect(Collectors.toList());
    }

    //Listar Missão por ID
    public MissoesDTO listarMissaoPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    //Alterar Missão
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missaoDTO){
      Optional<MissoesModel> missaoExiste = missoesRepository.findById(id);
      if(missaoExiste.isPresent()){
          MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
          missaoAtualizada.setId(id);
          MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
          return missoesMapper.map(missaoSalva);
      }
      return null;
    }


    //Deletar Missão
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }
}
