package com.bsu.by.data.agent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estate implements Versionable {
    @Id
    @NotNull
    private String id;

    @NotNull
    private boolean apartment;

    @NotNull
    private String location;

    @NotNull
    private double area;

    @NotNull
    private String description;

    @NotNull
    private String fileName;

    @NotNull
    private Integer version;
}
