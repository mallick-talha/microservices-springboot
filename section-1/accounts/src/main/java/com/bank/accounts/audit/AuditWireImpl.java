package com.bank.accounts.audit;

import org.hibernate.audit.spi.AuditWorkQueue;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component("auditWireImpl")
public class AuditWireImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Account_MS");
    }
}
