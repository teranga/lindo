package com.jalarbee.lindo.web.controler;

import com.jalarbee.lindo.dto.Procurement;
import com.jalarbee.lindo.service.procure.ProcurementService;
import com.jalarbee.lindo.web.converter.ToDtoConverters;
import com.jalarbee.lindo.web.converter.ToEntityConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Abdoulaye Diallo
 */

@RestController
@RequestMapping("/api/procurements")
public class ProcurementController {

    private final ProcurementService procurementService;

    public @Autowired ProcurementController(final ProcurementService procurementService) {
        this.procurementService = procurementService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Procurement create(Procurement dto) {
        return ToDtoConverters.PROCUREMENT.convert(procurementService.create(ToEntityConverters.PROCUREMENT.convert(dto)));
    }
}
