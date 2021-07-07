package com.salesmanager.core.model.user;

import com.salesmanager.core.model.common.audit.AuditListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@EntityListeners(value = {AuditListener.class})
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"MERCHANT_ID"})
})
public class User {

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private Long id;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
