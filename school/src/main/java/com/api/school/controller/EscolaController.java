package com.api.school.controller;

import com.api.school.model.Escola;
import com.api.school.service.EscolaService;
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
@RequestMapping("/escola")
@Slf4j
public class EscolaController {

    EscolaService escolaService;

    @ApiOperation(value = "Criando uma nova escola")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Escola criada com sucessoo"),
            @ApiResponse(code = 500, message = "Houve um erro ao criar uma escola, verifique as informações")
    })
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Escola createSchool (@RequestBody Escola escola){
        log.info("Criando uma nova escola com as informações [{}]", escola);
        return escolaService.createSchool(escola);
    }

    @ApiOperation(value = "Listando todas as escolas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Escolas listadas com sucessoo"),
            @ApiResponse(code = 500, message = "Houve um erro ao lista todas as escolas")
    })
    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Escola> listAllSchools () {
        log.info("Listando todas as tarefas escolas");
        return escolaService.getAllSchools();
    }

    @ApiOperation(value = "Buscando uma escola pelo id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Escola encontrada com sucessoo"),
            @ApiResponse(code = 404, message = "Não foi encontrada nenhuma escola com esse id")
    })
    @GetMapping("listar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Escola> listSchoolById (@PathVariable (value = "id")Long id){
        log.info("Buscando escola com o id [{}]", id);
        return escolaService.findByIdSchool(id);
    }

    @ApiOperation(value = "Atualizando as informações da escola")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Escola atualizada com sucessoo"),
            @ApiResponse(code = 404 , message = "Não foi possivel atualizar a escola - escola não encontrada")
    })
    @PutMapping("editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Escola> updateSchool (@PathVariable (value = "id") Long id,
                                                @RequestBody Escola escola){
        log.info("Atualizando a escola com id [{}] as novas informações são: [{}]", id, escola);
        return escolaService.updateSchoolById(escola, id);
    }

    @ApiOperation(value = "Excluindo uma escola")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Escola excluida com sucessoo"),
            @ApiResponse(code = 404, message = "Não foi possivel excluir a escola - escola não encontrada")
    })
    @DeleteMapping("excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteSchool (@PathVariable (value = "id") Long id){
        log.info("Excluindo escolas com o id [{}]", id);
        return  escolaService.deleteSchoolById(id);
    }

}
