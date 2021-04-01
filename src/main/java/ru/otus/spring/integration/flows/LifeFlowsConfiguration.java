package ru.otus.spring.integration.flows;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import ru.otus.spring.integration.life.filters.CompanyFilter;
import ru.otus.spring.integration.life.filters.UniversityFilter;

@Configuration
public class LifeFlowsConfiguration {

    @Bean
    public CompanyFilter companyFilter() {
        return new CompanyFilter();
    }

    @Bean
    public UniversityFilter universityFilter() {
        return new UniversityFilter();
    }

    @Bean
    public IntegrationFlow lifeFlow(UniversityFilter universityFilter, CompanyFilter companyFilter) {
        return IntegrationFlows.from("personChannel")
                .split()
                .handle("schoolService", "process")
                .channel("schoolEndChanel")
                .filter(universityFilter::filterSchoolboys,
                        notUniversity -> notUniversity
                                .discardFlow(df -> df
                                        .channel("socialChanel")
                                        .handle("socialService", "process")
                                        .channel("activeLifeEndChannel"))

                )
                .handle("universityService", "process")
                .channel("universityEndChanel")
                .filter(companyFilter::filterUniversityBoys,
                        notCompany -> notCompany
                                .discardFlow(df -> df
                                        .channel("socialChanel")
                                        .handle("socialService", "process")
                                        .channel("activeLifeEndChannel"))

                )
                .handle("companyService", "process")
                .channel("activeLifeEndChannel")
                .handle("pensionFundService", "process")
                .aggregate()
                .channel("pensionerChannel")
                .get();
    }

}
