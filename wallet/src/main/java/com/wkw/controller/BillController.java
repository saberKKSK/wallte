package com.wkw.controller;


import com.wkw.dto.BillDTO;
import com.wkw.dto.IncomeDTO;
import com.wkw.service.BillService;
import com.wkw.vo.BillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    // 查询所有账单
    @GetMapping("/getAllBills")
    public List<BillDTO> getAllBills() {
        return billService.selectAll();
    }

    // 添加账单
    @PostMapping("/addBills")
    public Boolean addBills(@RequestBody BillVO billVO) {
        return billService.addBills(billVO);
    }

    // 查询未结款账单
    @GetMapping("/getOutstanding")
    public IncomeDTO getOutstanding() {
        return billService.getBills();
    }
}
