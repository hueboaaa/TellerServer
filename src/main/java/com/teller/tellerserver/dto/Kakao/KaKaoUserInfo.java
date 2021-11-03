package com.teller.tellerserver.dto.Kakao;

import lombok.Data;

@Data
public class KaKaoUserInfo {

    private String id;
    private String connected_at;
    public Properties properties;
    public Kakao_account kakao_account;

    @Data
    public class Properties{
        private String nickname;
    }

    @Data
    public class Kakao_account{
        private String profile_nickname_needs_agreement;
        private profile profile;
        private String has_email;
        private String email_needs_agreement;
        private String is_email_valid;
        private String is_email_verified;
        private String email;
        private String has_gender;
        private String gender_needs_agreement;
        private String gender;

        @Data
        public class profile{
            private String nickname;
        }
    }
}
