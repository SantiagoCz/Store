package santiagoczarny.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import santiagoczarny.store.entities.AppUser;
import santiagoczarny.store.entities.Person;
import santiagoczarny.store.entities.Role;
import santiagoczarny.store.repositories.AppUserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser save(AppUser user){
        return appUserRepository.save(user);
    }

    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    public AppUser buildAdminUser(Person person, AppUser user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());

        return AppUser.builder()
                .person(person)
                .password(password)
                .role(Role.ADMIN)
                .build();
    }

    public AppUser buildRegularUser(Person person, AppUser user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        return AppUser.builder()
                .person(person)
                .password(password)
                .role(Role.USER)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findUserByPerson_Dni(dni);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + dni);
        }

        List<GrantedAuthority> authorities = buildAuthorities(user);
        return buildUser(user, authorities);
    }

    public UserDetails buildUser(AppUser user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getPerson().getDni(),
                user.getPassword(),
                authorities
        );
    }

    public List<GrantedAuthority> buildAuthorities(AppUser user) {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());
        return Collections.singletonList(authority);
    }

    // Method to find user by username
    public AppUser findByUsername(String username) {
        return appUserRepository.findByPerson_Dni(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
