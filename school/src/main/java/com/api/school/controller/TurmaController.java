package com.api.school.controller;

import com.api.school.model.Turma;
import com.api.school.service.TurmaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/turma")
@Slf4j
public class TurmaController {

    TurmaService turmaService;

    @ApiOperation(value = "Criando uma nova turma")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Turma criada com sucessoo"),
            @ApiResponse(code = 500, message = "Houve um erro ao criar uma turma, verifique as informações")
    })
    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Turma createTeam (@RequestBody Turma turma){
        log.info("Criando uma nova turma com as informações [{}]", turma);
        return  turmaService.createTeam(turma);
    }

    @ApiOperation(value = "Listando todas as turmas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Turmas listadas com sucessoo"),
            @ApiResponse(code = 500, message = "Houve um erro ao lista todas as turmas")
    })
    @GetMapping("listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Turma> listAllTeams(){
        log.info("Listando todas as turmas cadastradas");
        return turmaService.getAllTeam();
    }

    @ApiOperation(value = "Buscando uma turma pelo id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Turma encontrada com sucessoo"),
            @ApiResponse(code = 404, message = "Não foi encontrada nenhuma turma com esse id")
    })
    @GetMapping("listar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Turma> listTeamById (@PathVariable (value = "id")Long id){
        log.info("Buscando uma turma com o id [{}]", id);
        return turmaService.findByIdTeam(id);
    }

    @ApiOperation(value = "Atualizando as informações da turma")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Turma atualizada com sucessoo"),
            @ApiResponse(code = 404 , message = "Não foi possivel atualizar a turma - turma não encontrada")
    })
    @PutMapping("editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Turma> updateTeam (@PathVariable (value = "id")Long id,
                                             @RequestBody Turma turma){
        log.info("Atualizando a turma com id [{}] as novas informações são: [{}]", id, turma);
        return turmaService.updateTeamByid(turma, id);
    }

    @ApiOperation(value = "Excluindo uma turma")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Turma excluida com sucessoo"),
            @ApiResponse(code = 404, message = "Não foi possivel excluir a turma - turma não encontrada")
    })
    @DeleteMapping("excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTeam (@PathVariable (value = "id")Long id){
        log.info("Excluindo as turmas com o id [{}]", id);
        return turmaService.deleteTeamById(id);
    }
}
