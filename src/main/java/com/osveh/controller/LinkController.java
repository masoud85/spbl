package com.osveh.controller;

import com.osveh.domain.Link;
import com.osveh.repository.LinkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/links")
public class LinkController {

    private LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public List<Link> links() {
        return linkRepository.findAll();
    }

    @PostMapping("/create")
    public Link create(@ModelAttribute Link link) {
        return linkRepository.save(link);
    }

    @GetMapping("/{linkId}")
    public Optional<Link> read(@PathVariable Long linkId) {
        return linkRepository.findById(linkId);
    }

    @PutMapping("/{linkId}}")
    public Link update(@PathVariable Long linkId, @ModelAttribute Link link) {
        return linkRepository.save(link);
    }

    @DeleteMapping("/{linkId}}")
    public void delete(@PathVariable Long linkId) {
        linkRepository.deleteById(linkId);
    }


}
