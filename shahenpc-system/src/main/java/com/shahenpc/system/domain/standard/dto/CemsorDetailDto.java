package com.shahenpc.system.domain.standard.dto;

import com.shahenpc.system.domain.standard.StandardCensor;
import com.shahenpc.system.domain.standard.StandardCensorRecord;
import lombok.Data;

import java.util.List;

@Data
public class CemsorDetailDto extends StandardCensor {

    private List<RecordListDto> record;
}
