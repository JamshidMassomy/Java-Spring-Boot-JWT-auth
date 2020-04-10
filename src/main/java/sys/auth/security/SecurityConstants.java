package sys.auth.security;

public class SecurityConstants {
    public static final String JWT_KEY="THIS_IS_MY_SECRET_KEY_FOR_JWT";
    public static final String JWT_HEADER="Authorization";
    public static final String JWT_PREFIX="Bearer ";
    public static final  long EXPIRATION_TIME=30000;
}
