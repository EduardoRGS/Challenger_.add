package com.api.school.service;

import com.api.school.model.Aluno;
import com.api.school.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository alunoRepository;

    public Aluno createStudent(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> getAllStudents(){
        return alunoRepository.findAll();
    }

    public ResponseEntity<Aluno> findByIdStudent(Long id) {
        return alunoRepository.findById(id)
                .map(student -> ResponseEntity.ok().body(student))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Aluno> updateStudentById(Aluno aluno, Long id){
        return alunoRepository.findById(id)
                .map(studentUpdate -> {
                    studentUpdate.setNome(aluno.getNome());
                    studentUpdate.setDataDeNascimento(aluno.getDataDeNascimento());
                    studentUpdate.setEscola(aluno.getEscola());
                    studentUpdate.setTurma(aluno.getTurma());
                    Aluno update = alunoRepository.save(studentUpdate);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteStudentById(Long id){
        return  alunoRepository.findById(id)
                .map(studentDelete -> {
                    alunoRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
