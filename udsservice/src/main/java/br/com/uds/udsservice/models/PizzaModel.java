package br.com.uds.udsservice.models;

import br.com.uds.udsservice.models.enums.Extra;
import br.com.uds.udsservice.models.enums.Sabor;
import br.com.uds.udsservice.models.enums.Tamanho;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "PIZZA")
public class PizzaModel implements Serializable {

    @Id
    @SequenceGenerator(name="pizza_seq", sequenceName = "pizza_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizza_seq")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TAMANHO", nullable = false)
    private Tamanho tamanho;

    @Column(name = "SABOR", nullable = false)
    private Sabor sabor;

    @Column(name = "TEMPO_DE_PREPARO")
    private Integer tempoDePreparo;

    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;

    @ElementCollection(targetClass=String.class)
    private List<String> extras;

    @ElementCollection(targetClass= Integer.class)
    private Map<String, Integer> adicionais;
}
