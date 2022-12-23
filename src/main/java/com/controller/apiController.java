package com.controller;
import java.util.ArrayList;
import java.util.List;
import com.pojo.pojoC;
import com.service.ApiException;
import com.service.serviceC;
import com.model.userData;
import com.model.userForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api
@RestController
public class apiController {
    @Autowired
    private serviceC service;
    @ApiOperation(value = "Adds an employee")
    @RequestMapping(path = "/api/employee", method = RequestMethod.POST)
    public void add(@RequestBody userForm form) {
        pojoC p = convert(form);
        service.add(p);
    }


    @ApiOperation(value = "Deletes and employee")
    @RequestMapping(path = "/api/employee/{id}", method = RequestMethod.DELETE)
    // /api/1
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @ApiOperation(value = "Gets an employee by ID")
    @RequestMapping(path = "/api/employee/{id}", method = RequestMethod.GET)
    public userData get(@PathVariable int id) throws ApiException {
        pojoC p = service.get(id);
        return convert(p);
    }

    @ApiOperation(value = "Gets list of all employees")
    @RequestMapping(path = "/api/employee", method = RequestMethod.GET)
    public List<userData> getAll() {
        List<pojoC> list = service.getAll();
        List<userData> list2 = new ArrayList<userData>();
        for (pojoC p : list) {
            list2.add(convert(p));
        }
        return list2;
    }

    @ApiOperation(value = "Updates an employee")
    @RequestMapping(path = "/api/employee/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id,@RequestBody userForm f) throws ApiException {
        pojoC p = convert(f);
        service.update(id, p);
    }


    private static userData convert(pojoC p) {
        userData d = new userData();
        d.setAge(p.getAge());
        d.setName(p.getName());
        d.setId(p.getId());
        return d;
    }

    private static pojoC convert(userForm f) {
        pojoC p = new pojoC();
        p.setAge(f.getAge());
        p.setName(f.getName());
        return p;
    }
}
