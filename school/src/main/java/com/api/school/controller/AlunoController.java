package com.api.school.controller;

import com.api.school.model.Aluno;
import com.api.school.service.AlunoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("aluno")
@Slf4j
public class AlunoController {

    AlunoService alunoService;

    @PostMapping("cadastrar")
    public Aluno createStudent (@RequestBody Aluno aluno){
        return alunoService.createStudent(aluno);
    }

    @GetMapping("lista")
    public List<Aluno> listAllStudents (){
        return alunoService.getAllStudents();
    }

    @GetMapping("lista/{id}")
    public ResponseEntity<Aluno> listStudentById (@PathVariable (value = "id")Long id){
        return alunoService.findByIdStudent(id);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Aluno> updateStudent (@PathVariable (value = "id") Long id,
                                                @RequestBody Aluno aluno){
        return alunoService.updateStudentById(aluno, id);
    }

    @DeleteMapping("excluio/{id}")
    public ResponseEntity<Object> deleteStudent (@PathVariable (value = "id")Long id){
        return alunoService.deleteStudentById(id);
    }
}
