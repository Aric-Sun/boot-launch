package com.aricsun.boot.launch.model;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author AricSun
 * @date 2020.12.12 17:48
 */
@Data
public class Father {
    private String name;

    @Min(21)
    private Integer age;
}
