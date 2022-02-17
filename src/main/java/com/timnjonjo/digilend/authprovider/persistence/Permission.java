package com.timnjonjo.digilend.authprovider.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.timnjonjo.digilend.infra.Auditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "tbl_permissions", uniqueConstraints = @UniqueConstraint(name = "UniquePermissionName", columnNames = "name"))
public class Permission extends Auditable implements Serializable {

    private static final long serialVersionUID = -5432523136901198391L;

    @Column(unique = true)
    private String name;
    @JsonBackReference
    @ManyToMany(mappedBy = "permissions")
    private Collection<Role> roles;

    public Permission() {
    }

    public Permission(String name) {
        this.name= name;
    }

    public Permission(String name, Collection<Role> roles) {
        this.name = name;
        this.roles = roles;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}