package com.belong.common.core.base;


import com.belong.common.util.date.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**

* @Description:    web层通用数据处理
* @Author:         fengyu
* @CreateDate:     2019/11/27 16:17
* @UpdateUser:     fengyu
* @UpdateDate:     2019/11/27 16:17
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }
}
