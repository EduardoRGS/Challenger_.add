package com.api.school.service;

import com.api.school.model.Turma;
import com.api.school.repository.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurmaService{

    private TurmaRepository turmaRepository;

    public Turma createTeam(Turma turma){
        return turmaRepository.save(turma);
    }

    public List<Turma> getAllTeam (){
        return turmaRepository.findAll();
    }

    public ResponseEntity<Turma> findByIdTeam(Long id){
        return turmaRepository.findById(id)
                .map(team -> ResponseEntity.ok().body(team))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Turma> updateTeamByid(Turma turma, Long id) {
        return turmaRepository.findById(id)
                .map(teamUpdate -> {
                    teamUpdate.setNome(turma.getNome());
                    teamUpdate.setCapacidade(turma.getCapacidade());
                    Turma update = turmaRepository.save(teamUpdate);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteTeamById(Long id){
        return turmaRepository.findById(id)
                .map(teamDelete -> {
                    turmaRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
