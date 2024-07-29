package com.example.back.dto.response;

public interface ResponseCode {
    
    String SUCCESS = "SU";

    String NO_EXIST_LOT = "NEL";
    String NO_EXIST_RANK = "NER";
    String NO_EXIST_ITEM = "NEI";
    String NO_EXIST_AREA = "NEA";
    String NO_EXIST_BOARD = "NEB";
    String NO_EXIST_CLIENT = "NEC";
    String NO_EXIST_MEMBER = "NEM";
    String NO_EXIST_RACK = "NERACK";
    String NO_EXIST_CELL = "NECELL";
    String NO_EXIST_WAREHOUSE = "NEW";
    String NO_EXIST_DEPARTMENT = "NED";

    String DUPLICATED_ID = "DI";
    
    String AUTHORIZATION_FAILED = "AF";
    String AUTHENTICATION_FAILED = "AF";
    String TOKEN_CREATION_FAILED = "TF";
    String SIGN_IN_FAILED = "Sign in Failed.";
    
    String DATABASE_ERROR = "DBE";
    String VALIDATION_FAILED = "VF";
    
    String PAGE_NOT_FOUND = "PNF";

}
