package com.shahenpc.system.domain.represent.dto;

import com.shahenpc.system.domain.represent.RepresentActivity;
import com.shahenpc.system.domain.represent.RepresentActivityRecord;
import lombok.Data;

import java.util.List;

@Data
public class RepresentActivityAddDto extends RepresentActivity {

    private List<RepresentActivityRecord> record;
}
