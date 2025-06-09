package com.tfg.backend.config;

public abstract class ApiConfig {
    
    private static final String BASE_URL = "/tc_api/v1";
    public static final String CROSS_ORIGIN = "*"; // EN PRODUCCIÓN DEBERA SER CAMBIADO

    // SHARED \\ 
    private static final String ENDPOINT_CREATE = "/new";
    private static final String ENDPOINT_GET_ALL = "/all";

    // PATH VARIABLES \\
    public static final String PATH_USER_ID = "id_user";
    public static final String PATH_COUNTRY_ID = "id_country";
    public static final String PATH_USER_TYPE_ID = "id_user_type";
    public static final String PATH_BOARDGAME_ID = "id_boardgame";
    public static final String PATH_PACK_ID = "id_pack";
    public static final String PATH_COLLECTION_ID = "id_collection";
    public static final String PATH_SESSION_ID = "id_session";
    public static final String PATH_MEETING_ID = "id_meeting";
    public static final String PATH_STOCK_ID = "id_stock";
    public static final String PATH_LOAN_ID = "id_loan";
    public static final String PATH_LOAN_STATE_ID = "id_loan_state";
    public static final String PATH_USER_ASSOCIATE_ID = "id_user_associate";

    // ENTRYS \\
    private static final String ENTRY_USER_ID = "/{"+ PATH_USER_ID +"}";
    private static final String ENTRY_COUNTRY_ID = "/{"+ PATH_COUNTRY_ID +"}";
    private static final String ENTRY_USER_TYPE_ID = "/{"+ PATH_USER_TYPE_ID +"}";
    private static final String ENTRY_BOARDGAME_ID = "/{"+ PATH_BOARDGAME_ID +"}";
    private static final String ENTRY_PACK_ID = "/{"+ PATH_PACK_ID +"}";
    private static final String ENTRY_COLLECTION_ID = "/{"+ PATH_COLLECTION_ID +"}";
    private static final String ENTRY_SESSION_ID = "/{"+ PATH_SESSION_ID +"}";
    private static final String ENTRY_MEETING_ID = "/{"+ PATH_MEETING_ID +"}";
    private static final String ENTRY_STOCK_ID = "/{"+ PATH_STOCK_ID +"}";
    private static final String ENTRY_LOAN_ID = "/{"+ PATH_LOAN_ID +"}";
    private static final String ENTRY_LOAN_STATE_ID = "/{"+ PATH_LOAN_STATE_ID +"}";
    private static final String ENTRY_USER_ASSOCIATE_ID = "/{"+ PATH_USER_ASSOCIATE_ID +"}";

    // ENTITIES \\
    private static final String ENTITY_USER = "/user";
    private static final String ENTITY_COUNTRY = "/country";
    private static final String ENTITY_USER_TYPE = "/user_type";
    private static final String ENTITY_BOARDGAME = "/boardgame";
    private static final String ENTITY_BOARDGAME_GENDER = "/boardgame_gender";
    private static final String ENTITY_BOARDGAME_TYPE = "/boardgame_type";
    private static final String ENTITY_PACK = "/pack";
    private static final String ENTITY_BOARDGAME_PACK = "/boardgame_pack";
    private static final String ENTITY_COLLECTION = "/collection";
    private static final String ENTITY_SESSION = "/session";
    private static final String ENTITY_MEETING = "/meeting";
    private static final String ENTITY_STOCK = "/stock";
    private static final String ENTITY_LOAN = "/loan";
    private static final String ENTITY_LOAN_STATE = "/loan_state";
    private static final String ENTITY_USER_ASSOCIATE = "/user_associate";

    // PUBLIC ENDPOINTS - BASES \\
    public static final String ENDPOINT_BASE_USER = BASE_URL + ENTITY_USER;
    public static final String ENDPOINT_BASE_COUNTRY = BASE_URL + ENTITY_COUNTRY;
    public static final String ENDPOINT_BASE_USER_TYPE = BASE_URL + ENTITY_USER_TYPE;
    public static final String ENDPOINT_BASE_BOARDGAME = BASE_URL + ENTITY_BOARDGAME;
    public static final String ENDPOINT_BASE_BOARDGAME_GENDER = BASE_URL + ENTITY_BOARDGAME_GENDER;
    public static final String ENDPOINT_BASE_BOARDGAME_TYPE = BASE_URL + ENTITY_BOARDGAME_TYPE;
    public static final String ENDPOINT_BASE_PACK = BASE_URL + ENTITY_PACK;
    public static final String ENDPOINT_BASE_BOARDGAME_PACK = BASE_URL + ENTITY_BOARDGAME_PACK;
    public static final String ENDPOINT_BASE_COLLECTION = BASE_URL + ENTITY_COLLECTION;
    public static final String ENDPOINT_BASE_SESSION = BASE_URL + ENTITY_SESSION;
    public static final String ENDPOINT_BASE_MEETING = BASE_URL + ENTITY_MEETING;
    public static final String ENDPOINT_BASE_STOCK = BASE_URL + ENTITY_STOCK;
    public static final String ENDPOINT_BASE_LOAN = BASE_URL + ENTITY_LOAN;
    public static final String ENDPOINT_BASE_LOAN_STATE = BASE_URL + ENTITY_LOAN_STATE;
    public static final String ENDPOINT_BASE_USER_ASSOCIATE = BASE_URL + ENTITY_USER_ASSOCIATE;


    // PUBLIC ENDPOINTS \\

    // USER
    public static final String ENDPOINT_USER_REGISTRY = ENDPOINT_CREATE;
    public static final String ENDPOINT_USER_LOGIN = "/login";
    public static final String ENDPOINT_USER_EDIT = ENTRY_USER_ID;
    public static final String ENDPOINT_USER_DELETE = ENTRY_USER_ID;
    public static final String ENDPOINT_USER_PASSWORD_RECOVERY = "/recovery";
    public static final String ENDPOINT_USER_ALL_BY_TYPE = "/all_type" + ENTRY_USER_TYPE_ID;

    // COUNTRY 
    public static final String ENDPOINT_COUNTRY_ALL = ENDPOINT_GET_ALL;

    // USER TYPE 
    public static final String ENDPOINT_USER_TYPE_ALL = ENDPOINT_GET_ALL;

    // USER ASSOCIATE 
    public static final String ENDPOINT_ASSOCIATION_ADD = ENDPOINT_CREATE;
    public static final String ENDPOINT_ASSOCIATION_DELETE = ENTRY_USER_ASSOCIATE_ID;
    public static final String ENDPOINT_ASSOCIATIONS_BY_USER = "/all_associations" + ENTRY_USER_ID;
    public static final String ENDPOINT_ASSOCIATED_USERS_BY_HOST = "/all_associated" + ENTRY_USER_ID;

    // BOARDGAME
    public static final String ENDPOINT_BOARDGAME_CREATE = ENDPOINT_CREATE;
    public static final String ENDPOINT_BOARDGAME_BY_ID = ENTRY_BOARDGAME_ID;
    public static final String ENDPOINT_BOARDGAME_ALL = ENDPOINT_GET_ALL;

    // BOARDGAMEGEEK 
    public static final String ENDPOINT_BOARDGAMEGEEK_SEARCH_BOARDGAME = "/search-bgg/{boardgame_name}";

    // BOARDGAME TYPE
    public static final String ENDPOINT_BOARDGAME_TYPE_ALL = ENDPOINT_GET_ALL;

    // BOARDGAME GENDER
    public static final String ENDPOINT_BOARDGAME_GENDER_ALL = ENDPOINT_GET_ALL;

    // COLLECTION
    public static final String ENDPOINT_BOARDGAME_ADD_TO_COLLECTION = ENTITY_USER + ENTRY_USER_ID + ENTITY_BOARDGAME + ENTRY_BOARDGAME_ID;
    public static final String ENDPOINT_BOARDGAME_DELETE_FROM_COLLECTION = ENTITY_USER + ENTRY_USER_ID + ENTITY_BOARDGAME + ENTRY_BOARDGAME_ID;
    public static final String ENDPOINT_BOARDGAME_COLLECTION_BY_USER = ENDPOINT_GET_ALL + ENTITY_USER + ENTRY_USER_ID;

    // MEETING
    public static final String ENDPOINT_MEETING_CREATE = ENDPOINT_CREATE;
    public static final String ENDPOINT_MEETING_DELETE = ENTRY_MEETING_ID;
    public static final String ENDPOINT_MEETING_ALL_BY_SESSION = ENDPOINT_GET_ALL + ENTITY_SESSION + ENTRY_SESSION_ID;
    public static final String ENDPOINT_MEETING_ALL_BY_USER = ENDPOINT_GET_ALL + ENTITY_USER + ENTRY_USER_ID;

    // SESSION
    public static final String ENDPOINT_SESSION_CREATE = ENDPOINT_CREATE;
    public static final String ENDPOINT_SESSION_UPDATE = ENTRY_SESSION_ID;
    public static final String ENDPOINT_SESSION_DELETE = ENTRY_SESSION_ID;
    public static final String ENDPOINT_SESSION_ALL_BY_USER = ENDPOINT_GET_ALL + ENTITY_USER + ENTRY_USER_ID;

    // PACK
    public static final String ENDPOINT_PACK_CREATE = ENDPOINT_CREATE;
    public static final String ENDPOINT_PACK_DELETE = ENTRY_PACK_ID;
    public static final String ENDPOINT_PACK_ALL_BY_USER = ENDPOINT_GET_ALL + ENTITY_USER + ENTRY_USER_ID;

    // BOARDGAME PACK
    public static final String ENDPOINT_PACK_ADD_BOARDGAME = ENTRY_PACK_ID + ENTITY_BOARDGAME + ENTRY_BOARDGAME_ID;
    public static final String ENDPOINT_PACK_DELETE_BOARDGAME = ENTRY_PACK_ID + ENTITY_BOARDGAME + ENTRY_BOARDGAME_ID;
    public static final String ENDPOINT_PACK_ALL_BOARDGAMES = "/all_boardgames" + ENTRY_PACK_ID;

    // LOAN
    public static final String ENDPOINT_LOAN_ADD = ENDPOINT_CREATE;
    public static final String ENDPOINT_LOAN_UPDATE = ENTRY_LOAN_ID;
    public static final String ENDPOINT_LOAN_DELETE = ENTRY_LOAN_ID;
    public static final String ENDPOINT_LOAN_ALL_BY_STOCK = ENDPOINT_GET_ALL + ENTITY_STOCK + ENTRY_STOCK_ID;
    public static final String ENDPOINT_LOAN_ALL_BY_USER = ENDPOINT_GET_ALL + ENTITY_USER + ENTRY_USER_ID;

    // LOAN STATE
    public static final String ENDPOINT_LOAN_STATE_ALL = ENDPOINT_GET_ALL;

    // STOCK
    public static final String ENDPOINT_STOCK_ADD = ENDPOINT_CREATE;
    public static final String ENDPOINT_STOCK_UPDATE = ENTRY_STOCK_ID;
    public static final String ENDPOINT_STOCK_DELETE = ENTRY_STOCK_ID;
    public static final String ENDPOINT_STOCK_ALL_BY_USER = ENDPOINT_GET_ALL + ENTITY_USER + ENTRY_USER_ID;
}