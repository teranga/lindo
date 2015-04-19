package com.jalarbee.lindo.service.procure;

import com.jalarbee.lindo.domain.procure.Procurement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author Abdoulaye Diallo
 */

public interface ProcurementService {

    Procurement create(Procurement procurement); //TODO implement

    Stream<Procurement> findProcurements(UUID organizationId);

    Procurement findProcurement(UUID organizationId, UUID id);
}
