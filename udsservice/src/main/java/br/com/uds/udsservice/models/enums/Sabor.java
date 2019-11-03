package br.com.uds.udsservice.models.enums;

import br.com.uds.udsservice.models.interfaces.PizzaInterface;
import br.com.uds.udsservice.models.PizzaModel;

import java.math.BigDecimal;

public enum Sabor implements PizzaInterface {

    CALABRESA {
        public BigDecimal getValorTotal(PizzaModel pizzaModel) {
            return pizzaModel.getValorTotal();
        }

        public Integer getTempoDePreparo(PizzaModel pizzaModel) {
            return pizzaModel.getTempoDePreparo();
        }
    },
    MARGUERITA {
        public BigDecimal getValorTotal(PizzaModel pizzaModel) {
            return pizzaModel.getValorTotal();
        }

        public Integer getTempoDePreparo(PizzaModel pizzaModel) {
            return pizzaModel.getTempoDePreparo();
        }
    },
    PORTUGUESA {
        public BigDecimal getValorTotal(PizzaModel pizzaModel) {
            return pizzaModel.getValorTotal();
        }

        public Integer getTempoDePreparo(PizzaModel pizzaModel) {
            return pizzaModel.getTempoDePreparo() + 5;
        }
    }

}
