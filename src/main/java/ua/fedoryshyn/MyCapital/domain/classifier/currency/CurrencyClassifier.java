package ua.fedoryshyn.MyCapital.domain.classifier.currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyClassifier {

    private String alphaCode;

    private String numericCode;

    private String symbol;

    private String name;

    private String flagEmoji;
}
