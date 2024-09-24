package com.wkw.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data  // Lombok 自动生成 Getter/Setter、toString 等
@TableName("bills")  // MyBatis-Plus 映射数据库表名
public class BillEntity {

    @TableId  // 标注主键
    private Integer id;

    private Byte platform;

    private BigDecimal price;

    private Float duration;

    private String rank;

    private Boolean settled;

    private Timestamp createdAt;
}
