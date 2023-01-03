package io.github.cursodsousa.msclientes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity             //Annotation do JPA(Java Persistence API)
@Data               //Lombok annotation, gera os getters/setters/construtor com campos obrigatórios/ToString/EqualAndHashCode
@NoArgsConstructor  //Lombok annotation, construtor sem argumentos
                    // (Importante para pesquisas para não estourar erro via reflection - utilizado para instanciação dinâmica)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @Column
    private String nome;
    @Column
    private  Integer idade;

    //Shortcut keys intellij => alt+ins
    public Cliente(String cpf, String nome, Integer idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }
}
