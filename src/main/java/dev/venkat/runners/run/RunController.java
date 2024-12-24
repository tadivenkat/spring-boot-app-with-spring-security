package dev.venkat.runners.run;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/run")
public class RunController {

    private final RunService runService;

    public RunController(RunService runService) {
        this.runService = runService;
    }

    @GetMapping
    public ResponseEntity<List<Run>> findAll() {
        return ResponseEntity.ok(runService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Run> findById(Integer id) {
        return ResponseEntity.ok(runService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Run> create(@RequestBody Run run) {
        return ResponseEntity.ok(runService.create(run));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @RequestBody Run run) {
        return ResponseEntity.ok(runService.update(id, run));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Integer id) {
        runService.delete(id);
        return ResponseEntity.noContent().build();
    }
}