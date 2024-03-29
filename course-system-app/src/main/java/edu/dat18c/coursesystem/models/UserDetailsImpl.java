package edu.dat18c.coursesystem.models;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UserDetailsImpl
 */
public class UserDetailsImpl implements UserDetails 
{
    private static final long serialVersionUID = 1247167559158178505L;

    private User user;

    public UserDetailsImpl(User user) 
    {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        int role_id = (int)user.getRole().getId();

        switch (role_id) 
        {
            case 1:
                return Collections.singleton(new SimpleGrantedAuthority("ROLE_STUDENT"));
            case 2:
                return Collections.singleton(new SimpleGrantedAuthority("ROLE_TEACHER"));
            case 3:
                return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
            default:
                return null;
        }
    }

    @Override
    public String getPassword() 
    {
        return user.getPassword();
    }

    @Override
    public String getUsername() 
    {
        return user.getEmail().toLowerCase();
    }

    @Override
    public boolean isAccountNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() 
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isEnabled() 
    {
        return true;
    }
}