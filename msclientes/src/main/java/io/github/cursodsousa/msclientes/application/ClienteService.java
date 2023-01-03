package io.github.cursodsousa.msclientes.application;

import io.github.cursodsousa.msclientes.domain.Cliente;
import io.github.cursodsousa.msclientes.infra.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor    //Lombok => construtor
public class ClienteService {

    private  final IClienteRepository _repository;

    @Transactional
    public Cliente save(Cliente cliente){
        return  _repository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf){
        return _repository.findByCpf(cpf);
    }
}
