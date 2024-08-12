package allstar.allstar_back.domain.auth;

import allstar.allstar_back.domain.auth.jwt.AuthTokens;
import allstar.allstar_back.domain.auth.oauth2.KakaoLoginParams;
import allstar.allstar_back.domain.auth.service.OAuthLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final OAuthLoginService oAuthLoginService;

    @PostMapping("/kakao")
    public ResponseEntity<AuthTokens> loginKakao(@RequestBody KakaoLoginParams params) {
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }
}