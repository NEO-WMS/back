package com.example.back.dto.response;

public interface ResponseMessage {
    
    String SUCCESS = "Success.";

    
    String NO_EXIST_LOT = "No Exist Lot.";
    String NO_EXIST_ITEM = "No Exist Item.";
    String NO_EXIST_AREA = "No Exist Area.";
    String NO_EXIST_RACK = "No Exist Rack.";
    String NO_EXIST_RANK = "No Exist Rank.";
    String NO_EXIST_CELL = "No Exist Cell.";
    String NO_EXIST_BOARD = "No Exist Board.";
    String NO_EXIST_CLIENT = "No Exist Client.";
    String NO_EXIST_MEMBER = "No Exist Member.";
    String NO_EXIST_WAREHOUSE = "No Exist Warehouse.";
    String NO_EXIST_DEPARTMENT = "No Exist Department.";

    String DUPLICATED_ID = "Duplicated Id";
    
    String SIGN_IN_FAILED = "Sign in Failed.";
    String AUTHORIZATION_FAILED = "Authorization Failed.";
    String AUTHENTICATION_FAILED = "Authentication Failed.";
    String TOKEN_CREATION_FAILED = "Token creation Failed.";
    
    String DATABASE_ERROR = "Database Error.";
    String VALIDATION_FAILED = "Validation Failed.";

    String PAGE_NOT_FOUND = "Page Not Found.";

}
