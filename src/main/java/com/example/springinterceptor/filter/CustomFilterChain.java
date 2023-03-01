package com.example.springinterceptor.filter;


import java.util.ArrayList;
import java.util.List;

public class CustomFilterChain {

    private List<ICustomFilter> filters = new ArrayList<>();

    public void addFilter(ICustomFilter filter){
        filters.add(filter);
    }

    public void execute(String request){
        for (ICustomFilter filter : filters) {
            filter.execute(request);
        }
    }
}