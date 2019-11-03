package br.com.uds.udsservice.models.enums;

import br.com.uds.udsservice.models.interfaces.PizzaInterface;
import br.com.uds.udsservice.models.PizzaModel;

import java.math.BigDecimal;

public enum Extra implements PizzaInterface {

    EXTRA_BACON {
        public BigDecimal getValorTotal(PizzaModel pizzaModel) {
            return pizzaModel.getValorTotal().add(new BigDecimal(3.00));
        }

        public Integer getTempoDePreparo(PizzaModel pizzaModel) {
            return pizzaModel.getTempoDePreparo();
        }
    },
    SEM_CEBOLA {
        public BigDecimal getValorTotal(PizzaModel pizzaModel) {
            return pizzaModel.getValorTotal();
        }

        public Integer getTempoDePreparo(PizzaModel pizzaModel) {
            return pizzaModel.getTempoDePreparo();
        }
    },
    BORDA_RECHEADA {
        public BigDecimal getValorTotal(PizzaModel pizzaModel) {
            return pizzaModel.getValorTotal().add(new BigDecimal(5.00));
        }

        public Integer getTempoDePreparo(PizzaModel pizzaModel) {
            return pizzaModel.getTempoDePreparo() + 5;
        }
    }
}
