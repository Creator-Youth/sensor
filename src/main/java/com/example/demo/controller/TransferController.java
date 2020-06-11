package com.example.demo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.example.demo.domain.ResResult;
import com.example.demo.exception.BizException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.InOutJpa;
import com.example.demo.dao.TransferJpa;




@RestController
@RequestMapping("/mp2")
public class TransferController {
	//@Autowired
	TransferJpa transferJpa;
	InOutJpa inOutJpa;
	@ResponseBody
    @GetMapping(value = "/transfer")
	public ResResult trade(@RequestParam("bankCard_number_from") String outer,
						   @RequestParam("bankCard_number_to") String inner,
						   @RequestParam("money") Double money) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	    DataSource dataSource=null;
		try {
			conn=dataSource.getConnection();
			conn.setAutoCommit(false);// 设置自动提交为false(不自动提交)
			stmt = conn.createStatement();
			//扣除outer账户
			inOutJpa.out(outer, money);
					
			//模拟中途断电异常
			//System.out.println(1/0);
			
			//inner账户增加
			inOutJpa.in(inner, money);
			conn.commit();// 提交事务
		}catch(Exception e){
			conn.rollback();// 如果出异常，则回滚
			throw  new BizException("10004","转账失败");

		} finally {
			//关闭资源
			rs.close();
			stmt.close();
			conn.close();
		}
		return ResResult.suc();
		
	}
}


