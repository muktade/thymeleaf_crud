package com.example.thyml.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.type.BlobType;
import org.hibernate.type.descriptor.sql.LobTypeMappings;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Data
public class User extends BaseEntity {
    private String username;
    private String email;
    private String password;
    private String photoPath;

    @Transient
    private MultipartFile photo;
}
