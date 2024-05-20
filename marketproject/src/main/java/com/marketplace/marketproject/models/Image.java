package com.marketplace.marketproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
//import jakarta.persistence.*;
import lombok.NoArgsConstructor;
//import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Types;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="originalFilename")
    private String originalFileName;
    @Column(name="size")
    private Long size;
    @Column(name="contentType")
    private String contentType;
    @Column(name="isPreviewImage")
    private boolean isPreviewImage;
    @Lob
    @Type(type="org.hibernate.type.ImageType")//@Column(name="bytes", columnDefinition="bytea")//@JdbcTypeCode(Types.LONGVARBINARY)
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;
    }
