-- begin NONRDA_REFERENCE_DATA
alter table NONRDA_REFERENCE_DATA add constraint FK_NONRDA_REFERENCE_DATA_ON_PARENT foreign key (PARENT_ID) references NONRDA_REFERENCE_DATA(ID)^
create unique index IDX_NONRDA_REFERENCE_DATA_UNIQ_REFERENCE_CODE on NONRDA_REFERENCE_DATA (REFERENCE_CODE) ^
create index IDX_NONRDA_REFERENCE_DATA_ON_PARENT on NONRDA_REFERENCE_DATA (PARENT_ID)^
-- end NONRDA_REFERENCE_DATA
