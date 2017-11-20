package com.zaakman.lib.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ZaakMan on 2017/7/27.
 */

@Entity
public class StorageBean {


    @Id(autoincrement = true)
    private Long id = null;
    /**
     * 跟服务器一致的字段
     */
    public String bztm;//包装条码,
    public String vbeln;//销售和分销凭证号,
    public String posnr; //销售和分销凭证的项目号,
    public String bjbz; //大部件标识

    /**
     * app需要的字段
     */
    public boolean isCheck = false; //是否扫描过了


    /**
     * 上传时的字段
     */

    public String zrkrq;//入库日期
    public String zrksj; //入库时间
    public String zrkczr; //入库操作人
    public String zpm;//立库盘码

    /**
     * 分类需求添加
     */
    public String flagCode; //分类码

    @Generated(hash = 1864775444)
    public StorageBean(Long id, String bztm, String vbeln, String posnr,
                       String bjbz, boolean isCheck, String zrkrq, String zrksj, String zrkczr,
                       String zpm, String flagCode) {
        this.id = id;
        this.bztm = bztm;
        this.vbeln = vbeln;
        this.posnr = posnr;
        this.bjbz = bjbz;
        this.isCheck = isCheck;
        this.zrkrq = zrkrq;
        this.zrksj = zrksj;
        this.zrkczr = zrkczr;
        this.zpm = zpm;
        this.flagCode = flagCode;
    }

    @Generated(hash = 806242961)
    public StorageBean() {
    }

    public Long getId() {
        return this.id;
    }

    public String getBztm() {
        return this.bztm;
    }

    public void setBztm(String bztm) {
        this.bztm = bztm;
    }

    public String getVbeln() {
        return this.vbeln;
    }

    public void setVbeln(String vbeln) {
        this.vbeln = vbeln;
    }

    public String getPosnr() {
        return this.posnr;
    }

    public void setPosnr(String posnr) {
        this.posnr = posnr;
    }

    public String getBjbz() {
        return this.bjbz;
    }

    public void setBjbz(String bjbz) {
        this.bjbz = bjbz;
    }

    public boolean getIsCheck() {
        return this.isCheck;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public String getZrkrq() {
        return this.zrkrq;
    }

    public void setZrkrq(String zrkrq) {
        this.zrkrq = zrkrq;
    }

    public String getZrksj() {
        return this.zrksj;
    }

    public void setZrksj(String zrksj) {
        this.zrksj = zrksj;
    }

    public String getZrkczr() {
        return this.zrkczr;
    }

    public void setZrkczr(String zrkczr) {
        this.zrkczr = zrkczr;
    }

    public String getZpm() {
        return this.zpm;
    }

    public void setZpm(String zpm) {
        this.zpm = zpm;
    }

    public String getFlagCode() {
        return this.flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
