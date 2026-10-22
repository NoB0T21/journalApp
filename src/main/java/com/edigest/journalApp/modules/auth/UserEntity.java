package com.edigest.journalApp.modules.auth;

import com.edigest.journalApp.Role;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document (collection = "user_entry")
public class UserEntity {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String userName;
    @Indexed(unique = true)
    private String email;
    private String passWord;
    private Role role;
    private LocalDateTime createdAt;
    private Date policyAcceptedAt;
    private Date termAcceptedAt;

    public Date getTermAcceptedAt() {
        return termAcceptedAt;
    }

    public void setTermAcceptedAt(Date termAcceptedAt) {
        this.termAcceptedAt = termAcceptedAt;
    }

    public Date getPolicyAcceptedAt() {
        return policyAcceptedAt;
    }

    public void setPolicyAcceptedAt(Date policyAcceptedAt) {
        this.policyAcceptedAt = policyAcceptedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
