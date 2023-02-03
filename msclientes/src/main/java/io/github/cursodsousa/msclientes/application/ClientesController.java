package io.github.cursodsousa.msclientes.application;

import io.github.cursodsousa.msclientes.application.representation.ClienteSaveRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.logging.Logger;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
@Slf4j
public class ClientesController {
    @Autowired      //Não é mais obrigatório, Spring detecta instancia da classe ja realiza a injeção da dependencia
    private final ClienteService _service;

    @GetMapping
    public  String status(){
        log.info("Obtendo o status do microservice de clientes");
        return "Microservice clientes OK";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest request){
        var cliente = request.toModel();
        _service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()               // Para URL dinamica
                .query("cpf{cpf}")                  // Para receber o parametro via url
                .buildAndExpand(cliente.getCpf())   //Build url com os parametros de fromCurrentRequest e query
                .toUri();

        //created => código 201 de sucesso do POST
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf){
        var cliente = _service.getByCPF(cpf);
        if(cliente.isEmpty()){
            return  ResponseEntity.notFound().build();
        }

        //ok => código 200 de sucesso GET
        return  ResponseEntity.ok(cliente);
    }
}
