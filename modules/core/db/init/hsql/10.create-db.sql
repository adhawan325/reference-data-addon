-- begin NONRDA_REFERENCE_DATA
create table NONRDA_REFERENCE_DATA (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REFERENCE_CATEGORY varchar(255) not null,
    REFERENCE_CODE varchar(255) not null,
    REFERENCE_VALUE varchar(255) not null,
    SORT_ORDER bigint not null,
    PARENT_ID varchar(36),
    --
    primary key (ID)
)^
-- end NONRDA_REFERENCE_DATA
