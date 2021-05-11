package com.github.abhishek.user.valueObject;

import com.github.abhishek.user.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {

    //This is a wrapper class
    private User user;
    private Department department;

}
