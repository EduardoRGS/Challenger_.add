package com.api.school.controller;

import com.api.school.model.Endereco;
import com.api.school.service.EnderecoService;
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
@RequestMapping("/endereco")
@Slf4j
public class EnderecoController {

    EnderecoService enderecoService;

    @ApiOperation(value = "Criando um novo endereço")
    @ApiResponses({
            @ApiResponse(code = 201, message = "endereço criado com sucessoo"),
            @ApiResponse(code = 500, message = "Houve um erro ao criar um endereço, verifique as informações")
    })
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco createAndress (@RequestBody Endereco endereco){
        log.info("Criando um novo endereço com as informações [{}]", endereco);
        return enderecoService.createAndress(endereco);
    }

    @ApiOperation(value = "Listando todas os endereços")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endereços listados com sucessoo"),
            @ApiResponse(code = 500, message = "Houve um erro ao lista os endereços")
    })
    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Endereco> listAllAndress (){
        log.info("Listando todos os endereços cadastradas");
        return enderecoService.getAllAndress();
    }

    @ApiOperation(value = "Buscando um endereço pelo id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endereço encontrada com sucessoo"),
            @ApiResponse(code = 404, message = "Não foi encontrada nenhum endereço com esse id")
    })
    @GetMapping("listar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Endereco> listAndressById (@PathVariable (value = "id") Long id){
        log.info("Buscando um endereço com o id [{}]", id);
        return enderecoService.findByIdAndress(id);
    }

    @ApiOperation(value = "Atualizando as informações do endereço")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endereço atualizado com sucessoo"),
            @ApiResponse(code = 404 , message = "Não foi possivel atualizar o endereço - endereço não encontrado")
    })
    @PutMapping("editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Endereco> updadeAndress (@PathVariable (value = "id") Long id,
                                                       @RequestBody Endereco endereco){
        log.info("Atualizando o endereço com id [{}] as novas informações são: [{}]", id, endereco);
        return enderecoService.updateAndressById(endereco, id);
    }

    @ApiOperation(value = "Excluindo um endereço")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Endereço excluido com sucessoo"),
            @ApiResponse(code = 404, message = "Não foi possivel excluir o endereço - endereço não encontrada")
    })
    @DeleteMapping("excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteAndress(@PathVariable (value = "id") Long id){
        log.info("Excluindo os endereços com o id [{}]", id);
        return enderecoService.deleteAndressById(id);
    }
}