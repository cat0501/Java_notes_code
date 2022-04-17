package com.zjl.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author cat
 * @description
 * @date 2022/4/17 下午12:59
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        // 优化：避免自动填充时开销过大，填充前先判断当前对象中是否有相关属性
        // 判断是否具备author属性
        boolean hasAuthor = metaObject.hasSetter("author");
        if(hasAuthor){
            log.info("start insert fill author....");
            this.strictInsertFill(metaObject, "author", String.class, "Helen");
        }

        //判断age是否赋值
        Object age = this.getFieldValByName("age", metaObject);
        if(age == null){
            log.info("start insert fill age....");
            this.strictInsertFill(metaObject, "age", Integer.class, 18);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
