package com.example.springinterceptor.filter;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class FilterManager {

    CustomFilterChain filterChain;

    public FilterManager() throws InstantiationException, IllegalAccessException {
        filterChain = new CustomFilterChain();

        Reflections reflections = new Reflections("com.example");

        /**
         * Get all class by annotation & then sort by order property
         */
        Set<Class<?>> customFilters = reflections.getTypesAnnotatedWith(CustomFilter.class);
        customFilters.forEach(cf -> log.info("Before sorting: {}", cf.getName()));

        List cfList = customFilters.stream()
                .sorted(Comparator.comparing(aClass -> aClass.getAnnotation(CustomFilter.class).order()))
                .collect(Collectors.toList());
        cfList.forEach(cf -> log.info("After sorting: {}", ((Class) cf).getName()));

        for (Object filter : cfList) {
            setFilter((ICustomFilter) ((Class) filter).newInstance());
        }

        /**
         * Get all class by subtype
         */
//        Set<Class<? extends ICustomFilter>> icustomFilters = reflections.getSubTypesOf(ICustomFilter.class);
//        for (Class<? extends ICustomFilter> filter : icustomFilters) {
//            setFilter(filter.newInstance());
//        }
    }

    public void setFilter(ICustomFilter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }
}
