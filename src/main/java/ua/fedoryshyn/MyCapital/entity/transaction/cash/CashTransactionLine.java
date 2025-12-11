package ua.fedoryshyn.MyCapital.entity.transaction.cash;

import jakarta.persistence.Embedded;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.entity.Category;
import ua.fedoryshyn.MyCapital.entity.CurrencyAmount;
import ua.fedoryshyn.MyCapital.entity.project.Project;

@Getter
@Setter
@MappedSuperclass
public class CashTransactionLine {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Embedded
    private CurrencyAmount amount;
}
