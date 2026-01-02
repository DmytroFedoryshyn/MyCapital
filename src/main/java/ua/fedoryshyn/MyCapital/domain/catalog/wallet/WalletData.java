package ua.fedoryshyn.MyCapital.domain.catalog.wallet;

import java.math.BigDecimal;

public interface WalletData {
    String getTitle();
    BigDecimal getBalance();
    String getName();
    String getCurrency();
}
