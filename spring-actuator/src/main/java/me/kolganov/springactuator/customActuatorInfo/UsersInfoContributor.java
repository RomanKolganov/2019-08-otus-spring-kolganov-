package me.kolganov.springactuator.customActuatorInfo;

import me.kolganov.springactuator.dao.UserRepository;
import me.kolganov.springactuator.domain.AppUser;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
public class UsersInfoContributor implements InfoContributor {
    private final UserRepository userRepository;

    public UsersInfoContributor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("users quantity", userRepository.count());
        userDetails.put("users", userRepository.findAll().stream().map(AppUser::toJson));

        builder.withDetail("users", userDetails);
    }
}
