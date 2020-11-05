package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("banner_item")
public class BannerItemDO {

    private String name;

    private String img;

    private String keyword;

    private Integer type;

    private Integer bannerId;
}
