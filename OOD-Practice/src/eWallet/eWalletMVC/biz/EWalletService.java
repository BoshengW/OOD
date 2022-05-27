package eWallet.eWalletMVC.biz;

import eWallet.eWalletMVC.bo.PayBO;
import eWallet.eWalletMVC.entity.PayEntity;
import eWallet.eWalletMVC.repository.EWalletRepo;

import java.math.BigDecimal;

public class EWalletService {

    public boolean transfer(Long id, Long id2, BigDecimal amount) {
        EWalletRepo eWalletRepo = new EWalletRepo();
        PayEntity from = eWalletRepo.fetch(id);
        PayEntity to =  eWalletRepo.fetch(id2);

        // Convert to BO
        PayBO fromBO = convert(from);
        PayBO toBO = convert(to);

        // 使用 BigDecimal可以避免精度丢失 比float和double精确
        try {
            from.setAmount(BigDecimal.valueOf(from.getAmount()).subtract(amount).longValue());
            to.setAmount(BigDecimal.valueOf(to.getAmount()).add(amount).longValue());
            eWalletRepo.update(from);
            eWalletRepo.update(to);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public boolean credit(Long id, BigDecimal amount) {
        EWalletRepo eWalletRepo = new EWalletRepo();
        PayEntity from = eWalletRepo.fetch(id);

        // Convert to BO
        PayBO fromBO = convert(from);

        // 使用 BigDecimal可以避免精度丢失 比float和double精确
        try {
            from.setAmount(BigDecimal.valueOf(from.getAmount()).subtract(amount).longValue());
            eWalletRepo.update(from);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean debit(Long id, BigDecimal amount) { return false; }

    public BigDecimal getBalance(Long id) {
        return null;
    }

    PayBO convert(PayEntity input) {
        PayBO payBo = new PayBO();
        return payBo;
    }
}
