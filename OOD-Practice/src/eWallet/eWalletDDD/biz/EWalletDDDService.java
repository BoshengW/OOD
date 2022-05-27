package eWallet.eWalletDDD.biz;

import eWallet.eWalletDDD.domain.EWallet;
import eWallet.eWalletMVC.bo.PayBO;
import eWallet.eWalletMVC.entity.PayEntity;
import eWallet.eWalletMVC.repository.EWalletRepo;

import java.math.BigDecimal;

public class EWalletDDDService {

    public boolean transfer(Long id, Long id2, BigDecimal amount) {
        EWalletRepo eWalletRepo = new EWalletRepo();
        PayEntity from = eWalletRepo.fetch(id);
        PayEntity to =  eWalletRepo.fetch(id2);

        // Convert to BO - 贫血模型
        //PayBO fromBO = convert(from);
        //PayBO toBO = convert(to);

        EWallet fromBO = convertDDD(from);
        EWallet toBO = convertDDD(to);

        // 使用 BigDecimal可以避免精度丢失 比float和double精确
        try {
            // 数据层更新
            from.setAmount(BigDecimal.valueOf(from.getAmount()).subtract(amount).longValue());
            to.setAmount(BigDecimal.valueOf(to.getAmount()).add(amount).longValue());
            eWalletRepo.update(from);
            eWalletRepo.update(to);

            // 贫血模型
            //fromBO.setBalance(BigDecimal.valueOf(from.getAmount()).subtract(amount).longValue());
            //toBO.setBalance(BigDecimal.valueOf(to.getAmount()).add(amount).longValue());

            // 充血模型 - 将业务逻辑封装进去而不是只有getter - setter
            fromBO.debit(id, amount.longValue());
            toBO.credit(id, amount.longValue());

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

    EWallet convertDDD(PayEntity input) {
        EWallet eWallet = new EWallet();
        return eWallet;
    }
}
