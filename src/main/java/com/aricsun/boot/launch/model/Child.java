package com.aricsun.boot.launch.model;

import lombok.Data;

/**
 * @author AricSun
 * @date 2020.12.12 17:49
 */
@Data
public class Child {
    private String name;
    private Integer age;
    private Friend[] friends;
}
