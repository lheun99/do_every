package com.project.everything.User;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class) // Auditing 리스너 추가
public class UserEntity {
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userMail;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(nullable = false)
    @CreatedDate
    private Date createdAt;

    @Builder
    public UserEntity(String userId, String userPw, String userName, String userMail, Date birthDate, Date createdAt){
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userMail = userMail;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
    }

    // 엔티티가 비어 있는지 체크하는 메서드
    public boolean isEmpty() {
        return userId == null || userId.trim().isEmpty() ||
                userPw == null || userPw.trim().isEmpty() ||
                userName == null || userName.trim().isEmpty() ||
                userMail == null || userMail.trim().isEmpty() ||
                birthDate == null;
    }
}
