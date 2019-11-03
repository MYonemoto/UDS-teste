package br.com.uds.udsservice.models.interfaces;

import br.com.uds.udsservice.models.PizzaModel;

import java.math.BigDecimal;

public interface PizzaInterface {

    public BigDecimal getValorTotal(PizzaModel pizzaModel);

    public Integer getTempoDePreparo(PizzaModel pizzaModel);
}
