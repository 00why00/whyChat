package com.why.web.whyChat.push.service;


import com.why.web.whyChat.push.bean.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author why
 */
// 127.0.0.1/api/account/...
@Path("/account")
public class AccountService {

    // 127.0.0.1/api/account/login
    @GET
    @Path("/login")
    public String get(){
        return "You get the login";
    }

    @POST
    @Path("/login")
    // 指定请求与返回响应体为 JSON
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User post() {
        User user = new User();
        user.setName("why");
        user.setSex(2);
        return user;
    }

}
