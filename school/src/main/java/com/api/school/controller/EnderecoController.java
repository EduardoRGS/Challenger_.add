package com.api.school.controller;

import com.api.school.model.Endereco;
import com.api.school.service.EnderecoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/endereco")
@Slf4j
public class EnderecoController {

    EnderecoService enderecoService;

    @PostMapping("/cadastrar")
    public Endereco createAndress (@RequestBody Endereco endereco){
        return enderecoService.createAndress(endereco);
    }

    @GetMapping("/lista")
    public List<Endereco> listAllAndress (){
        return enderecoService.getAllAndress();
    }

    @GetMapping("lista/{id}")
    public ResponseEntity<Endereco> listAndressById (@PathVariable (value = "id") Long id){
        return enderecoService.findByIdAndress(id);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Endereco> updadeAndress (@PathVariable (value = "id") Long id,
                                                       @RequestBody Endereco endereco){
        return enderecoService.updateAndressById(endereco, id);
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity<Object> deleteAndress(@PathVariable (value = "id") Long id){
        return enderecoService.deleteAndressById(id);
    }
}