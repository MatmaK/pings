package com.pingr.Pings.core.Pings;

import com.pingr.Pings.application.ProducerService;
import com.pingr.Pings.core.AccountRepository;
import com.pingr.Pings.core.exceptions.AccountNotFoundException;
import com.pingr.Pings.core.exceptions.PingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PingService {
    private final PingRepository pingRepo;
    private final AccountRepository accountRepo;
    private final ProducerService service;

    @Autowired
    public PingService(PingRepository pingRepo, AccountRepository accountRepo, ProducerService service) {
        this.pingRepo = pingRepo;
        this.accountRepo = accountRepo;
        this.service = service;
    }

    public Ping create (Ping ping) {
        if(!accountExists(ping.getIdAccount()))
            throw new AccountNotFoundException(ping.getIdAccount());

        try {
            Ping savedPing = pingRepo.save(ping);
            service.emitPingCreatedEvent(ping);

            return savedPing;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Please, verify the request body and try again");
        }
    }

    public Ping reply (Long idPingReplied, Ping ping) {
        if (!pingExists(idPingReplied))
            throw new PingNotFoundException(idPingReplied);

        if(!accountExists(ping.getIdAccount()))
            throw new AccountNotFoundException(ping.getIdAccount());

        try {
            ping.setIdPingReplied(idPingReplied);
            Ping savedPing = pingRepo.save(ping);
            service.emitPingCreatedEvent(ping);

            return savedPing;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Please, verify the request body and try again");
        }
    }

    public Ping findOne(Long id) {
        Optional<Ping> optPing = pingRepo.findById(id);
        if (optPing.isEmpty())
            throw new PingNotFoundException(id);

        return optPing.get();
    }

    public void delete (Long idPing) {
        Optional<Ping> optPing = pingRepo.findById(idPing);
        if (optPing.isEmpty())
            throw new PingNotFoundException(idPing);

        pingRepo.deleteById(idPing);
        service.emitPingDeletedEvent(optPing.get());
    }

    private boolean accountExists(Long id) {
        return accountRepo.existsById(id);
    }

    private boolean pingExists(Long id) {
        return pingRepo.existsById(id);
    }
}
