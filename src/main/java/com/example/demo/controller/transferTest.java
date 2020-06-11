/*package com.example.demo.controller;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import com.example.demo.domain.ResResult;
import com.example.demo.exception.BizException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BankCardBalanceJpa;
import com.example.demo.dao.TransferJpa;

import static com.example.demo.exception.CommonException.BANLANCE_LESS;
import static com.example.demo.exception.CommonException.FILED_TRANSTER;


@RestController
@RequestMapping(value ="/getTransferAccount")
public class TransferController {
	@Autowired
	private TransferJpa transferJpa;
	@Autowired
	private  BankCardBalanceJpa bankCardBalanceJpa;
	@ResponseBody
	@GetMapping(value = "/transfer")
	public ResResult trade(@RequestParam("bankCard_number_from") String outer,
						   @RequestParam("bankCard_number_to") String inner,
						   @RequestParam("money") Double money) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		DataSource dataSource=null;
		try {

			Double balance=bankCardBalanceJpa.getBankCard_balancesByBankCard_id(outer);
			if(balance<money){
				throw new BizException(BANLANCE_LESS);
			}
			conn=dataSource.getConnection();
			conn.setAutoCommit(false);// 设置自动提交为false(不自动提交)
			stmt = conn.createStatement();
			//扣除outer账户
			transferJpa.out(outer, money);

			//模拟中途断电异常
			//System.out.println(1/0);

			//inner账户增加
			transferJpa.in(inner, money);
			conn.commit();// 提交事务
		}catch(Exception e){
			//conn.rollback();// 如果出异常，则回滚
			throw  new BizException(FILED_TRANSTER);

		} finally {
			//关闭资源
			if (null == stmt) {
			}else{
				stmt.close();
			}
			if (null == conn) {
			}else {
				conn.close();
			}
		}
		return ResResult.suc();

	}
}*/

package com.example.demo.controller;


import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import com.example.demo.dao.TransferJpa;
import com.example.demo.domain.ResResult;
import com.example.demo.exception.BizException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BankCardBalanceJpa;




@RestController
@RequestMapping(value ="getTransferAccount")
public class transferTest {

	@Autowired
	private TransferJpa inOutJpa;
	@Autowired//自动注入注解
	private  BankCardBalanceJpa bankCardBalanceJpa;
	@ResponseBody
	@GetMapping(value = "/transfer")
	/**
	 * @param outer 转账方账号
	 * @param inner  收款方账号
	 * @param money  转账金额
	 */
	public ResResult trade(@RequestParam("bankCard_number_from") String outer,
						   @RequestParam("bankCard_number_to") String inner,
						   @RequestParam("money") Double money) throws Exception{
//		Connection conn = null;
//		Statement stmt = null;
//	    DataSource dataSource=null;
		try {

			Double balance=bankCardBalanceJpa.getBankCard_balancesByBankCard_id(outer);
			if(balance<money){
				throw new BizException("20004","您的余额不足");
			}
//			conn=dataSource.getConnection();
//			conn.setAutoCommit(false);// 设置自动提交为false(不自动提交)
//			stmt = conn.createStatement();
			//扣除outer账户
			inOutJpa.out(outer, money);

			//模拟中途断电异常
			//System.out.println(1/0);

			//inner账户增加
			inOutJpa.in(inner, money);
			//conn.commit();// 提交事务
		}catch(Exception e){
			//conn.rollback();// 如果出异常，则回滚
			throw  new BizException("10004","转账失败");
		}
//		} finally {
//			//关闭资源
//			stmt.close();
//			conn.close();
//		}
		return ResResult.suc();

	}


}
