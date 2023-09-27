package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.entity.RefreshToken;
import store.bizscanner.repository.RefreshTokenRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void saveOrUpdateRefreshToken(String email, String refreshToken) {

        Optional<RefreshToken> currRefreshToken = refreshTokenRepository.findByEmail(email);

        if (currRefreshToken.isPresent()) {
            currRefreshToken.get().setRefreshToken(refreshToken);

        } else {
            refreshTokenRepository.save(new RefreshToken(email, refreshToken));
        }
    }

}
