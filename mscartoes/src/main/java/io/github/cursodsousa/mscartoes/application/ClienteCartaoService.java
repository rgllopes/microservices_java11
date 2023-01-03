package io.github.cursodsousa.mscartoes.application;

import io.github.cursodsousa.mscartoes.domain.ClienteCartao;
import io.github.cursodsousa.mscartoes.infra.repository.IClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final IClienteCartaoRepository repository;

    public List<ClienteCartao> listCartaoByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
