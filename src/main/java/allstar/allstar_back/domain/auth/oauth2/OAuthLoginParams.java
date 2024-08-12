package allstar.allstar_back.domain.auth.oauth2;

import allstar.allstar_back.Entity.Member;
import org.springframework.util.MultiValueMap;


public interface OAuthLoginParams {
    Member.OAuthProvider oAuthProvider();
    MultiValueMap<String, String> makeBody();
}
