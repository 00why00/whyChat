package com.why.web.whyChat.push.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author why
 */
// 127.0.0.1/api/account/...
@Path("/account")
public class AccountService {
    @GET
    @Path("/login")
    public String get(){
        return "You get the login";
    }
}
