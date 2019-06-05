package com.why.web.whyChat.push;

import com.why.web.whyChat.push.service.AccountService;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Logger;

/**
 * @author why
 */

public class Application extends ResourceConfig{
    public Application(){
        // 注册逻辑处理的包名
        packages(AccountService.class.getPackage().getName());

        // 注册 Json 解析器
        register(JacksonJaxbJsonProvider.class);

        // 注册日志打印输出
        register(Logger.class);
    }
}
