package com.ford.wgibbin1.apiversionexample.controller;

import com.ford.wgibbin1.apiversionexample.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/example-controller")
public class ExampleController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @ApiVersion("1")
    public String helloWorldV1() {
        return "World version 1";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @ApiVersion("2")
    public String helloWorldV2() {
        return "World version 2";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String helloWorldVbase() {
        return "World unversioned";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @ApiVersion("2016-12-24")
    public String helloWorldVDate() {
        return "World version Date";
    }

}