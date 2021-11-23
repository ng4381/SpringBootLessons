package com.example.demo.repository;

import com.example.demo.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    @Query(value = "select * from organization", nativeQuery = true)
    public List<Organization> getOrganizations();

    @Query(value = "select * from organization where name=:n", nativeQuery = true)
    public List<Organization> getOrganizationsByName(@Param("n") String name);

    @Query(value = "select o from Organization o where name=:n and id=:id")
    public List<Organization> getOrganizationsHQL(@Param("n") String name, @Param("id") int id);
}
