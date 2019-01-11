package com.leon.quickoperator.service.impl;

import com.leon.quick.tables.pojos.CodeCommit;
import com.leon.quickoperator.service.CodeCommitService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.leon.quick.Tables.CODE_COMMIT;

/**
 * @author wangligang85@163.com on 2019-01-11 16:02
 */
@Service("codeCommitService")
public class CodeCommitServiceImpl implements CodeCommitService {

    @Autowired
    private DSLContext context;

    @Override
    public List<CodeCommit> list(String username, Integer page, Integer pageSize) {
        int size = pageSize == 0 ? 10 : pageSize;
        int startIndex = (page -1 < 0 ? 0 : page -1) * pageSize;
        return context.select()
                .from(CODE_COMMIT)
                .where(CODE_COMMIT.USERNAME.eq(username))
                .limit(startIndex, size)
                .fetchInto(CodeCommit.class);
    }
}
