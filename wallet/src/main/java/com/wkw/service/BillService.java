package com.wkw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wkw.dto.BillDTO;
import com.wkw.dto.IncomeDTO;
import com.wkw.entity.BillEntity;
import com.wkw.vo.BillVO;

import java.util.List;


public interface BillService extends IService<BillEntity> {
    // 你可以添加额外的业务逻辑方法

    List<BillDTO> selectAll();

    boolean addBills(BillVO billVO);

    IncomeDTO getBills();
}
