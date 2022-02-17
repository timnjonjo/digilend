package com.timnjonjo.digilend.authprovider.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.timnjonjo.digilend.infra.Auditable;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Entity
@Builder
@ToString(exclude = {"permissions"})
@EqualsAndHashCode(callSuper = false)
@Table(uniqueConstraints = @UniqueConstraint(name = "UniqueRoleNameConstraint", columnNames = "name"))
@JsonIgnoreProperties(value = {"permissionsIds"}, allowGetters = true)
public class Role extends Auditable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column()
    private String name;
    @ManyToMany
    @JsonBackReference(value = "permissions")
    @JoinTable(joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    private Collection<Permission> permissions;
    public Role(String name) {
        this.name = name;
    }
    public Role(Long id){
        this.setId(id);
    }


    public Role(String name, Collection<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public Role(String name, Boolean active, Collection<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public Role() {
    }

}