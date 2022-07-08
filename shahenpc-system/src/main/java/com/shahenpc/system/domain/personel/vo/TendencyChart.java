package com.shahenpc.system.domain.personel.vo;

import lombok.Data;

import java.util.List;

@Data
public class TendencyChart {
    public List<String> tendencyX;
    public List<Integer> tendencyY;
}
