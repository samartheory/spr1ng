package com.controller;

import com.model.userData;
import com.model.userForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Api
@RestController
public class apiController {
    @ApiOperation(value = "sayhello")
    @RequestMapping(path = "/api/say-hello",method = RequestMethod.POST)
    public userData sayHello(@RequestBody userForm userform){
        userData data = new userData();
        data.setName(userform.getName());
        data.setMessage("ajaja");
        return data;
    }
    @ApiOperation(value = "saybye")
    @RequestMapping(path = "/api/say-bye",method = RequestMethod.GET)
    public userData sayBye(){
        userData data = new userData();
        data.setName("def_user");
        data.setMessage("2nd_api");
        return data;
    }
}
