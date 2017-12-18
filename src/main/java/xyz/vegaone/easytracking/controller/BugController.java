package xyz.vegaone.easytracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.vegaone.easytracking.dto.Bug;
import xyz.vegaone.easytracking.service.BugService;

@Controller
@RequestMapping("/bug")
public class BugController {

    private final BugService bugService;

    @Autowired
    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Bug createBug(Bug bug) {

        return bugService.createBug(bug);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Bug getBug(@PathVariable("id") Long id) {

        return bugService.getBug(id);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Bug updateBug(Bug bug) {

        return bugService.updateBug(bug);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBug(Bug bug) {

        bugService.deleteBug(bug);
    }

}
