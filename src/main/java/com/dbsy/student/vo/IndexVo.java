package com.dbsy.student.vo;

import java.util.List;
import java.util.Map;

public class IndexVo {
    // 学校人数
    private Integer peopleNumber;

    private List<Map> cet4;

    private List<Map> cet6;

    private List<Map> nation;

    public List<Map> getEmploy() {
        return employ;
    }

    public void setEmploy(List<Map> employ) {
        this.employ = employ;
    }

    private List<Map> employ;

    public List<Map> getNation() {
        return nation;
    }

    public void setNation(List<Map> nation) {
        this.nation = nation;
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public List<Map> getCet4() {
        return cet4;
    }

    public void setCet4(List<Map> cet4) {
        this.cet4 = cet4;
    }

    public List<Map> getCet6() {
        return cet6;
    }

    public void setCet6(List<Map> cet6) {
        this.cet6 = cet6;
    }
}
