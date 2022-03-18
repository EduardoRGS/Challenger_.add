package com.api.school.service;

import com.api.school.model.Escola;
import com.api.school.repository.EscolaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EscolaService {


    private EscolaRepository escolaRepository;

    public Escola createSchool(Escola escola) {
        return escolaRepository.save(escola);
    }

    public List<Escola> getAllSchools() {
        return escolaRepository.findAll();
    }

    public ResponseEntity<Escola> findByIdSchool(Long id) {
        return escolaRepository.findById(id)
                .map(school -> ResponseEntity.ok().body(school))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Escola> updateSchoolById(Escola escola, Long id){
        return escolaRepository.findById(id)
                .map(schoolUpdate -> {
                    schoolUpdate.setNome(escola.getNome());
                    schoolUpdate.setEndereco(escola.getEndereco());
                    schoolUpdate.setTurmas(escola.getTurmas());
                    Escola update = escolaRepository.save(schoolUpdate);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteSchoolById(Long id) {
        return escolaRepository.findById(id)
                .map(schoolDelete -> {
                    escolaRepository.deleteById(id);;
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}