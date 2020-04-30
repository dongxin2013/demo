package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户临时表
 * </p>
 *
 * @author 董鑫
 * @since 2019-10-30
 */
@TableName("user_temp")
public class UserTemp extends Model<UserTemp> {

    private static final long serialVersionUID=1L;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    @TableId
    private String phone;

    /**
     * 是否为分管领导
     */
    private Boolean isLeader;

    /**
     * 是否为管理员
     */
    private Boolean isAdmin;

    /**
     * 是否为部门主管
     */
    @TableField("is_deptManager")
    private Boolean isDeptmanager;


    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getLeader() {
        return isLeader;
    }

    public void setLeader(Boolean isLeader) {
        this.isLeader = isLeader;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getDeptmanager() {
        return isDeptmanager;
    }

    public void setDeptmanager(Boolean isDeptmanager) {
        this.isDeptmanager = isDeptmanager;
    }

    @Override
    protected Serializable pkVal() {
        return this.phone;
    }

    @Override
    public String toString() {
        return "UserTemp{" +
        "unitName=" + unitName +
        ", username=" + username +
        ", nickname=" + nickname +
        ", phone=" + phone +
        ", isLeader=" + isLeader +
        ", isAdmin=" + isAdmin +
        ", isDeptmanager=" + isDeptmanager +
        "}";
    }
}
