package sb.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VerificationToken {
    // Expiration time
    private static final int EXPIRATION_TIME = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    private Date expirationTime;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_VERIFY"))
    private User user;

    public VerificationToken(User user, String token){
        super();
        this.token = token;
        this.user = user;
        this.expirationTime = calculateExpirationData(EXPIRATION_TIME);
    }

    public VerificationToken(String token){
        super();
        this.token = token;
        this.expirationTime = calculateExpirationData(EXPIRATION_TIME);
    }

    private Date calculateExpirationData(int expirationTime){
        Calendar calendar =  Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationTime);
        return new Date(calendar.getTime().getTime());
    }
}
