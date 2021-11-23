package com.example.demo.controller;

import com.example.demo.model.Organization;
import com.example.demo.service.OrganizationService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @GetMapping("/{field}/{page}")
    public ResponseEntity<List<Organization>> getOrganizations(@PathVariable String field, @PathVariable int page){
        return new ResponseEntity(organizationService.getOrganizations(field, page), HttpStatus.OK);
    }

    @GetMapping("/fromsql")
    public List<Organization> getOrganizationsFromSQL(){
        return organizationService.getOrganizationsSQL();
    }

    @GetMapping("/fromhql")
    public List<Organization> getOrganizationsFromHQL(@RequestParam String name, @RequestParam int id){
        return organizationService.getOrganizationsHQL(name, id);
    }

    @GetMapping("/fromsql/{name}")
    public List<Organization> getOrganizationsFromSQL(@PathVariable String name){
        return organizationService.getOrganizationsByNameSQL(name);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createOrganization(@RequestBody Organization organization){
        try {
            organizationService.createOrganization(organization);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
