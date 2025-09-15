package com.bahar.Bebka_Spring.service.impl;

import com.bahar.Bebka_Spring.model.User;
import com.bahar.Bebka_Spring.repository.UserRepository;
import com.bahar.Bebka_Spring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        log.info("Kullanıcı adı ile arama yapılıyor: {}", username);

        return userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    log.error("Kullanıcı bulunamadı: {}", username);
                    return new RuntimeException("User not found: " + username);
                });
    }

    @Override
    public User saveUser(User user) {
        log.debug("Yeni kullanıcı kaydediliyor: {}", user.getUsername());
        User saved = userRepository.save(user);
        log.info("Kullanıcı kaydedildi: {}", saved.getUsername());
        return saved;
    }
}