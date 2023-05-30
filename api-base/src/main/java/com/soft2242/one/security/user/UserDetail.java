package com.soft2242.one.security.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : Flobby
 * @program : community-client-api
 * @description : 登录用户信息
 * @create : 2023-04-23 17:16
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private String realName;
    private String avatar;
    private Integer gender;
    private String email;
    private String mobile;
    private Integer status;
    private Integer superAdmin;
    private Integer isSuperAdmin;

    /**
     * 帐户是否过期
     */
    private boolean isAccountNonExpired = true;
    /**
     * 帐户是否被锁定
     */
    private boolean isAccountNonLocked = true;
    /**
     * 密码是否过期
     */
    private boolean isCredentialsNonExpired = true;
    /**
     * 帐户是否可用
     */
    private boolean isEnabled = true;
    /**
     * 拥有的权限集合
     */
    private Set<String> authoritySet;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoritySet.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}