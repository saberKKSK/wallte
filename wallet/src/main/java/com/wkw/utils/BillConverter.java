package com.wkw.utils;

import cn.hutool.core.bean.BeanUtil;
import com.wkw.dto.BillDTO;
import com.wkw.entity.BillEntity;
import com.wkw.vo.BillVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class BillConverter {

    // 将 BillVo 转换为 BillEntity
    public static BillEntity convertToEntity(BillVO billVo) {
        if (billVo == null) {
            return null;
        }
        BillEntity billEntity = new BillEntity();
        BeanUtil.copyProperties(billVo, billEntity);
        return billEntity;
    }

    public static List<BillDTO> convertToDTO(List<BillEntity> billEntityList) {
        return billEntityList.stream()
                .map(billEntity -> {
                    BillDTO dto = new BillDTO();
                    dto.setDuration(billEntity.getDuration());
                    dto.setRank(billEntity.getRank());
                    dto.setPrice(billEntity.getPrice());
                    // 使用 Hutool 的 BeanUtil 进行属性拷贝
                    BeanUtil.copyProperties(billEntity, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public static BigDecimal calculateTotalPrice(List<BillEntity> billEntities) {
        return billEntities.stream()
                .map(BillEntity::getPrice) // 获取 price 字段
                .reduce(BigDecimal.ZERO, BigDecimal::add); // 将所有 price 相加
    }
}