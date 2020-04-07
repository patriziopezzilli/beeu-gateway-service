package com.beeu.gatewayservice.initializer;

import com.beeu.gatewayservice.constants.FamilyEnum;
import com.beeu.gatewayservice.constants.PlanEnum;
import com.beeu.gatewayservice.database.entity.FamilyEntity;
import com.beeu.gatewayservice.database.entity.PlanEntity;
import com.beeu.gatewayservice.database.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlanInitializer {

    @Autowired
    private PlanRepository planRepository;

    @PostConstruct
    private void init() {

        /**
         * Check if exists my plan
         */
        for (PlanEnum value : PlanEnum.values()) {

            /**
             * Check if exits
             */
            if (!planRepository.existsByCode(value.getCode())) {

                /**
                 * Init families
                 */
                List<FamilyEntity> families = new ArrayList<>();
                for (FamilyEnum family : value.getFamilies()) {
                    families.add(new FamilyEntity(
                            family.getCode(),
                            family.getName(),
                            family.getDescription()
                    ));
                }

                /**
                 * Create plan
                 */
                PlanEntity plan = new PlanEntity(
                        value.getName(),
                        value.getName(),
                        value.getCode(),
                        families
                );

                /**
                 * Persist
                 */
                planRepository.save(plan);
            }
        }

    }
}
