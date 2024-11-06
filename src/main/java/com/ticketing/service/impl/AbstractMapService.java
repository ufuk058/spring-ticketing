package com.ticketing.service.impl;

import com.ticketing.service.RoleService;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractMapService <T, ID>  {

    public Map<ID,T> map= new LinkedHashMap<>(); //This is our database


    T save (ID id, T object){
        return map.put(id,object);
    }

    T findById(ID id){

        return map.get(id);
    }

    List<T> findAll(){
        return new ArrayList<>(map.values());
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void update(ID id, T object){
        map.put(id,object);
    }


}
