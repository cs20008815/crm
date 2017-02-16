package org.clj.crmproj.entity;

import java.util.UUID;

public class Guest4 {
    private String sid;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

    private String attr6;

    private String attr7;

    private String attr8;

    private String attr9;

    private String attr10;

    private String attr11;

    public Guest4(){
        this.setSid(UUID.randomUUID().toString());
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1 == null ? null : attr1.trim();
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2 == null ? null : attr2.trim();
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3 == null ? null : attr3.trim();
    }

    public String getAttr4() {
        return attr4;
    }

    public void setAttr4(String attr4) {
        this.attr4 = attr4 == null ? null : attr4.trim();
    }

    public String getAttr5() {
        return attr5;
    }

    public void setAttr5(String attr5) {
        this.attr5 = attr5 == null ? null : attr5.trim();
    }

    public String getAttr6() {
        return attr6;
    }

    public void setAttr6(String attr6) {
        this.attr6 = attr6 == null ? null : attr6.trim();
    }

    public String getAttr7() {
        return attr7;
    }

    public void setAttr7(String attr7) {
        this.attr7 = attr7 == null ? null : attr7.trim();
    }

    public String getAttr8() {
        return attr8;
    }

    public void setAttr8(String attr8) {
        this.attr8 = attr8 == null ? null : attr8.trim();
    }

    public String getAttr9() {
        return attr9;
    }

    public void setAttr9(String attr9) {
        this.attr9 = attr9 == null ? null : attr9.trim();
    }

    public String getAttr10() {
        return attr10;
    }

    public void setAttr10(String attr10) {
        this.attr10 = attr10 == null ? null : attr10.trim();
    }

    public String getAttr11() {
        return attr11;
    }

    public void setAttr11(String attr11) {
        this.attr11 = attr11 == null ? null : attr11.trim();
    }
}