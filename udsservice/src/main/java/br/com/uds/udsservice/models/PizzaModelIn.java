package br.com.uds.udsservice.models;

import br.com.uds.udsservice.models.enums.Extra;
import br.com.uds.udsservice.models.enums.Sabor;
import br.com.uds.udsservice.models.enums.Tamanho;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PizzaModelIn {

    @NotNull(message = "O tamanho da pizza não pode ser nulo!")
    private Tamanho tamanho;

    @NotNull(message = "O sabor da pizza não pode ser nulo!")
    private Sabor sabor;

    private List<Extra> extras;
}
