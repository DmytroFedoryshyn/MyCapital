package ua.fedoryshyn.MyCapital.domain.catalog.wallet;

import ua.fedoryshyn.MyCapital.domain.base.DomainObject;

public class Wallet extends DomainObject {
    private final WalletData state;

    public Wallet(WalletData state) {
        this.state = state;
    }
}
