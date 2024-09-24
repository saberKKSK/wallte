package com.wkw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wkw.entity.BillEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BillMapper extends BaseMapper<BillEntity> {

    @Select("SELECT\n" +
            "  `rank`,\n" +
            "  SUM( price ) AS price,\n" +
            "  SUM( duration ) AS duration \n" +
            "FROM\n" +
            "  bills \n" +
            "GROUP BY\n" +
            "  `rank`;")
    List<BillEntity> selectList();

    @Insert("INSERT INTO bills (price, `rank`,duration) VALUES ( #{price}, #{rank},#{duration} )")
    int insertBills(BillEntity billEntity);


    @Select("SELECT\n" +
            "  `rank`,\n" +
            "  SUM( price ) AS price,\n" +
            "  SUM( duration ) AS duration \n" +
            "FROM\n" +
            "  bills \n" +
            "WHERE\n" +
            "  settled = 0 \n" +
            "GROUP BY\n" +
            "  `rank`;")
    List<BillEntity> selectIncome();
}
