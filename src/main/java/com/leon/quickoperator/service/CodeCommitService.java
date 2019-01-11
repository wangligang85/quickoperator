package com.leon.quickoperator.service;

import com.leon.quick.tables.pojos.CodeCommit;

import java.util.List;

/**
 * @author wangligang85@163.com on 2019-01-11 16:00
 */
public interface CodeCommitService {

    List<CodeCommit> list(String username, Integer page, Integer pageSize);
}
