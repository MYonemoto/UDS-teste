package br.com.uds.udsservice.repository;

import br.com.uds.udsservice.models.PizzaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<PizzaModel, Long> {
}
