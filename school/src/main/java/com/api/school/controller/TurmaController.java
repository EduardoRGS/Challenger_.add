package com.api.school.controller;

import com.api.school.model.Turma;
import com.api.school.service.TurmaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/turma")
@Slf4j
public class TurmaController {

    TurmaService turmaService;

    @PostMapping("cadastrar")
    public Turma createTeam (@RequestBody Turma turma){
        return  turmaService.createTeam(turma);
    }

    @GetMapping("listar")
    public List<Turma> listAllTeams(){
        return turmaService.getAllTeam();
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<Turma> listTeamById (@PathVariable (value = "id")Long id){
        return turmaService.findByIdTeam(id);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Turma> updateTeam (@PathVariable (value = "id")Long id,
                                             @RequestBody Turma turma){
        return turmaService.updateTeamByid(turma, id);
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity<Object> deleteTeam (@PathVariable (value = "id")Long id){
        return turmaService.deleteTeamById(id);
    }
}
