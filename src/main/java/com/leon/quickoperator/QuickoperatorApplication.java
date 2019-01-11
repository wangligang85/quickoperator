package com.leon.quickoperator;

import com.alibaba.fastjson.JSON;
import com.leon.quick.tables.pojos.CodeCommit;
import com.leon.quickoperator.service.CodeCommitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
public class QuickoperatorApplication {

	private static final Logger logger = LoggerFactory.getLogger(QuickoperatorApplication.class);
	@Resource(name = "codeCommitService")
	private CodeCommitService codeCommitService;
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(QuickoperatorApplication.class, args);
		QuickoperatorApplication bean = applicationContext.getBean(QuickoperatorApplication.class);
		bean.list();
	}



	private void list(){
		logger.info("===============begin query =================");
		List<CodeCommit> result = codeCommitService.list("wangligang9", 1, 10);
		logger.info(JSON.toJSONString(result));
		logger.info("===============end query =================");
	}

}

