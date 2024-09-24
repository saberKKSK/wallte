package com.wkw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wkw.dto.BillDTO;
import com.wkw.dto.IncomeDTO;
import com.wkw.entity.BillEntity;
import com.wkw.mapper.BillMapper;
import com.wkw.service.BillService;
import com.wkw.vo.BillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.wkw.utils.BillConverter.*;

@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, BillEntity> implements BillService {
    @Autowired
    BillMapper billMapper;


    @Override
    public List<BillDTO> selectAll() {
        List<BillEntity> billEntities = billMapper.selectList();
        return convertToDTO(billEntities);
    }

    public boolean addBills(BillVO billVO) {

        int insert = billMapper.insertBills(convertToEntity(billVO));
        return insert == 1;
    }

    public IncomeDTO getBills() {
        List<BillEntity> billEntities = billMapper.selectIncome();
        IncomeDTO incomeDTO  = new IncomeDTO();
        incomeDTO.setBillDTOS(convertToDTO(billEntities));
        incomeDTO.setIncome(calculateTotalPrice(billEntities));
        return incomeDTO;
    }
}
