package br.com.uds.udsservice.models.enums;

import br.com.uds.udsservice.models.interfaces.PizzaInterface;
import br.com.uds.udsservice.models.PizzaModel;

import java.math.BigDecimal;

public enum Tamanho implements PizzaInterface {

    PEQUENA {
        public BigDecimal getValorTotal(PizzaModel pizzaModel) {
            pizzaModel.setValorTotal(new BigDecimal(20.00));
            return new BigDecimal(20.00);
        }

        public Integer getTempoDePreparo(PizzaModel pizzaModel) {
            pizzaModel.setTempoDePreparo(15);
            return 15;
        }
    },
    MEDIA {
        public BigDecimal getValorTotal(PizzaModel pizzaModel) {
            pizzaModel.setValorTotal(new BigDecimal(30.00));
            return new BigDecimal(30.00);
        }

        public Integer getTempoDePreparo(PizzaModel pizzaModel) {
            pizzaModel.setTempoDePreparo(20);
            return 20;
        }
    },
    GRANDE {
        public BigDecimal getValorTotal(PizzaModel pizzaModel) {
            pizzaModel.setValorTotal(new BigDecimal(40.00));
            return new BigDecimal(40.00);
        }

        public Integer getTempoDePreparo(PizzaModel pizzaModel) {
            pizzaModel.setTempoDePreparo(25);
            return 25;
        }
    }
}
