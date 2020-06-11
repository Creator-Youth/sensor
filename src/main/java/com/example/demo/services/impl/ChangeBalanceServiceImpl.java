package com.example.demo.services.impl;

import com.example.demo.services.ChangeBalanceService;
import com.example.demo.dao.BankCardBalanceJpa;
import com.example.demo.dao.BankCardJpa;
import com.example.demo.exception.BizException;
import com.example.demo.po.BankCard;
import com.example.demo.po.BankCardBalance;
import com.example.demo.services.saveHistory.MoneyHistoryService;
import com.example.demo.utils.ObjectUtils;
import com.example.demo.vo.ChangeBalanceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 更改余额
 *
 * @author Liu YaXue
 * @since 1.0.0
 */
@Service
public class ChangeBalanceServiceImpl implements ChangeBalanceService {

  /**
   * 存款类型
   */
  private static final String TYPE_OF_DEPOSIT = "deposit";

  /**
   * 取款类型
   */
  private static final String TYPE_OF_WITHDRAW = "withdraw";

  /**
   * 加锁
   */
  private  Lock lock = new ReentrantLock();

  @Autowired
  private  BankCardBalanceJpa bankCardBalanceJpa;

  @Autowired
  private  BankCardJpa bankCardJpa;

  @Autowired
  private  MoneyHistoryService moneyHistoryService;


  /**
   * 存钱逻辑
   *
   * @param changeBalanceView {@link ChangeBalanceView} 实例
   * @return 卡里余额
   */
  @Override
  public Double depositMoney(ChangeBalanceView changeBalanceView) {
    return changeBalance(changeBalanceView, TYPE_OF_DEPOSIT);
  }

  /**
   * 取钱逻辑
   *
   * @param changeBalanceView {@link ChangeBalanceView} 实例
   * @return 卡里余额
   */
  @Override
  public Double withdrawMoney(ChangeBalanceView changeBalanceView) {
    return changeBalance(changeBalanceView, TYPE_OF_WITHDRAW);
  }

  /**
   * 改变余额
   *
   * @param changeBalanceView controller层传入的请求数据
   * @param type              定义存取钱类型
   * @return 卡内余额
   */
  private Double changeBalance(ChangeBalanceView changeBalanceView, String type) {

    ObjectUtils.requireNonEmpty(changeBalanceView.getBankcardId(), "银行卡号不能为空");
    //判断金额
    ObjectUtils.requireNonNull(changeBalanceView.getMoney(), "交易金额不能为空");

    if (changeBalanceView.getMoney() < 0.0) {
      throw new BizException("400", "交易金额不能小于0");
    }

    //尝试加锁
    lock.tryLock();

    //获取卡实例
    BankCard card = this.bankCardJpa.getBankCardByBankCardNumber(changeBalanceView.getBankcardId());

    if (Objects.isNull(card)) {
      throw new BizException("卡片不存在");
    }
    if (card.getCardFlag()) {
      throw new BizException("卡片已注销");
    }

    //校验密码
    if (!card.getBankCardPassword().equals(changeBalanceView.getBankCardPassword())) {
      //密码校验失败
      throw new BizException("500", "密码错误");
    }

    try {
      //获取余额实例
      BankCardBalance cardBalance = bankCardBalanceJpa.getBankCardByBankCard_id(changeBalanceView.getBankcardId());

      //获取卡里余额
      Double balance = cardBalance.getMoney();

      //改变的余额
      Double balanceChanged = null;
      if (TYPE_OF_DEPOSIT.equals(type)) {
        //存钱
        balanceChanged = balance + changeBalanceView.getMoney();
      }

      if (TYPE_OF_WITHDRAW.equals(type)) {
        //取钱
        if (balance < changeBalanceView.getMoney()) {
          throw new BizException("500", "余额不足");
        }
        balanceChanged = balance - changeBalanceView.getMoney();
      }

      cardBalance.setMoney(balanceChanged);

      //回写数据库
      this.bankCardBalanceJpa.saveAndFlush(cardBalance);
      this.insertMoneyHistory(changeBalanceView, type);
      return balanceChanged;
    } finally {
      lock.unlock();
    }
  }

  /**
   * 保存钱存取记录
   *
   * @param changeBalanceView controller层传入的请求数据
   * @param type              定义存取钱类型
   */
  private void insertMoneyHistory(ChangeBalanceView changeBalanceView, String type) {
    if (TYPE_OF_DEPOSIT.equals(type)) {
      //保存存钱记录
      this.moneyHistoryService
          .saveAddMoney(changeBalanceView.getMoney().toString(), changeBalanceView.getBankcardId());
    }

    if (TYPE_OF_WITHDRAW.equals(type)) {
      //保存取钱记录
      this.moneyHistoryService
          .saveDevMoney(changeBalanceView.getMoney().toString(), changeBalanceView.getBankcardId());
    }
  }

}
