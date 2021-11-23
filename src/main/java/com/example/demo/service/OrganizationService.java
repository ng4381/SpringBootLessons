package com.example.demo.service;

import com.example.demo.model.Organization;
import com.example.demo.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    public Page<Organization> getOrganizations(String field, int page) {
        return organizationRepository.findAll(PageRequest.of(page, 1).withSort(Sort.by(Sort.Direction.DESC, field)));
    }

    public List<Organization> getOrganizationsSQL(){
        return organizationRepository.getOrganizations();
    }

    public List<Organization> getOrganizationsByNameSQL(String name){
        return organizationRepository.getOrganizationsByName(name);
    }

    public void createOrganization(Organization organization) throws Exception {
        organizationRepository.save(organization);
    }

    public List<Organization> getOrganizationsHQL(String name, int id) {
        return organizationRepository.getOrganizationsHQL(name, id);
    }
}
