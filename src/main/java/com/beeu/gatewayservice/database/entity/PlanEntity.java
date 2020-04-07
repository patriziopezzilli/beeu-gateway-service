package com.beeu.gatewayservice.database.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "BEEU_PLAN")
@Entity
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String code;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<FamilyEntity> families;

    public PlanEntity() {

    }

    public PlanEntity(String name, String description, String code, List<FamilyEntity> families) {
        this.families = families;

        if (null != families) {
            for (FamilyEntity family : families) {
                family.setPlan(this);
            }
        }

        this.code = code;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<FamilyEntity> getFamilies() {
        return families;
    }

    public void setFamilies(List<FamilyEntity> families) {
        this.families = families;

        if (null != families) {
            for (FamilyEntity family : families) {
                family.setPlan(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanEntity that = (PlanEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(code, that.code) &&
                Objects.equals(families, that.families);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, code, families);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", families=").append(families);
        sb.append('}');
        return sb.toString();
    }
}
