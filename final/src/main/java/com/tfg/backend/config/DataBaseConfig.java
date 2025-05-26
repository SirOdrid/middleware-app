package com.tfg.backend.config;

public abstract class DataBaseConfig {

    // ENTITIES 

    private static final String ENTITY_NAME = "_name";

    public static final String USER_ENTITY = "user";
    public static final String USER_TYPE_ENTITY = "user_type";
    public static final String COUNTRY_ENTITY = "country";
    public static final String BOARDGAME_ENTITY = "boardgame";
    public static final String BOARDGAME_GENDER_ENTITY = "boardgame_gender";
    public static final String BOARDGAME_TYPE_ENTITY = "boardgame_type";
    public static final String BOARDGAME_PACK_ENTITY = "boardgame_pack";
    public static final String PACK_ENTITY = "pack";
    public static final String COLLECTION_ENTITY = "collection";
    public static final String SESSION_ENTITY = "session";
    public static final String MEETING_ENTITY = "meeting";
    public static final String STOCK_ENTITY = "stock";
    public static final String LOAN_ENTITY = "loan";
    public static final String LOAN_STATE_ENTITY = "loan_state";
    public static final String USER_ASSOCIATE_ENTITY = "user_associate";
    
    // TYPES_INFO
    private static final String TYPE_INT = "INT";
    private static final String TYPE_VARCHAR = "VARCHAR";
    private static final String TYPE_DATE = "DATE";
    private static final String TYPE_BOOLEAN = "BOOLEAN";
    private static final String TYPE_MEDIUMBLOB = "MEDIUMBLOB";
    private static final String TYPE_TIME = "TIME";

    // PRIMARY KEYS
    private static final String PRIMARY_KEY_PREFIX = "_id";

    public static final String PK_USER_ENTITY = USER_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_USER_TYPE_ENTITY = USER_TYPE_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_COUNTRY_ENTITY = COUNTRY_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_BOARDGAME_ENTITY = BOARDGAME_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_BOARDGAME_GENDER_ENTITY = BOARDGAME_GENDER_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_BOARDGAME_TYPE_ENTITY = BOARDGAME_TYPE_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_PACK_ENTITY = PACK_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_BOARDGAME_PACK_ENTITY = BOARDGAME_PACK_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_COLLECTION_ENTITY = COLLECTION_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_SESSION_ENTITY = SESSION_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_MEETING_ENTITY = MEETING_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_STOCK_ENTITY = STOCK_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_LOAN_ENTITY = LOAN_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_LOAN_STATE_ENTITY = LOAN_STATE_ENTITY + PRIMARY_KEY_PREFIX;
    public static final String PK_USER_ASSOCIATE_ENTITY = USER_ASSOCIATE_ENTITY + PRIMARY_KEY_PREFIX;

    // FOREIGN KEYS
    private static final String FOREIGN_KEY_PREFIX = "fk_";

    private static final String FK_USER_ENTITY = FOREIGN_KEY_PREFIX + USER_ENTITY;
    private static final String FK_USER_TYPE_ENTITY = FOREIGN_KEY_PREFIX + USER_TYPE_ENTITY;
    private static final String FK_COUNTRY_ENTITY = FOREIGN_KEY_PREFIX + COUNTRY_ENTITY;
    private static final String FK_BOARDGAME_ENTITY = FOREIGN_KEY_PREFIX + BOARDGAME_ENTITY;
    private static final String FK_BOARDGAME_GENDER_ENTITY = FOREIGN_KEY_PREFIX + BOARDGAME_GENDER_ENTITY;
    private static final String FK_BOARDGAME_TYPE_ENTITY = FOREIGN_KEY_PREFIX + BOARDGAME_TYPE_ENTITY;
    private static final String FK_BOARDGAME_PACK_ENTITY = FOREIGN_KEY_PREFIX + BOARDGAME_PACK_ENTITY;
    private static final String FK_PACK_ENTITY = FOREIGN_KEY_PREFIX + PACK_ENTITY;
    private static final String FK_COLLECTION_ENTITY = FOREIGN_KEY_PREFIX + COLLECTION_ENTITY;
    private static final String FK_SESSION_ENTITY = FOREIGN_KEY_PREFIX + SESSION_ENTITY;
    private static final String FK_MEETING_ENTITY = FOREIGN_KEY_PREFIX + MEETING_ENTITY;
    private static final String FK_STOCK_ENTITY = FOREIGN_KEY_PREFIX + STOCK_ENTITY;
    private static final String FK_LOAN_ENTITY = FOREIGN_KEY_PREFIX + LOAN_ENTITY;
    private static final String FK_LOAN_STATE_ENTITY = FOREIGN_KEY_PREFIX + LOAN_STATE_ENTITY;
    private static final String FK_USER_ASSOCIATE_ENTITY = FOREIGN_KEY_PREFIX + USER_ASSOCIATE_ENTITY;

    // USER COLUMNS
    public static final String USER_COLUMN_USER_NAME = USER_ENTITY + ENTITY_NAME;
    public static final int USER_NAME_MIN_CHARACTERS = 3;
    public static final int USER_NAME_MAX_CHARACTERS = 40;
    public static final String USER_COLUMN_USER_NAME_DEFINITION = TYPE_VARCHAR + " (" + USER_NAME_MAX_CHARACTERS + ") UNIQUE NOT NULL";

    public static final String USER_COLUMN_PASS_HASH = "pass_hash";
    public static final int USER_PASS_HASH_MAX_CHARACTERS = 260;
    public static final String USER_COLUMN_PASS_HASH_DEFINITION = TYPE_VARCHAR + " (" + USER_PASS_HASH_MAX_CHARACTERS + ") NOT NULL";

    public static final String USER_COLUMN_EMAIL = "email";
    public static final int USER_EMAIL_MIN_CHARACTERS = 6;
    public static final int USER_EMAIL_MAX_CHARACTERS = 60;
    public static final String USER_COLUMN_EMAIL_DEFINITION = TYPE_VARCHAR + " (" + USER_EMAIL_MAX_CHARACTERS + ") UNIQUE NOT NULL";

    public static final String USER_COLUMN_PROFILE_IMAGE = "profile_image";
    public static final String USER_COLUMN_PROFILE_IMAGE_DEFINITION = TYPE_MEDIUMBLOB;

    public static final String USER_COLUMN_PHONE_NUMBER = "phone_number";
    public static final String USER_COLUMN_PHONE_NUMBER_DEFINITION = TYPE_INT;

    public static final String USER_COLUMN_EMAIL_NOTIFICATIONS = "email_notifications";
    public static final String USER_COLUMN_EMAIL_NOTIFICATIONS_DEFINITION = TYPE_BOOLEAN + " NOT NULL";

    public static final String USER_COLUMN_CREATION_DATE = "creation_date";
    public static final String USER_COLUMN_CREATION_DATE_DEFINITION = TYPE_DATE;

    public static final String USER_COLUMN_USER_TYPE = FK_USER_TYPE_ENTITY;
    public static final String USER_COLUMN_COUNTRY = FK_COUNTRY_ENTITY;
    public static final String USER_COLUMN_USER_ASSOCIATE = FK_USER_ASSOCIATE_ENTITY;

    // USER_TYPE COLUMNS
    public static final String USER_TYPE_COLUMN_USER_TYPE_NAME = USER_TYPE_ENTITY + ENTITY_NAME;
    public static final int USER_TYPE_NAME_MAX_CHARACTERS = 20;
    public static final String USER_TYPE_COLUMN_USER_TYPE_NAME_DEFINITION = TYPE_VARCHAR + " (" + USER_TYPE_NAME_MAX_CHARACTERS + ") UNIQUE NOT NULL";

    // USER_ASSOCIATE COLUMNS
    public static final String USER_ASSOCIATE_COLUMN_ASSOCIATION_DATE = "association_date";
    public static final String USER_ASSOCIATE_COLUMN_ASSOCIATION_DATE_DEFINITION = TYPE_DATE + " NOT NULL";

    public static final String USER_ASSOCIATE_COLUMN_HOST_USER = FK_USER_ENTITY + "_host";
    public static final String USER_ASSOCIATE_COLUMN_ASSOCIATE_USER = FK_USER_ENTITY + "_associate";

    // COUNTRY COLUMNS
    public static final String COUNTRY_COLUMN_COUNTRY_NAME = COUNTRY_ENTITY + ENTITY_NAME;
    public static final int COUNTRY_NAME_MAX_CHARACTERS = 40;
    public static final String COUNTRY_COLUMN_COUNTRY_NAME_DEFINITION = TYPE_VARCHAR + " (" + COUNTRY_NAME_MAX_CHARACTERS + ") UNIQUE NOT NULL";

    // BOARDGAME COLUMNS
    public static final String BOARDGAME_COLUMN_BOARDGAME_NAME = BOARDGAME_ENTITY + ENTITY_NAME;
    public static final int BOARDGAME_NAME_MIN_CHARACTERS = 2;
    public static final int BOARDGAME_NAME_MAX_CHARACTERS = 120;
    public static final String BOARDGAME_COLUMN_BOARDGAME_NAME_DEFINITION = TYPE_VARCHAR + " (" + BOARDGAME_NAME_MAX_CHARACTERS + ") NOT NULL";

    public static final String BOARDGAME_COLUMN_API_BGG_REF = "api_bgg_ref";
    public static final int BOARDGAME_API_BGG_REF_MAX_CHARACTERS = 255;
    public static final String BOARDGAME_COLUMN_API_BGG_REF_DEFINITION = TYPE_VARCHAR + " (" + BOARDGAME_API_BGG_REF_MAX_CHARACTERS + ") UNIQUE NOT NULL";

    public static final String BOARDGAME_COLUMN_PLAYERS_MIN = BOARDGAME_ENTITY + "_players_min";
    public static final String BOARDGAME_COLUMN_PLAYERS_MIN_DEFINITION = TYPE_INT + " NOT NULL";

    public static final String BOARDGAME_COLUMN_PLAYERS_MAX = BOARDGAME_ENTITY + "_players_max";
    public static final String BOARDGAME_COLUMN_PLAYERS_MAX_DEFINITION = TYPE_INT + " NOT NULL";

    public static final String BOARDGAME_COLUMN_RELEASE_YEAR = BOARDGAME_ENTITY + "release_year";
    public static final String BOARDGAME_COLUMN_RELEASE_YEAR_DEFINITION = TYPE_INT;
    
    public static final String BOARDGAME_COLUMN_DESCRIPTION = BOARDGAME_ENTITY + "description";
    public static final int BOARDGAME_DESCRIPTION_MAX_CHARACTERS = 10000;
    public static final String BOARDGAME_COLUMN_DESCRIPTION_DEFINITION = TYPE_VARCHAR + " (" + BOARDGAME_DESCRIPTION_MAX_CHARACTERS + ")";

    public static final String BOARDGAME_COLUMN_IMAGE_ENDPOINT = BOARDGAME_ENTITY + "image_endpoint";
    public static final int BOARDGAME_IMAGE_ENDPOINT_MAX_CHARACTERS = 255;
    public static final String BOARDGAME_COLUMN_IMAGE_ENDPOINT_DEFINITION = TYPE_VARCHAR + " (" + BOARDGAME_IMAGE_ENDPOINT_MAX_CHARACTERS + ")";

    public static final String BOARDGAME_COLUMN_BOARDGAME_GENDER = FK_BOARDGAME_GENDER_ENTITY;
    public static final String BOARDGAME_COLUMN_BOARDGAME_TYPE = FK_BOARDGAME_TYPE_ENTITY;
    public static final String BOARDGAME_COLUMN_BOARDGAME_BASE = FK_BOARDGAME_ENTITY + "_base";

    // BOARDGAME_GENDER COLUMNS
    public static final String BOARDGAME_GENDER_COLUMN_GENDER_NAME = BOARDGAME_GENDER_ENTITY + ENTITY_NAME;
    public static final int BOARDGAME_GENDER_NAME_MAX_CHARACTERS = 50;
    public static final String BOARDGAME_GENDER_COLUMN_GENDER_NAME_DEFINITION = TYPE_VARCHAR + " (" + BOARDGAME_GENDER_NAME_MAX_CHARACTERS + ") UNIQUE NOT NULL";

    // BOARDGAME_TYPE COLUMNS
    public static final String BOARDGAME_TYPE_COLUMN_TYPE_NAME = BOARDGAME_TYPE_ENTITY + ENTITY_NAME;
    public static final int BOARDGAME_TYPE_NAME_MAX_CHARACTERS = 15;
    public static final String BOARDGAME_TYPE_COLUMN_TYPE_NAME_DEFINITION = TYPE_VARCHAR + " (" + BOARDGAME_TYPE_NAME_MAX_CHARACTERS + ") UNIQUE NOT NULL";

    // BOARDGAME_PACK COLUMNS
    public static final String BOARDGAME_PACK_COLUMN_BOARDGAME = FK_BOARDGAME_ENTITY;
    public static final String BOARDGAME_PACK_COLUMN_PACK = FK_PACK_ENTITY;

    // PACK COLUMNS
    public static final String PACK_COLUMN_PACK_NAME = PACK_ENTITY + ENTITY_NAME;
    public static final int PACK_NAME_MIN_CHARACTERS = 3;
    public static final int PACK_NAME_MAX_CHARACTERS = 40;
    public static final String PACK_COLUMN_PACK_NAME_DEFINITION = TYPE_VARCHAR + " (" + PACK_NAME_MAX_CHARACTERS + ") NOT NULL";

    public static final String PACK_COLUMN_USER = FK_USER_ENTITY;

    // COLLECTION COLUMNS
    public static final String COLLECTION_COLUMN_REGISTRY_DATE = "registry_date";
    public static final String COLLECTION_COLUMN_REGISTRY_DATE_DEFINITION = TYPE_DATE + " NOT NULL";

    public static final String COLLECTION_COLUMN_BOARDGAME = FK_BOARDGAME_ENTITY;
    public static final String COLLECTION_COLUMN_USER = FK_USER_ENTITY;

    // SESSION COLUMNS
    public static final String SESSION_COLUMN_SESSION_NAME = SESSION_ENTITY + ENTITY_NAME;
    public static final int SESSION_NAME_MIN_CHARACTERS = 3;
    public static final int SESSION_NAME_MAX_CHARACTERS = 50;
    public static final String SESSION_COLUMN_SESSION_NAME_DEFINITION = TYPE_VARCHAR + " (" + SESSION_NAME_MAX_CHARACTERS + ") NOT NULL";

    public static final String SESSION_COLUMN_SESSION_DATE = "session_date";
    public static final String SESSION_COLUMN_SESSION_DATE_DEFINITION = TYPE_DATE + " NOT NULL";

    public static final String SESSION_COLUMN_SESSION_HOST = FK_SESSION_ENTITY + "_host";

    // MEETING COLUMNS
    public static final String MEETING_COLUMN_MEETING_DURATION = "meeting_duration";
    public static final String MEETING_COLUMN_MEETING_DURATION_DEFINITION = TYPE_TIME + " NOT NULL";

    public static final String MEETING_COLUMN_SESSION = FK_SESSION_ENTITY;
    public static final String MEETING_COLUMN_BOARDGAME = FK_BOARDGAME_ENTITY;

    // STOCK COLUMNS
    public static final String STOCK_COLUMN_STOCK_UNITS = "stock_units";
    public static final String STOCK_COLUMN_STOCK_UNITS_DEFINITION = TYPE_INT + " NOT NULL";

    public static final String STOCK_COLUMN_BOARDGAME = FK_BOARDGAME_ENTITY;
    public static final String STOCK_COLUMN_USER = FK_USER_ENTITY;

    // LOAN COLUMNS
    public static final String LOAN_COLUMN_LOAN_DATE = "loan_date";
    public static final String LOAN_COLUMN_LOAN_DATE_DEFINITION = TYPE_DATE + " NOT NULL";

    public static final String LOAN_COLUMN_EXPIRATION_DATE = "expiration_date";
    public static final String LOAN_COLUMN_EXPIRATION_DATE_DEFINITION = TYPE_DATE;

    public static final String LOAN_COLUMN_LOAN_STATE = FK_LOAN_STATE_ENTITY;
    public static final String LOAN_COLUMN_STOCK = FK_STOCK_ENTITY;
    public static final String LOAN_COLUMN_USER = FK_USER_ENTITY;

    // LOAN STATE COLUMNS
    public static final String LOAN_STATE_COLUMN_LOAN_STATE_NAME = "loan_state_name";
    public static final int LOAN_STATE_NAME_MAX_CHARACTERS = 25;
    public static final String LOAN_STATE_COLUMN_LOAN_STATE_NAME_DEFINITION = TYPE_VARCHAR + " (" + LOAN_STATE_NAME_MAX_CHARACTERS + ") UNIQUE NOT NULL";
}
 