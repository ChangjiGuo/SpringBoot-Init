package com.ly.ysmr.framework.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description:
 *
 * @author changji.guo
 * @date 2020/4/26 16:23
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "ysmr_admin")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private long adminId;
    @Column(name = "admin_user")
    private String adminUser;
    @Column(name = "admin_email")
    private String adminEmail;
    @Column(name = "admin_phone")
    private String adminPhone;

}
