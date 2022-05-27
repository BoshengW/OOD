package eWallet.eWalletMVC.controllers;

import eWallet.eWalletMVC.biz.EWalletService;

import java.math.BigDecimal;

public class EWalletController {

    // 转账
    public void transfer(Long id, Long to, BigDecimal amount) {
        EWalletService eWalletService = new EWalletService();
        boolean status = eWalletService.transfer(id, to, amount);

        if (!status) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }

    // 充值
    public void credit(Long id, BigDecimal amount) {}

    // 支付
    public void debit(Long id, BigDecimal amount) {}

    public BigDecimal getBalance(Long id) {
        return null;
    }
}
