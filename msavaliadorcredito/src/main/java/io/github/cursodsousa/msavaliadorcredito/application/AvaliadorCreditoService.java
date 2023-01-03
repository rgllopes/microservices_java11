package io.github.cursodsousa.msavaliadorcredito.application;

import io.github.cursodsousa.msavaliadorcredito.domain.model.DadosCliente;
import io.github.cursodsousa.msavaliadorcredito.domain.model.SituacaoCliente;
import io.github.cursodsousa.msavaliadorcredito.infra.clients.IClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final IClienteResourceClient clientesClient;
    public SituacaoCliente obterSituacaoCliente(String cpf){
        //obter dados do do cliente - msclientes
        //obter cartoes do cliente - mscartoes

        ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);

        return SituacaoCliente
                .builder()
                .cliente(dadosClienteResponse.getBody())
                .build();
    }
}
