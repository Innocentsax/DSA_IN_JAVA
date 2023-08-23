package dev.InnocentUdo.Models;

public class StaticVar {

    public final static String SUCCESS_MESSAGE = " Successful";
    public final static String FALSE_STATUS_MESSAGE = " Status: False";
    public final static String TRUE_STATUS_MESSAGE = " Status: True";
    public final static String VERIFICATION_PASS_MESSAGE = "Verification pass";
    public final static String VERIFICATION_FAILS_MESSAGE = "Verification fails";
    public final static String WRONG_EMAIL_MESSAGE = " Enter a valid Email address";
    public final static String USERNAME_NOT_NULL_MESSAGE = " Username cannot be empty";
    public final static String EMAIL_NOT_NULL_MESSAGE = " Email cannot be empty";
    public final static String PASSWORD_NOT_NULL_MESSAGE = " Password cannot be empty";
    public final static String DATE_OF_BIRTH_NOT_NULL_MESSAGE = " Password cannot be empty";
    public final static String MINIMUM_CHARACTER_MESSAGE = " Provide username with minimum of 4 characters";
    public final static String PASSWORD_MINIMUM_CHARACTER_MESSAGE = " Password must be minimum of 8 characters";
    public final static String MINIMUM_AGE_MESSAGE = " Underage! Minimum age is 16 years";
    public final static String WEAK_PASSWORD = " Weak Password: Password must contain Number, Uppercase and Special character";
    public final static String REGEX_PATTERN =  "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
    public final static String JWT_SECRET =  "RPTyyaBeHl04wqPFd86G/tssX+pTxPq6HHCa2QnCOAU=";
    public final static long JWT_SECRET_EXPIRATION = 86400000;
}
