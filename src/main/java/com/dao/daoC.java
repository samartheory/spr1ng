package com.dao;

import com.pojo.pojoC;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class daoC {
    private HashMap<Integer, pojoC>rows;
    private int lastId;
    @PostConstruct
    public void init(){
        rows = new HashMap<Integer,pojoC>();
    }
    public void insert(pojoC p) {
        lastId++;
        p.setId(lastId);
        rows.put(lastId,p);
    }

    public void delete(int id) {
        rows.remove(id);
    }

    public pojoC select(int id) {
        return rows.get(id);
    }

    public List<pojoC> selectAll() {
        ArrayList<pojoC>list=new ArrayList<pojoC>();
        list.addAll(rows.values());
        return list;
    }

    public void update(int id,pojoC p) {
        rows.put(id,p);
    }

}
