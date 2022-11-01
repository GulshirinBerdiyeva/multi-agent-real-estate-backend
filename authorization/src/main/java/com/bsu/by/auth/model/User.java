package com.bsu.by.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Versionable {
    @Id
    @NotNull
    private String id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String roleId;

    @NotNull
    private Integer version;
}
