package com.pingr.Pings.core.Pings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pings")
public class PingController {

    private final PingService service;

    @Autowired
    public PingController(PingService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ping create(@RequestBody Ping ping) {
        return this.service.create(ping);
    }

    @PostMapping("/{id}/replies")
    @ResponseStatus(HttpStatus.CREATED)
    public Ping reply(@PathVariable("id") Long idPingReplied, @RequestBody Ping ping) {
        return this.service.reply(idPingReplied, ping);
    }

    @GetMapping("/{id}")
    public Ping findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
