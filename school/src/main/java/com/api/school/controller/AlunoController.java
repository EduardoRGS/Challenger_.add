package com.api.school.controller;

import com.api.school.model.Aluno;
import com.api.school.repository.AlunoRepository;
import com.api.school.service.AlunoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class AlunoController {

    AlunoService alunoService;
    AlunoRepository alunoRepository;

    @ApiOperation(value = "Cadastrando um novo(a) aluno(a) pelo front-end")
    @PostMapping("/escola/alunos/salvar")
    public String createStudent (@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult result, Model model){
        if(result.hasErrors()){
            return "/escola/alunos/form";
        }
        alunoRepository.save(aluno);
        return "redirect:/escola/alunos";
    }

    @ApiOperation(value = "Adicionando um novo(a) aluno(a) pelo front-end")
    @GetMapping("escola/alunos/novo")
    public String newStudent(Model model){
        model.addAttribute("aluno", new Aluno());
        return "/escola/alunos/form";
    }

    @ApiOperation(value = "Listando todos novos(a) alunos(as) pelo front-end")
    @GetMapping("/escola/alunos")
    public String listAllStudents (Model model){
        model.addAttribute("listaAlunos", alunoRepository.findAll());
        return "/escola/alunos/index";
    }

    @ApiOperation(value = "Cadastrando um novo(a) aluno(a)")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Aluno(a) cadastrado com sucessoo"),
            @ApiResponse(code = 500, message = "Houve um erro ao cadastrar um(a) aluno(a), verifique as informações")
    })
    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno createStudent (@RequestBody Aluno aluno){
        log.info("Criando um(a) novo(a) aluno(a) com as informações [{}]", aluno);
        return alunoService.createStudent(aluno);
    }

    @ApiOperation(value = "Listando todos novos(a) alunos(as)")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Alunos(a) listados com sucessoo"),
            @ApiResponse(code = 500, message = "Houve um erro ao listar os(aa) alunos(as), verifique as informações")
    })
    @GetMapping("listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listAllStudents (){
        log.info("Listando todas os(as) alunos(as) cadastrados(as)");
        return alunoService.getAllStudents();
    }

    @ApiOperation(value = "Buscando um(a) aluno pelo id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Aluno encontrado(a) com sucessoo"),
            @ApiResponse(code = 404, message = "Não foi encontrada nenhuma aluno(a) com esse id")
    })
    @GetMapping("listar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Aluno> listStudentById (@PathVariable (value = "id")Long id){
        log.info("Buscando um(a) aluno(a) com o id [{}]", id);
        return alunoService.findByIdStudent(id);
    }

    @ApiOperation(value = "Atualizando as informações do aluno(a)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Dados do(a) aluno(a) atualizado(a) com sucessoo"),
            @ApiResponse(code = 404 , message = "Não foi possivel atualizar os dados do(a) aluno - aluno(a) não encontrado(a)")
    })
    @PutMapping("editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Aluno> updateStudent (@PathVariable (value = "id") Long id,
                                                @RequestBody Aluno aluno){
        log.info("Atualizando os dados do(a) aluno(a) com id [{}] as novas informações são: [{}]", id, aluno);
        return alunoService.updateStudentById(aluno, id);
    }

    @ApiOperation(value = "Excluindo um(a) aluno")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Aluno excluido(a) com sucessoo"),
            @ApiResponse(code = 404, message = "Não foi possivel excluir um(a) alunno(a) - aluno(a) não encontrado(a)")
    })
    @DeleteMapping("excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteStudent (@PathVariable (value = "id")Long id){
        log.info("Excluindo um(a) aluno(a) com o id [{}]", id);
        return alunoService.deleteStudentById(id);
    }
}
