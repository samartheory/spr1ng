package com.service;

import com.dao.daoC;
import com.pojo.pojoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class serviceC {
    @Autowired
    private daoC dao;
    public void add(pojoC p){
        normalize(p);
        dao.insert(p);
    }
    public void delete(int id){
        dao.delete(id);
    }
    public pojoC get(int id) throws ApiException {
        pojoC p = getCheck(id);
        return  p;
    }

    public List<pojoC> getAll(){
        return dao.selectAll();
    }
    public void update(int id,pojoC p) throws ApiException {
        normalize(p);
        getCheck(id);
        dao.update(id,p);
    }
    public pojoC getCheck(int id) throws ApiException {
        pojoC p = dao.select(id);
        if(p == null){
            throw new ApiException(id + "does not exist");
        }
        return p;
    }
    private static void normalize(pojoC p){
        p.setName(p.getName().toLowerCase().trim());
    }
}
