package com.shahenpc.system.domain.standard.dto;

import com.shahenpc.system.domain.standard.StandardCensorRecord;
import lombok.Data;

@Data
public class RecordListDto extends StandardCensorRecord {
    private String receiveName;
}
