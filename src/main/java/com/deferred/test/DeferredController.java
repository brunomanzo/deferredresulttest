package com.deferred.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class DeferredController {
    @Autowired
    private DeferredDAO deferredDAO;

    @RequestMapping(value = { "/deferred" }, method = RequestMethod.GET)
    public @ResponseBody DeferredResult<String> testDeferred() {
        System.out.println("request!");
        deferredDAO.get("bar");
        System.out.println("post-query");
        DeferredResult<String> result = new DeferredResult<>(10l, "blaa");
        result.onCompletion(() -> {
            System.out.println("on timeout");
        });
        System.out.println("returned");
        return result;
    }
}
