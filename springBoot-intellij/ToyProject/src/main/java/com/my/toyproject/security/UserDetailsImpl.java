package com.my.toyproject.security;

import com.my.toyproject.domain.User;
import java.util.ArrayList;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    // User Entity 타입의 참조변수 선언
    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    // user Entity 가 가지고 있는 권한 목록을 저장하여 리턴한다.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 목록을 저장할 컬렉션
        Collection<GrantedAuthority> roleList = new ArrayList<>();

        // 권한 설정
        roleList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_" + user.getRole();
            }
        });
        return roleList;
    }

    // 패스워드 리턴하기.
    @Override
    public String getPassword() {
        return "{noop}" + user.getPassword();
    }

    // 유저 이름 리턴하기
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정이 만료가 안되었는지 여부를 리턴한다.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있지 않은지 여부를 리턴한다
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호가 만료되었는지 여부를 리턴한다.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화 되었는지 여부를 리턴한다.
    @Override
    public boolean isEnabled() {
        return true;
    }
}
