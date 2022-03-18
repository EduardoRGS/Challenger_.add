package com.api.school.controller;

import com.api.school.model.Aluno;
import com.api.school.repository.AlunoRepository;
import com.api.school.service.AlunoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/escola/alunos/salvar")
    public String createStudent (@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult result, Model model){
        if(result.hasErrors()){
            return "/escola/alunos/form";
        }
        alunoRepository.save(aluno);
        return "redirect:/escola/alunos";
    }
    @GetMapping("escola/alunos/novo")
    public String newStudent(Model model){
        model.addAttribute("aluno", new Aluno());
        return "/escola/alunos/form";
    }

    @GetMapping("/escola/alunos")
    public String listAllStudents (Model model){
        model.addAttribute("listaAlunos", alunoRepository.findAll());
        return "/escola/alunos/index";
    }

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
