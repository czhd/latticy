package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName("banner")
public class BannerDO {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String img;

    private String name;

    private String title;

    private String description;

    @JsonIgnore
    @TableLogic
    private Date deleteTime;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;
}
