package br.com.uds.udsservice.resources;

import br.com.uds.udsservice.models.PizzaModel;
import br.com.uds.udsservice.models.PizzaModelIn;
import br.com.uds.udsservice.repository.PizzaRepository;
import br.com.uds.udsservice.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaResource {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaService pizzaService;

    /**
     * Endpoint para calcular o tempo de preparo e o valor total da pizza.
     * @param pizza
     * @return pizzaModel
     */
    @PostMapping(value = "/calcular", produces = MediaType.APPLICATION_JSON_VALUE)
    public PizzaModel calcularTempoEValor(@Valid @RequestBody PizzaModelIn pizza) {

        return pizzaService.calcularTempoEValor(pizza);
    }

    /**
     * Endpoint para criar uma pizza, bem como persistir no banco.
     * @param pizza
     * @return pizzaModel
     */
    @PostMapping(value = "/criar", produces = MediaType.APPLICATION_JSON_VALUE)
    public PizzaModel criarPizza(@Valid @RequestBody PizzaModelIn pizza) {

        return pizzaService.salvar(pizza);
    }

    /**
     * Endpoint que retorna todas as pizzas do cliente
     * @return List<PizzaModel>
     */
    @GetMapping(value = "/getTodasPizzas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PizzaModel> getTodasPizzas() {
        return pizzaRepository.findAll();
    }
}
