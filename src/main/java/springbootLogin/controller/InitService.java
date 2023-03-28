package springbootLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootLogin.security.Authority;
import springbootLogin.security.AuthorityName;
import springbootLogin.security.User;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class InitService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @PostConstruct
    public void initUsers() {

        this.userRepository.deleteAll();
        this.authorityRepository.deleteAll();

        User user = new User();
        user.setUsername("miranda"); // not to be confused with the user accessing the DB
        user.setPassword("$2a$12$CWO4tdkG.zyeJGfNrkK/xOIy842pFuzOuu6fNSKzPNgLgSbhXXHoC"); // Welkom01 bcrypted
        this.userRepository.save(user);

        user = new User();
        user.setUsername("vincent");
        user.setPassword("$2a$12$CWO4tdkG.zyeJGfNrkK/xOIy842pFuzOuu6fNSKzPNgLgSbhXXHoC"); // Welkom01 bcrypted
        this.userRepository.save(user);

        user = new User();
        user.setUsername("cornelis");
        user.setPassword("$2a$12$CWO4tdkG.zyeJGfNrkK/xOIy842pFuzOuu6fNSKzPNgLgSbhXXHoC"); // Welkom01 bcrypted
        this.userRepository.save(user);

        initAuthorities();
    }

    private void initAuthorities() {

        // miranda has all authorities SPREKER, ORGANISATOR and ADMINISTRATOR
        User user = this.userRepository.findByUsername("miranda");

        for (AuthorityName authorityName : AuthorityName.values()) {
            Authority authority = new Authority();
            authority.setName(authorityName);
            user.getAuthorities().add(authority);
        }
        this.userRepository.save(user);

        // vincent has authority SPREKER and ORGANISATOR
        user = this.userRepository.findByUsername("vincent");

        Authority authority = this.authorityRepository.findByName(AuthorityName.SPREKER);
        user.getAuthorities().add(authority);
        authority = this.authorityRepository.findByName(AuthorityName.ORGANISATOR);
        user.getAuthorities().add(authority);
        this.userRepository.save(user);

        // cornelis has authority SPREKER
        user = this.userRepository.findByUsername("cornelis");

        authority = this.authorityRepository.findByName(AuthorityName.SPREKER);
        user.getAuthorities().add(authority);
        this.userRepository.save(user);
    }
}