package br.com.uds.udsservice.service;

//import br.com.uds.udsservice.models.ExtrasModel;
import br.com.uds.udsservice.models.PizzaModel;
import br.com.uds.udsservice.models.PizzaModelIn;
import br.com.uds.udsservice.models.enums.Extra;
import br.com.uds.udsservice.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PizzaService {

    @Autowired
    PizzaRepository pizzaRepository;

    /**
     * Calcula o tempo de preparo e o valor total da pizza, sem persistir no banco.
     * @param pizza
     * @return pizzaModel
     */
    public PizzaModel calcularTempoEValor(PizzaModelIn pizza) {

        PizzaModel pizzaModel = new PizzaModel();

        pizzaModel.setTamanho(pizza.getTamanho());
        pizzaModel.setSabor(pizza.getSabor());

        pizza.getTamanho().getTempoDePreparo(pizzaModel);
        pizza.getSabor().getTempoDePreparo(pizzaModel);

        pizzaModel.setTempoDePreparo(pizza.getSabor().getTempoDePreparo(pizzaModel));

        pizza.getTamanho().getValorTotal(pizzaModel);
        pizza.getSabor().getValorTotal(pizzaModel);

        pizzaModel.setValorTotal(pizza.getSabor().getValorTotal(pizzaModel));

        calculoExtras(pizza, pizzaModel);

        return pizzaModel;
    }

    /**
     * Calcula o valor total e o tempo de preparo somado com os extras.
     * @param pizza
     * @param pizzaModel
     * @return pizzaModel
     */
    public PizzaModel calculoExtras(PizzaModelIn pizza, PizzaModel pizzaModel) {

        if (pizza.getExtras() != null) {
            List<String> extrasModelList = new ArrayList<>();
            Map<String, Integer> adicionais = new HashMap<>();

            for (Extra extra: pizza.getExtras()) {
                switch (extra) {
                    case EXTRA_BACON:
                        pizzaModel.setValorTotal(pizzaModel.getValorTotal().add(new BigDecimal(3.00)));
                        extrasModelList.add("EXTRA_BACON");
                        adicionais.put("valorAdicionalExtraBacon", 3);
                        adicionais.put("tempoDePreparoAdicionalExtraBacon", 0);
                        pizzaModel.setAdicionais(adicionais);
                        break;

                    case BORDA_RECHEADA:
                        pizzaModel.setValorTotal(pizzaModel.getValorTotal().add(new BigDecimal(5.00)));
                        pizzaModel.setTempoDePreparo(pizzaModel.getTempoDePreparo() + 5);
                        extrasModelList.add("BORDA_RECHEADA");
                        adicionais.put("valorAdicionalBordaRecheada", 5);
                        adicionais.put("tempoDePreparoAdicionalBordaRecheada", 5);
                        pizzaModel.setAdicionais(adicionais);
                        break;
                }

            }

            pizzaModel.setExtras(extrasModelList);
        } else {
            return pizzaModel;
        }
        return pizzaModel;
    }

    /**
     * Persiste no banco.
     * @param pizza
     * @return pizzaModel
     */
    public PizzaModel salvar(PizzaModelIn pizza) {
        PizzaModel pizzaModel = calcularTempoEValor(pizza);
        pizzaRepository.save(pizzaModel);

        return pizzaModel;
    }

}
