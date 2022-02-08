insert into company (id, create_by, create_date, update_by, update_date, address_1, address_2, country_name, name, license_no, license_no_2, phone_1, phone_2, fax_no, tax_code, tax_percentage,tax_value) values (1, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'SOUTH DAGON YANGON', 'DOWNTOWN YANGON', 'MYANMAR', 'YM POS COMPANY', '9087654321','','+65-86074950','+959-775157446','', 'MYR', 5, 0);
insert into customer (id, create_by, create_date, update_by, update_date, company_name, name, contact_name2, home_address, delivery_address, credit_limit, mobile_phone, secondary_phone, home_phone) values(1, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'THUZAR SHOP', 'THU ZAR' , 'Mg Myo', 'No.(55) Ward(56) Home Address', '56 Market South Dagon Yangon', 0,'+959-775157446','+959-775157446','');
insert into customer (id, create_by, create_date, update_by, update_date, company_name, name, contact_name2, home_address, delivery_address, credit_limit, mobile_phone, secondary_phone, home_phone) values(2, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Myeik SHOP', 'ZAR ZAR' , 'Kyaw Kyaw', 'No.(10) Myeik Gate Haung Address', 'Gate Haung Market South Dagon Yangon', 0,'+959-775157446','+959-775157446','');

insert into vendor (id, create_by, create_date, update_by, update_date, company_name, name, contact_name2, address_1, address_2, credit_limit, primary_phone, secondary_phone, fax_no) values(1, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'GOLDEN LION SHOP', 'Hla Hla' , 'Zaw Aung', 'THEIN GYI ZAY MARKET (D) YANGON', 'THEIN GYI ZAY MARKET (E) YANGON', 0,'+959-775157446','+959-775157446','');
insert into vendor (id, create_by, create_date, update_by, update_date, company_name, name, contact_name2, address_1, address_2, credit_limit, primary_phone, secondary_phone, fax_no) values(2, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'GLOBAL STATIONARY SHOP', 'Win Win' , 'Aung Aung', 'MINGALAR MARKET (A) YANGON', 'MINGALAR MARKET (B) YANGON', 0,'+959-775157446','+959-775157446','');


insert into employee (id, create_by, create_date, update_by, update_date, user_id, home_address, delivery_address, first_name, last_name, middle_name, mobile_phone, secondary_phone, home_phone, role, company_id) values(1, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', 'No.(215) Aung Su Pan Street South Dagon Yangon', 'No.(215) Aung Su Pan Street South Dagon Yangon', 'Yin', 'Soe', 'Min','+959-775157446','+959-775157446','', 'ADMIN', 1);
insert into employee (id, create_by, create_date, update_by, update_date, user_id, home_address, delivery_address, first_name, last_name, middle_name, mobile_phone, secondary_phone, home_phone, role, company_id) values(2, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'NINI', 'No.(215) Aung Su Pan Street South Dagon Yangon', 'No.(215) Aung Su Pan Street South Dagon Yangon', 'Kyaw', 'Soe', '','+959-443141711','','', 'ADMIN', 1);
insert into employee (id, create_by, create_date, update_by, update_date, user_id, home_address, delivery_address, first_name, last_name, middle_name, mobile_phone, secondary_phone, home_phone, role, company_id) values(3, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'HZAW', 'No.(215) Aung Su Pan Street South Dagon Yangon', 'No.(215) Aung Su Pan Street South Dagon Yangon', 'Hein', 'Zaw', 'Thu Ya','+959-252427717','','', 'ADMIN', 1);
insert into employee (id, create_by, create_date, update_by, update_date, user_id, home_address, delivery_address, first_name, last_name, middle_name, mobile_phone, secondary_phone, home_phone, role, company_id) values(4, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'TZAR', 'No.(215) Aung Su Pan Street South Dagon Yangon', 'No.(215) Aung Su Pan Street South Dagon Yangon', 'Thu', 'Zar', '','+959-456425292','','', 'ADMIN', 1);
insert into employee (id, create_by, create_date, update_by, update_date, user_id, home_address, delivery_address, first_name, last_name, middle_name, mobile_phone, secondary_phone, home_phone, role, company_id) values(5, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'HAYE', 'No.(215) Aung Su Pan Street South Dagon Yangon', 'No.(215) Aung Su Pan Street South Dagon Yangon', 'Hla', 'Aye', 'Hla','+959-266668844','','', 'ADMIN', 1);

insert into warehouse (id, create_by, create_date, update_by, update_date, company_id, name) values (1, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 1, 'SOUTH DAGON WAREHOUSE YANGON');
insert into warehouse (id, create_by, create_date, update_by, update_date,  company_id, name) values (2, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 1, 'DOWNTOWN WAREHOUSE YANGON');
insert into location (id, create_by, create_date, update_by, update_date, name, warehouse_id) values (1, 'YINMIN', LOCALTIMESTAMP(3) , 'YINMIN', LOCALTIMESTAMP(3) , 'SOUTH DAGON NO(2) MARKET YANGON', 1);
insert into location (id, create_by, create_date, update_by, update_date, name, warehouse_id) values (2, 'YINMIN', LOCALTIMESTAMP(3) , 'YINMIN', LOCALTIMESTAMP(3) , 'SOUTH DAGON HOME YANGON', 1);
insert into location (id, create_by, create_date, update_by, update_date, name, warehouse_id) values (3, 'YINMIN', LOCALTIMESTAMP(3) , 'YINMIN', LOCALTIMESTAMP(3) , 'DOWNTOWN HLEDAN MARKET YANGON', 2);
insert into location (id, create_by, create_date, update_by, update_date, name, warehouse_id) values (4, 'YINMIN', LOCALTIMESTAMP(3) , 'YINMIN', LOCALTIMESTAMP(3) , 'DOWNTOWN HOME YANGON', 2);


insert into uom (id, create_by, create_date, update_by, update_date, base_uom, short_name, name, rate_to_base) values (1, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'PCS', 'PIECES ', 'PCS', 1);
insert into uom (id, create_by, create_date, update_by, update_date, base_uom, short_name, name, rate_to_base) values (2, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'PCS', 'DOZEN', 'DZ', 12);
insert into uom (id, create_by, create_date, update_by, update_date, base_uom, short_name, name, rate_to_base) values (3, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'GM', 'GRAM', 'GM', 1);
insert into uom (id, create_by, create_date, update_by, update_date, base_uom, short_name, name, rate_to_base) values (4, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'GM', 'KILO GRAM', 'KG', 1000);


insert into item_category (id, create_by, create_date, update_by, update_date,  name) values (1, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Beauty & Personal Care');
insert into item_category (id, create_by, create_date, update_by, update_date,  name) values (2, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Stationery & Batteries');
insert into item_category (id, create_by, create_date, update_by, update_date,  name) values (3, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Household Care');


insert into item_type (id, create_by, create_date, update_by, update_date,  name, category_id) values (1, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Hair Care', 1);
insert into item_type (id, create_by, create_date, update_by, update_date,  name, category_id) values (2, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Face Care', 1);
insert into item_type (id, create_by, create_date, update_by, update_date,  name, category_id) values (3, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Body Care', 1);
insert into item_type (id, create_by, create_date, update_by, update_date,  name, category_id) values (4, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Kitchen Care',3);
insert into item_type (id, create_by, create_date, update_by, update_date,  name, category_id) values (5, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'House Care',3);
insert into item_type (id, create_by, create_date, update_by, update_date,  name, category_id) values (6, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Books', 2);
insert into item_type (id, create_by, create_date, update_by, update_date,  name, category_id) values (7, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Exercise Books',2 );
insert into item_type (id, create_by, create_date, update_by, update_date,  name, category_id) values (8, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Supplement Books',2 );
insert into item_type (id, create_by, create_date, update_by, update_date,  name, category_id) values (9, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Office & School Essentials',2);


insert into brand (id, create_by, create_date, update_by, update_date, brand_type, name) values (1, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Nivea', 'Nivea Products');
insert into brand (id, create_by, create_date, update_by, update_date,  brand_type,  name) values (2, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Dove', 'Dove Products');
insert into brand (id, create_by, create_date, update_by, update_date,  brand_type,  name) values (3, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Colgate', 'Colgate Teeth Products');
insert into brand (id, create_by, create_date, update_by, update_date,  brand_type,  name) values (4, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Breeze', 'Breeze Laundry Products');

insert into item (id, create_by, create_date, update_by, update_date,  name, item_barcode, cost_price, price, quantity, uom_id,  item_type_id, location_id, brand_id) values (1, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Nivea Lotion', 1, 3000, 3500, 1000, 1 ,3, 1, 1);
insert into item (id, create_by, create_date, update_by, update_date,  name, item_barcode, cost_price, price, quantity, uom_id,  item_type_id, location_id, brand_id) values (2, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Dove Shampoo ', 1, 4000, 4500, 1000, 1 ,1, 2, 1);
insert into item (id, create_by, create_date, update_by, update_date,  name, item_barcode, cost_price, price, quantity, uom_id,  item_type_id, location_id, brand_id) values (3, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'Breeze Liquid ', 1, 10000, 10500, 1000, 1 ,4, 3, 1);
insert into item (id, create_by, create_date, update_by, update_date,  name, item_barcode, cost_price, price, quantity, uom_id,  item_type_id, location_id, brand_id) values (4, 'YINMIN', LOCALTIMESTAMP(3), 'YINMIN', LOCALTIMESTAMP(3), 'U Nyan Lin English Essay ', 1, 20000, 20500, 1000, 1 ,8, 4, null);

