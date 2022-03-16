package com.api.school.controller;

import com.api.school.model.Escola;
import com.api.school.service.EscolaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/escola")
@Slf4j
public class EscolaController {

    EscolaService escolaService;

    @PostMapping("/cadastrar")
    public Escola createSchool (@RequestBody Escola escola){
        return escolaService.createSchool(escola);
    }

    @GetMapping("/lista")
    public List<Escola> listAllSchools () {
        return escolaService.getAllSchools();
    }

    @GetMapping("lista/{id}")
    public ResponseEntity<Escola> listSchoolById (@PathVariable (value = "id")Long id){
        return escolaService.findByIdSchool(id);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Escola> updateSchool (@PathVariable (value = "id") Long id,
                                                @RequestBody Escola escola){
        return escolaService.updateSchoolById(escola, id);
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity<Object> deleteSchool (@PathVariable (value = "id") Long id){
        return  escolaService.deleteSchoolById(id);
    }

}
