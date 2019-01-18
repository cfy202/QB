/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.chinatour.template.directive;

import com.chinatour.Message;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * 模板指令 - 瞬时消息
 *
 * @author SHOP++ Team
 * @version 3.0
 */
@Component("flashMessageDirective")
public class FlashMessageDirective extends BaseDirective {

    /**
     * "瞬时消息"属性名称
     */
    public static final String FLASH_MESSAGE_ATTRIBUTE_NAME = FlashMessageDirective.class.getName() + ".FLASH_MESSAGE";

    /**
     * 变量名称
     */
    private static final String VARIABLE_NAME = "flashMessage";

    @SuppressWarnings("rawtypes")
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
            Message message = (Message) requestAttributes.getAttribute(FLASH_MESSAGE_ATTRIBUTE_NAME, RequestAttributes.SCOPE_REQUEST);
            if (body != null) {
                setLocalVariable(VARIABLE_NAME, message, env, body);
            } else {
                if (message != null) {
                    Writer out = env.getOut();
                    out.write("$.gritter.add({title: '" + message.getTitle() + "',text: '" + message.getContent() + "',class_name: '" + message.getType() + "'});");
                }
            }
        }
    }

}