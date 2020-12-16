package com.aricsun.boot.launch.utils;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 作用就是讲dozer的对象转换能力提升到集合中，
 * @author AricSun
 * @date 2020.12.16 22:14
 */
public class DozerUtils {

    static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass){
        List destinationList = Lists.newArrayList();
        for (Iterator i$ = sourceList.iterator(); i$.hasNext();){
            Object sourceObject = i$.next();
            Object destinationObject = mapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}
