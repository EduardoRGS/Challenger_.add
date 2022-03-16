package com.api.school.service;

import com.api.school.model.Endereco;
import com.api.school.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public Endereco createAndress(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> getAllAndress(){
        return enderecoRepository.findAll();
    }

    public ResponseEntity<Endereco> findByIdAndress(Long id){
        return enderecoRepository.findById(id)
                .map(andress -> ResponseEntity.ok().body(andress))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Endereco> updateAndressById(Endereco endereco, Long id){
        return enderecoRepository.findById(id)
                .map(andressUpdate -> {
                    andressUpdate.setLograudouro(endereco.getLograudouro());
                    andressUpdate.setComplemento(endereco.getComplemento());
                    andressUpdate.setBairro(endereco.getBairro());
                    andressUpdate.setCidade(endereco.getCidade());
                    andressUpdate.setEstado(endereco.getEstado());
                    Endereco update = enderecoRepository.save(andressUpdate);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteAndressById(Long id){
        return enderecoRepository.findById(id)
                .map(andressDelete -> {
                    enderecoRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
