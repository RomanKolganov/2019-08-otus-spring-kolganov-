package me.kolganov.springboothistryx.customActuatorInfo;

import lombok.RequiredArgsConstructor;
import me.kolganov.springboothistryx.dao.UserRepository;
import me.kolganov.springboothistryx.domain.AppUser;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class UsersInfoContributor implements InfoContributor {
    private final UserRepository userRepository;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("users quantity", userRepository.count());
        userDetails.put("users", userRepository.findAll().stream().map(AppUser::toJson));

        builder.withDetail("users", userDetails);
    }
}
