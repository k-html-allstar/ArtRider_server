package allstar.allstar_back.domain.auth.oauth2;

import allstar.allstar_back.Entity.Member;

public interface OAuthInfoResponse {
    String getEmail();
    Member.OAuthProvider getOAuthProvider();
}