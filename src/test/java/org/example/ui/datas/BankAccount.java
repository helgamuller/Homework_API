package org.example.ui.datas;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class BankAccount {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String SSN;
    private String username;
    private String password;
    private String passwordConfirmation;


}
