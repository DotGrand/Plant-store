package org.project.plantstore.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "`description`")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Please provide a valid family")
    @Size(min = 2, max = 60, message = "Must not be shorter than 2 and longer than 60 characters")
    @Column(name = "`family`")
    private String family;

    @NotNull(message = "Please provide a valid hardiness")
    @Size(min = 2, max = 600, message = "Must not be shorter than 2 and longer than 600 characters")
    @Column(name = "`hardiness`")
    private String hardiness;

    @NotNull(message = "Please provide a valid use")
    @Size(min = 2, max = 600, message = "Must not be shorter than 2 and longer than 600 characters")
    @Column(name = "`use`")
    private String use;

    @NotNull(message = "Please provide a valid cautions")
    @Size(min = 2, max = 600, message = "Must not be shorter than 2 and longer than 600 characters")
    @Column(name = "`cautions`")
    private String cautions;

    public Description() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getHardiness() {
        return hardiness;
    }

    public void setHardiness(String hardiness) {
        this.hardiness = hardiness;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getCautions() {
        return cautions;
    }

    public void setCautions(String cautions) {
        this.cautions = cautions;
    }

    @Override
    public String toString() {
        return "Description{" +
                "id=" + id +
                ", family='" + family + '\'' +
                ", hardiness='" + hardiness + '\'' +
                ", use='" + use + '\'' +
                ", cautions='" + cautions + '\'' +
                '}';
    }
}
