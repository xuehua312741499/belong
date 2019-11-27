/**
 * Copyright (C), 2019-9999, 喜梁门科技有限公司
 * FileName: AspectUtil
 * Author:   FengYu
 * Date:     2019/7/24 9:51
 * Description: 切面工具类
 * QQ:475788922
 */
package com.belong.common.redis.util;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;

public class AspectUtil {
    /**
     * 获取缓存的key
     * key 定义在注解上，支持SPEL表达式
     *
     * @param key 需要获取的key值
     * @return
     */
    public static String parseKey(String key, Method method, Object[] args) {
        // 获取被拦截方法参数名列表(使用Spring支持类库)
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paraNameArr = u.getParameterNames(method);
        // 使用SPEL进行key的解析
        ExpressionParser parser = new SpelExpressionParser();
        // SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        // 把方法参数放入SPEL上下文中
        for (int i = 0; i < paraNameArr.length; i++) {
            context.setVariable(paraNameArr[i], args[i]);
        }
        return parser.parseExpression(key).getValue(context, String.class);
    }
}
