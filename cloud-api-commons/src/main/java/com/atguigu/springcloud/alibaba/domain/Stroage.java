package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stroage {

    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
