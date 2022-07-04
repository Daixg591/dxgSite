package com.shahenpc.system.domain.BackVo;

import com.shahenpc.common.core.domain.entity.SysUser;
import com.shahenpc.system.domain.personel.PersonnelAppointEduLog;
import com.shahenpc.system.domain.personel.PersonnelAppointRegister;

import java.util.List;

public class PersonalInfo {
    /**
     * 任免记录详情
     */
    private PersonnelAppointRegister regEntity;

    /**
     * 教育记录
     */
    private List<PersonnelAppointEduLog> eduLogList;

    public PersonnelAppointRegister getRegEntity() {
        return regEntity;
    }

    public void setRegEntity(PersonnelAppointRegister regEntity) {
        this.regEntity = regEntity;
    }


    public List<PersonnelAppointEduLog> getEduLogList() {
        return eduLogList;
    }

    public void setEduLogList(List<PersonnelAppointEduLog> eduLogList) {
        this.eduLogList = eduLogList;
    }
}
