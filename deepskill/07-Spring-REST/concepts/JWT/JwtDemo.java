package concepts.JWT;

public class JwtDemo {
    public static void main(String[] args) {
        System.out.println("JWT (JSON Web Token) Authentication");
        System.out.println("===================================");
        System.out.println("1. User sends POST /api/auth/login with username/password");
        System.out.println("2. Server validates credentials and returns JWT token");
        System.out.println("3. Client sends JWT in Authorization: Bearer <token> header");
        System.out.println("4. JwtAuthFilter extracts username from token");
        System.out.println("5. If valid, request is authenticated");
        System.out.println();
        System.out.println("JWT Structure: header.payload.signature");
        System.out.println("Header: algorithm & token type");
        System.out.println("Payload: claims (username, issuedAt, expiration)");
        System.out.println("Signature: signed with secret key");
    }
}
