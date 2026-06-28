package com.vedansh.payforge.merchant.entity;

import com.vedansh.payforge.common.enums.UserRole;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    // ManyToOne -> means many AppUser to one merchant
    // OneToMany -> means One AppUser   to many merchant
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="merchant_id") // refer to merchant table FK
    private Merchant merchant;

    @Column(unique=true,nullable=false)
    private String email;

    @Column(nullable=false)
    private String passwordHash;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
