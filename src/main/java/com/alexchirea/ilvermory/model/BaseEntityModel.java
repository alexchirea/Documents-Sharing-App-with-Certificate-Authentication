package com.alexchirea.ilvermory.model;

import com.alexchirea.ilvermory.config.UUIDGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntityModel implements Serializable {

    @Id
    @GeneratedValue(generator = UUIDGenerator.generatorName)
    @GenericGenerator(name = UUIDGenerator.generatorName, strategy = "com.alexchirea.ilvermory.config.UUIDGenerator")
    private String id;

    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "last_modified_on")
    private Date lastModifiedOn;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    private void audit(String operation) {
        if (operation.compareTo("INSERT") == 0) {
            createdBy = "SYSTEM";
            createdOn = new Date();
        }
        if (operation.compareTo("UPDATE") == 0) {
            lastModifiedBy = "SYSTEM";
            lastModifiedOn = new Date();
        }
    }

    @PrePersist
    public void onPrePersist() {
        audit("INSERT");
    }

    @PreUpdate
    public void onPreUpdate() {
        audit("UPDATE");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
