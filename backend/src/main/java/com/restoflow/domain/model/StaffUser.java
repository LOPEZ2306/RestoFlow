package com.restoflow.domain.model;

import com.restoflow.domain.vo.Role;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class StaffUser {
    private UUID id;
    private String email;
    private String passwordHash;
    private String fullName;
    private Role role;
    private boolean active;
    private LocalDateTime createdAt;
}
