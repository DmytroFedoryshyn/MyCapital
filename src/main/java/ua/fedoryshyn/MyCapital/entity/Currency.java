package ua.fedoryshyn.MyCapital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import ua.fedoryshyn.MyCapital.entity.base.PersonalEntity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "currency")
public class Currency extends PersonalEntity {

    @Column(name = "alpha_code", length = 3, nullable = false)
    private String alphaCode;

    @Column(name = "numeric_code", length = 3, nullable = false)
    private String numericCode;

    @Column(name = "symbol", length = 5, nullable = false)
    private String symbol;

    @Column(name = "decimals", nullable = false)
    private Integer decimals;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "flag_emoji", length = 8)
    private String flagEmoji;


    public Currency() {

    }
}
